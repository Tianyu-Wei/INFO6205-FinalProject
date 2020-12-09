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

    // Changeable variables

    public static int ORIGIN_INFECTED_COUNT = 50;
    /* [-0.99, 0.99]
     * 0.99 is uncontrolled situation, the virus will transmit fast.
     * -0.99 is that no body is moving.
     */
    public static float WILLING_TO_MOVE = 0.99f;

    // Constants
    public static float INFECT_RATE = 0.8f;
    public static float INCUBATION_INFECT_RATE = 0.5f;
    public static float INCUBATION_PERIOD = 140;// 140 = 14 days
    public static float RECOVER_RATE = 0.1f;

    /*
     * The size of the city, nobody is moving out of the city
     */
    public static final int CITY_WIDTH = 700;
    public static final int CITY_HEIGHT = 800;
}
