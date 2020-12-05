package com.info6205.City;

import java.util.ArrayList;
import java.util.List;

public class CityDictionary {

    private static List<City> cityList = new ArrayList<>();

    public CityDictionary() {
        City Boston = new Boston();

        cityList.add(Boston);

    }

    public static List<City> getCityList() {
        return cityList;
    }

    public static void setCityList(List<City> cityList) {
        CityDictionary.cityList = cityList;
    }

    public static City searchCityByName(String name) {
        for (City city : cityList) {
            if (city.getName().equals(name)) {
                return city;
            }
        }
        return null;
    }
}
