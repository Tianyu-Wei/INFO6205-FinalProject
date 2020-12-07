package com.info6205.entity;

import com.info6205.util.CityVariables;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Person {
    private double x;
    private double y;
    private double target_x;
    private double target_y;
    private int hasSymptom;
    private boolean isInfected;
    private boolean isMasked;
    private boolean isTested;
    private boolean isQuarantine;
    private int state = State.SUSCEPTIBLE;

    public interface State {
        int SUSCEPTIBLE = 1;
        int EXPOSED = 3;
        int INFECTIOUS = 4;
        int RECOVERED = 0;
        int QUARANTINED = 2;
    }

    public Person(double x, double y, double target_x, double target_y, int hasSymptom, boolean isInfected, boolean isMasked, boolean isTested, boolean isQuarantine) {
        this.x = x;
        this.y = y;
        this.target_x = target_x;
        this.target_y = target_y;
        this.hasSymptom = hasSymptom;
        this.isInfected = isInfected;
        this.isMasked = isMasked;
        this.isTested = isTested;
        this.isQuarantine = isQuarantine;
    }

    public Person() {
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getTarget_x() {
        return target_x;
    }

    public void setTarget_x(int target_x) {
        this.target_x = target_x;
    }

    public double getTarget_y() {
        return target_y;
    }

    public void setTarget_y(int target_y) {
        this.target_y = target_y;
    }

    public int getHasSymptom() {
        return hasSymptom;
    }

    public void setHasSymptom(int hasSymptom) {
        this.hasSymptom = hasSymptom;
    }

    public boolean isInfected() {
        return isInfected;
    }

    public void setInfected(boolean infected) {
        isInfected = infected;
    }

    public boolean isMasked() {
        return isMasked;
    }

    public void setMasked(boolean masked) {
        isMasked = masked;
    }

    public boolean isTested() {
        return isTested;
    }

    public void setTested(boolean tested) {
        isTested = tested;
    }

    public boolean isQuarantine() {
        return isQuarantine;
    }

    public void setQuarantine(boolean quarantine) {
        isQuarantine = quarantine;
    }


    /*
    How does a person move to the target place, one day need to update move 8 times
     */
    public void move() {
        // people who are at home
        if (target_x == x && target_y == y) return;

        // when people not arrive, keep moving
        double dx = target_x - x;
        double dy = target_y - y;

        x += dx / 8.0;
        y += dy / 8.0;
        System.out.println("this person moved");
    }

    public double distance(double x2, double y2) {
        return Math.sqrt(Math.pow( x- x2, 2) + Math.pow(y - y2, 2));
    }

    public void updateState() {
        PersonDictionary personDictionary = new PersonDictionary();
        CityVariables cityVariables = new CityVariables();

        if (state == State.RECOVERED) {}

        if (state == State.SUSCEPTIBLE) {
            for (Person person : personDictionary.getPersonList()) {
                double randomValue = ThreadLocalRandom.current().nextDouble(0.5, 8);
                if (cityVariables.getSocialDistancingIndex(distance(person.getX(), person.getY())) < 0.25) {
                    if (CityVariables.MASK_INDEX * CityVariables.R_VALUE < 1) {
                        continue;
                    }
                }

                double probability = CityVariables.INFECTIOUS_RATE * CityVariables.MASK_INDEX * cityVariables.getSocialDistancingIndex(randomValue);

                double random = new Random().nextDouble();
                if (random < probability) {
                    //transit to panel
                    break;
                }
            }
        }

        if (state == State.EXPOSED) {
            for (Person person : personDictionary.getPersonList()) {
                double randomValue = ThreadLocalRandom.current().nextDouble(0.5, 8);
                if (cityVariables.getSocialDistancingIndex(distance(person.getX(), person.getY())) < 0.25) {
                    if (CityVariables.MASK_INDEX * CityVariables.R_VALUE < 1) {
                        continue;
                    }
                }

                double probability = CityVariables.INFECTIOUS_RATE * CityVariables.MASK_INDEX * cityVariables.getSocialDistancingIndex(randomValue) * CityVariables.EXPOSE_RATE_INFECTIOUS;

                double random = new Random().nextDouble();
                if (random < probability) {
                    //transit to panel
                    break;
                }
            }
        }

        if (state == State.INFECTIOUS) {
            float random = new Random().nextFloat();
            if (random < CityVariables.RECOVERED_RATE) {
                this.state = State.RECOVERED;
            }
        }

        if (state == State.QUARANTINED) {
            double probability = CityVariables.RECOVERED_RATE;
            double random = new Random().nextDouble();
            if (random < probability) {
                //transit to panel
            }
        }
        move();
    }


}
