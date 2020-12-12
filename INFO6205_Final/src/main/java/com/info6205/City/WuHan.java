package com.info6205.City;

import com.info6205.entity.PersonDictionary;

public class WuHan extends City {
    private static String name = "WuHan";
    private static double area = 100;
    private static int population = 3000;
    private static int infectedNum = 100;
    private static double rateMasked = 80;
    private static double rateTesting = 70;
    private static double rateGoOut = 20;
    private static double mask_index = 0.7;
    private static PersonDictionary personDictionary;

    public WuHan() {
        super(name, area, population, infectedNum, rateMasked, rateTesting, rateGoOut, mask_index, personDictionary);
    }
}
