package com.info6205.City;

import com.info6205.entity.PersonDictionary;

public class Boston extends City {
    private static String name = "Boston";
    private static double area = 100;
    private static int population = 5000;
    private static int infectedNum = 100;
    private static double rateMasked = 50;
    private static double rateTesting = 30;
    private static double rateGoOut = 50;
    private static double mask_index = 0.6;
    private static PersonDictionary personDictionary;

    public Boston() {
        super(name, area, population, infectedNum, rateMasked, rateTesting, rateGoOut, mask_index, personDictionary);
    }
}
