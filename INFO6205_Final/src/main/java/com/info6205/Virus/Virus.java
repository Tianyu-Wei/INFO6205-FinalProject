package com.info6205.Virus;

public abstract class Virus {
    private String name;
    private double r_factor;

    private double INFECTIOUS_RATE;
    private double EXPOSE_RATE_INFECTIOUS;
    private double RECOVERED_RATE;
    private double DEATH_RATE;

    public Virus(String name, double r_factor, double infectiousRate, double exposeRateInfectious, double recoveredRate, double DEATH_RATE) {
        this.name = name;
        this.r_factor = r_factor;
        this.INFECTIOUS_RATE = infectiousRate;
        this.EXPOSE_RATE_INFECTIOUS = exposeRateInfectious;
        this.RECOVERED_RATE = recoveredRate;
        this.DEATH_RATE = DEATH_RATE;
    }


    public double getR_factor() {
        return r_factor;
    }

    public String getName() {
        return name;
    }

    public double getINFECTIOUS_RATE() {
        return INFECTIOUS_RATE;
    }

    public double getEXPOSE_RATE_INFECTIOUS() {
        return EXPOSE_RATE_INFECTIOUS;
    }

    public double getRECOVERED_RATE() {
        return RECOVERED_RATE;
    }

    public double getDEATH_RATE() {
        return DEATH_RATE;
    }
}
