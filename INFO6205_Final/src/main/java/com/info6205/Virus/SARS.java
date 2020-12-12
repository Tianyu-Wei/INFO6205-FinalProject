package com.info6205.Virus;

public class SARS extends Virus {
    private static String name = "SARS";
    private static double r_factor = 0.64;

    private static double INFECTIOUS_RATE = 0.63;
    private static double EXPOSE_RATE_INFECTIOUS = 0.768;
    private static double RECOVERED_RATE = 0.15;
    private static double DEATH_RATE = 0.005;

    public SARS() {
        super(name, r_factor, INFECTIOUS_RATE, EXPOSE_RATE_INFECTIOUS, RECOVERED_RATE, DEATH_RATE);
    }
}
