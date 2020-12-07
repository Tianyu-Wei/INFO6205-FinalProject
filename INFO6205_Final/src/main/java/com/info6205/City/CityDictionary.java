package com.info6205.City;

import java.util.ArrayList;
import java.util.List;

public class CityDictionary {

    private List<City> cityList = new ArrayList<>();

    public CityDictionary() {
        City Boston = new Boston();

        cityList.add(Boston);

    }

    public List<City> getCityList() {
        return cityList;
    }

    public City searchCityByName(String name) {
        for (City city : cityList) {
            if (city.getName().equals(name)) {
                return city;
            }
        }
        return null;
    }
}
