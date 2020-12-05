package com.info6205.City;

public abstract class City {
    private String name;
    private double area;
    private int population;
    private int infectedNum;
    private int popOutFlow;
    private int popInFlow;
    private boolean isQuarantine;
    private double rateMasked;
    private String picURI;
    private int testingNum;
    private double rateGoOut;

    public City(String name, double area, int population, int infectedNum, int popOutFlow, int popInFlow, boolean isQuarantine, double rateMasked, String picURI, int testingNum, double rateGoOut) {
        this.name = name;
        this.area = area;
        this.population = population;
        this.infectedNum = infectedNum;
        this.popOutFlow = popOutFlow;
        this.popInFlow = popInFlow;
        this.isQuarantine = isQuarantine;
        this.rateMasked = rateMasked;
        this.picURI = picURI;
        this.testingNum = testingNum;
        this.rateGoOut = rateGoOut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRateGoOut() {
        return rateGoOut;
    }

    public void setRateGoOut(double rateGoOut) {
        this.rateGoOut = rateGoOut;
    }

    public City() {
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getInfectedNum() {
        return infectedNum;
    }

    public void setInfectedNum(int infectedNum) {
        this.infectedNum = infectedNum;
    }

    public int getPopOutFlow() {
        return popOutFlow;
    }

    public void setPopOutFlow(int popOutFlow) {
        this.popOutFlow = popOutFlow;
    }

    public int getPopInFlow() {
        return popInFlow;
    }

    public void setPopInFlow(int popInFlow) {
        this.popInFlow = popInFlow;
    }

    public boolean isQuarantine() {
        return isQuarantine;
    }

    public void setQuarantine(boolean quarantine) {
        isQuarantine = quarantine;
    }

    public double getRateMasked() {
        return rateMasked;
    }

    public void setRateMasked(double rateMasked) {
        this.rateMasked = rateMasked;
    }

    public String getPicURI() {
        return picURI;
    }

    public void setPicURI(String picURI) {
        this.picURI = picURI;
    }

    public int getTestingNum() {
        return testingNum;
    }

    public void setTestingNum(int testingNum) {
        this.testingNum = testingNum;
    }
}
