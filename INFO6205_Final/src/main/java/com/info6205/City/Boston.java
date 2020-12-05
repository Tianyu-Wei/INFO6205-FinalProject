package com.info6205.City;

import com.info6205.entity.PersonDictionary;
import com.info6205.util.InitPerson;

public class Boston extends City{
    private static String name = "Boston";
    private static double area = 100;
    private static int population = 100000;
    private static int infectedNum = 2000;
    private static int popOutFlow = 100000;
    private static int popInFlow = 100000;
    private static boolean isQuarantine = true;
    private static double rateMasked = 50;
    private static String picURI;
    private static int testingNum = 500000;
    private static double rateGoOut = 50;
    private PersonDictionary personDirectory;


    public Boston() {
        super(name, area, population, infectedNum, popOutFlow, popInFlow, isQuarantine, rateMasked, picURI, testingNum, rateGoOut);
        personDirectory = InitPerson.getPersonDirectory(population, infectedNum, rateMasked, rateGoOut);
    }



}
