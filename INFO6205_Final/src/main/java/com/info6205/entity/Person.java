package com.info6205.entity;

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
    How a person move to target place, one day need to update move 8 times
     */
    public void move() {
        // people who are at home
        if (target_x == x && target_y == y) return;

        // when people not arrive, keep moving
        double dx = target_x - x;
        double dy = target_y - y;

        x += dx / 8.0;
        y += dy / 8.0;
    }


}
