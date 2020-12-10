package com.info6205.entity;

import com.info6205.City.City;
import com.info6205.Virus.Virus;

import java.util.Random;

public class Person {
    private double x;
    private double y;
    private double target_x;
    private double target_y;
    private boolean hasSymptom;
    private boolean isInfected;
    private boolean isMasked;
    private boolean isTested;
    private boolean isQuarantine;
    private int state = State.SUSCEPTIBLE;
    private boolean isArrive;

    public interface State {
        int RECOVERED = 0;
        int SUSCEPTIBLE = 1;
        int QUARANTINED = 2;
        int EXPOSED = 3;
        int INFECTIOUS = 4;
        int DEATH = 5;
    }

    public Person(double x, double y, double target_x, double target_y, boolean hasSymptom, boolean isInfected, boolean isMasked, boolean isTested, boolean isQuarantine) {
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

    public boolean isTested() {
        return isTested;
    }

    public void setTested(boolean tested) {
        isTested = tested;
    }

    public boolean isArrive() {
        return isArrive;
    }

    public double getSocialDistancingIndex(double distance) {
        return 1 - (18.19 * Math.log(distance) + 43.26) / 100;
    }

    /*
    How does a person move to the target place, one day need to update move 8 times
     */
    public void move() {

        if (target_x == x && target_y == y) {
            isArrive = true;
            return;
        }

        if (isArrive) return;

        double distance = Math.sqrt(Math.pow(target_x - x, 2) + Math.pow(target_y - y, 2));
        if (distance < 1) {
            isArrive = true;
            return;
        }

        double xDir = target_x - x;
        double yDir = target_y - y;

        x += xDir / distance;
        y += yDir / distance;

    }

    public double distance(double x2, double y2) {
        return Math.sqrt(Math.pow(x- x2, 2) + Math.pow(y - y2, 2));
    }

    public void updateState(Virus selectedVirus, City selectedCity) {
        //PersonDictionary personDictionary = PersonDictionary.getInstance();

        if (state == State.SUSCEPTIBLE) {

            double distanceRandom = new Random().nextDouble();
            for (Person person : selectedCity.getPersonDirectory().getPersonList()) {

                if (getSocialDistancingIndex(distance(person.getX(), person.getY())) < 0.25) {
                    if (selectedCity.getMask_index() * selectedVirus.getR_factor() < 1) {
                        continue;
                    }
                }
                float possibility = 0;
                if(person.getState() == 1) possibility = (float) (selectedVirus.getINFECTIOUS_RATE() * selectedCity.getMask_index()  * getSocialDistancingIndex(distanceRandom)/2);

                // if the random number is less than the exposed possibility, make this person to be exposed
                float random = new Random().nextFloat();
                if (random < possibility) {
                    this.state = State.EXPOSED;
                    break;
                }
            }
        } else if (state == State.EXPOSED) {
            double distanceRandom = new Random().nextDouble();
            for (Person person : selectedCity.getPersonDirectory().getPersonList()) {
                if (getSocialDistancingIndex(distance(person.getX(), person.getY())) < 0.25) {
                    if (selectedCity.getMask_index()  * selectedVirus.getR_factor() < 1) {
                        continue;
                    }
                }

                float possibility = 0;
                if(person.getState() == 3) possibility = (float) (selectedVirus.getINFECTIOUS_RATE() * selectedCity.getMask_index()  * getSocialDistancingIndex(distanceRandom) * selectedVirus.getEXPOSE_RATE_INFECTIOUS() * 3);

                // if the random number is less than the exposed possibility, make this person to be exposed
                float random = new Random().nextFloat();
                if (random < possibility) {
                    this.state = State.INFECTIOUS;
                    break;
                }
            }
        } else if (state == State.INFECTIOUS) {
            float random = new Random().nextFloat();
            if (random < selectedVirus.getRECOVERED_RATE()) {
                this.state = State.RECOVERED;
            } else if (random >= selectedVirus.getRECOVERED_RATE() && random < (selectedVirus.getRECOVERED_RATE() + selectedVirus.getDEATH_RATE())) {
                this.state = State.DEATH;
            }

            if (isTested == true && state == State.INFECTIOUS) {
                this.state = State.QUARANTINED;
            }
        } else if (state == State.QUARANTINED) {
            double probability = selectedVirus.getRECOVERED_RATE();
            double random = new Random().nextDouble();
            if (random < probability) {
                state = State.RECOVERED;
            }
        }

        if (state == State.RECOVERED) {}
        move();
    }


}
