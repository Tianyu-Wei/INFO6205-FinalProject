package com.info6205.City;

import com.info6205.entity.PersonDictionary;
import com.info6205.util.InitPerson;

public abstract class City {
    private String name;
    private double area;
    private int population;
    private int infectedNum;
    private double rateMasked;
    private double rateTesting;
    private double rateGoOut;
    private  double mask_index;
    private PersonDictionary personDirectory;

    public City(String name, double area, int population, int infectedNum, double rateMasked, double rateTesting, double rateGoOut, double mask_index, PersonDictionary personDictionary) {
        this.name = name;
        this.area = area;
        this.population = population;
        this.infectedNum = infectedNum;
        this.rateMasked = rateMasked;
        this.rateTesting = rateTesting;
        this.rateGoOut = rateGoOut;
        this.mask_index = mask_index;
        this.personDirectory = personDictionary;
        this.personDirectory = InitPerson.getPersonDirectory(population, infectedNum, rateMasked, rateGoOut, rateTesting);
    }

    public String getName() {
        return name;
    }


    public City() {
    }

    public double getArea() {
        return area;
    }

    public int getPopulation() {
        return population;
    }

    public int getInfectedNum() {
        return infectedNum;
    }

    public double getRateMasked() {
        return rateMasked;
    }

    public double getRateTesting() {
        return rateTesting;
    }

    public double getRateGoOut() {
        return rateGoOut;
    }

    public double getMask_index() {
        return mask_index;
    }

    public PersonDictionary getPersonDirectory() {
        return personDirectory;
    }

}
