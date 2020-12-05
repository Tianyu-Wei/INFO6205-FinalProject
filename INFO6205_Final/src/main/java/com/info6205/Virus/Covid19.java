package com.info6205.Virus;

public class Covid19 extends Virus{

    private static String name = "Covid19";
    private static double k_factor = 0.1;
    private static double r_factor = 5.7;

    public Covid19() {
        super(name, k_factor, r_factor);
    }
}
