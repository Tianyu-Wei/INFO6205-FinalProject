package com.info6205.interfaces;

import com.info6205.City.City;
import com.info6205.Virus.Virus;
import com.info6205.entity.Person;
import com.info6205.entity.PersonDictionary;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
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
        //super.paint(graph);
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
            } else {
                continue;
            }
            person.updateState(selectedVirus, selectedCity);
            graph.fillOval((int)person.getX(), (int)person.getY(), 5, 5);
        }
    }

    public File WriteStuCSV() {
        File csvFile = new File("Data.csv");
        FileOutputStream fos = null;
        int recoverNum = this.getPopulation(0);
        int susNum = this.getPopulation(1);
        int quarantineNum = this.getPopulation(2);
        int exposedNum = this.getPopulation(3);
        int infectNum = this.getPopulation(4);
        int deathNum = this.getPopulation(5);
        // try with resources: all resources in () are closed at conclusion of try clause
        try {	// open output stream to output file for writing purpose.
            if(!csvFile.exists()){
                csvFile.createNewFile();
                fos = new FileOutputStream(csvFile);
            }else{
                fos = new FileOutputStream(csvFile,true);
            }
            OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");
            out.write(recoverNum + "," + susNum + "," + quarantineNum + "," + exposedNum + "," + infectNum + "," + deathNum);
            out.write("\n");
            out.close();
            return csvFile;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    public static int worldTime = 0;

    public Timer timer = new Timer();

    @Override
    public void run() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                SimulateJPanel.this.repaint();
                System.out.println("Recover: " + SimulateJPanel.this.getPopulation(0) + " Susceptible:  " + SimulateJPanel.this.getPopulation(1)
                + " Quarantined:  " + SimulateJPanel.this.getPopulation(2) + " Exposed: " + SimulateJPanel.this.getPopulation(3) + " Infected: " + SimulateJPanel.this.getPopulation(4)
                + " Death: " + SimulateJPanel.this.getPopulation(5));
                WriteStuCSV();
                worldTime++;
            }
        }, 0, 200);
    }

    public int getPopulation(int state) {
        int number = 0;
        for (Person person : selectedCity.getPersonDirectory().getPersonList()) {
            if (person.getState() == Person.State.SUSCEPTIBLE && state == Person.State.SUSCEPTIBLE) {
                number++;
            } else if (person.getState() == Person.State.QUARANTINED && state == Person.State.QUARANTINED) {
                number++;
            } else if (person.getState() == Person.State.EXPOSED && state == Person.State.EXPOSED) {
                number++;
            } else if (person.getState() == Person.State.INFECTIOUS && state == Person.State.INFECTIOUS) {
                number++;
            } else if (person.getState() == Person.State.RECOVERED && state == Person.State.RECOVERED) {
                number++;
            } else if (person.getState() == Person.State.DEATH && state == Person.State.DEATH) {
                number++;
            }
        }
        return number;
    }
}
