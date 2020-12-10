package com.info6205.City;

import java.util.ArrayList;
import java.util.List;

public class CityDictionary {

    private List<City> cityList = new ArrayList<>();

    public CityDictionary() {
        City Boston = new Boston();
        City WuHan = new WuHan();
        City Seattle = new Seattle();
        City NewYork = new NewYork();
        cityList.add(Boston);
        cityList.add(WuHan);
        cityList.add(Seattle);
        cityList.add(NewYork);
    }

    public List<City> getCityList() {
        return cityList;
    }

    private static CityDictionary cityDictionary = new CityDictionary();

    public static CityDictionary getInstance() {
        return cityDictionary;
    }

    public static City searchCityByName(String name) {
        for (City city : CityDictionary.getInstance().getCityList()) {
            if (city.getName().equals(name)) {
                return city;
            }
        }
        return null;
    }
}
