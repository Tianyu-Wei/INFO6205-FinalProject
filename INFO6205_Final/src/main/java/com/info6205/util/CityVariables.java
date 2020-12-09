package com.info6205.util;

public class CityVariables {

    public CityVariables() {
    }

    public static int INITIAL_INFECTED_COUNT = 10;
    public static int TOTAL_POPULATION = 600000;
    public static double R_VALUE = 1.16;
    public static double INFECTIOUS_RATE = 0.012;

    public static double MASK_INDEX = 0.837;
    public static double EXPOSE_RATE_INFECTIOUS = 0.95;

    public static double RECOVERED_RATE = 0.3;

    public double getSocialDistancingIndex(double distance) {
        return 1-(18.19*Math.log(distance)+43.26)/100;
    }
}
