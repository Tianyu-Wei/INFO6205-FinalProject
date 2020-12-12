package com.info6205.City;

import com.info6205.entity.PersonDictionary;

public class Seattle extends City {
    private static String name = "Seattle";
    private static double area = 100;
    private static int population = 8000;
    private static int infectedNum = 100;
    private static double rateMasked = 30;
    private static double rateTesting = 20;
    private static double rateGoOut = 70;
    private static double mask_index = 0.4;
    private static PersonDictionary personDictionary;

    public Seattle() {
        super(name, area, population, infectedNum, rateMasked, rateTesting, rateGoOut, mask_index, personDictionary);
    }
}
