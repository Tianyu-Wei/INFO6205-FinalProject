package com.info6205.Virus;

public abstract class Virus {
    private String name;
    private double k_factor;
    private double r_factor;

    public Virus() {
    }

    public Virus(String name, double k_factor, double r_factor) {
        this.name = name;
        this.k_factor = k_factor;
        this.r_factor = r_factor;
    }

    public double getK_factor() {
        return k_factor;
    }

    public void setK_factor(double k_factor) {
        this.k_factor = k_factor;
    }

    public double getR_factor() {
        return r_factor;
    }

    public void setR_factor(double r_factor) {
        this.r_factor = r_factor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
