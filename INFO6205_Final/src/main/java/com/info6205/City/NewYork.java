package com.info6205.City;

import com.info6205.entity.PersonDictionary;

public class NewYork extends City {

    private static String name = "New York";
    private static double area = 100;
    private static int population = 10000;
    private static int infectedNum = 100;
    private static double rateMasked = 40;
    private static double rateTesting = 20;
    private static double rateGoOut = 60;
    private static double mask_index = 0.5;
    private static PersonDictionary personDictionary;

    public NewYork() {
        super(name, area, population, infectedNum, rateMasked, rateTesting, rateGoOut, mask_index, personDictionary);
    }
}
