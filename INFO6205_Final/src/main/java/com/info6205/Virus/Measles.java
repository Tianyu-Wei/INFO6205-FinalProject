package com.info6205.Virus;

public class Measles extends Virus {
    private static String name = "Measles";
    private static double r_factor = 14;

    private static double INFECTIOUS_RATE = 0.93;
    private static double EXPOSE_RATE_INFECTIOUS = 0.822;
    private static double RECOVERED_RATE = 0.08;
    private static double DEATH_RATE = 0.001;

    public Measles() {
        super(name, r_factor, INFECTIOUS_RATE, EXPOSE_RATE_INFECTIOUS, RECOVERED_RATE, DEATH_RATE);
    }
}
