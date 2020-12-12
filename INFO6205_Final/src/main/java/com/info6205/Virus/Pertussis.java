package com.info6205.Virus;

public class Pertussis extends Virus {
    private static String name = "Pertussis";
    private static double r_factor = 5.5;

    private static double INFECTIOUS_RATE = 0.75;
    private static double EXPOSE_RATE_INFECTIOUS = 0.613;
    private static double RECOVERED_RATE = 0.32;
    private static double DEATH_RATE = 0.0005;

    public Pertussis() {
        super(name, r_factor, INFECTIOUS_RATE, EXPOSE_RATE_INFECTIOUS, RECOVERED_RATE, DEATH_RATE);
    }
}
