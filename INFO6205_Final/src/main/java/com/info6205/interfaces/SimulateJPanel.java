package com.info6205.interfaces;

import com.info6205.City.City;
import com.info6205.Virus.Virus;
import com.info6205.entity.Person;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class SimulateJPanel extends Panel implements Runnable{

    private City selectedCity;
    private Virus selectedVirus;
    public SimulateJPanel(City selectedCity, Virus selectedVirus) {

        super();
        this.selectedCity = selectedCity;
        this.selectedVirus = selectedVirus;
    }

    @Override
    public void paint(Graphics graph) {
        super.paint(graph);
        int width;
        int height;

        graph.setColor(Color.BLACK);
        for (Person person : selectedCity.getPersonDirectory().getPersonList()) {
            if (person.getState() == Person.State.SUSCEPTIBLE) {
                graph.setColor(Color.YELLOW);
            } else if (person.getState() == Person.State.QUARANTINED) {
                graph.setColor(Color.BLUE);
            } else if (person.getState() == Person.State.EXPOSED) {
                graph.setColor(Color.MAGENTA);
            } else if (person.getState() == Person.State.INFECTIOUS) {
                graph.setColor(Color.RED);
            } else if (person.getState() == Person.State.RECOVERED) {
                graph.setColor(Color.GREEN);
            }
            System.out.println(person.getX());
            person.updateState();
            System.out.println(person.getX());
            System.out.println();
            graph.fillOval((int)person.getX(), (int)person.getY(), 5, 5);
        }
    }


    public static int worldTime = 0;

    public Timer timer = new Timer();

    @Override
    public void run() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                SimulateJPanel.this.repaint();
                System.out.println(worldTime);
                worldTime++;
            }
        }, 0, 1000);
    }
}
