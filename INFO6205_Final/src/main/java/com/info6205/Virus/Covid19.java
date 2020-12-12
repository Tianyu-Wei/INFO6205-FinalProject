package com.info6205.Virus;

public class Covid19 extends Virus{

    private static String name = "Covid19";
    private static double r_factor = 1.16;

    private static double INFECTIOUS_RATE = 0.8;
    private static double EXPOSE_RATE_INFECTIOUS = 0.95;
    private static double RECOVERED_RATE = 0.05;
    private static double DEATH_RATE = 0.01;
    public Covid19() {
        super(name, r_factor, INFECTIOUS_RATE, EXPOSE_RATE_INFECTIOUS, RECOVERED_RATE, DEATH_RATE);
    }
}
