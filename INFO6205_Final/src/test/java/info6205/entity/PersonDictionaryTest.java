package info6205.entity;

import com.info6205.City.City;
import com.info6205.City.CityDictionary;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonDictionaryTest {

    @Test
    public void bostonDictionaryPopulationTest() {
        City city = CityDictionary.getInstance().searchCityByName("Boston");
        int i = city.getPopulation();
        assertEquals(5000, i);
    }

    @Test
    public void newYorkDirectoryPopulationTest() {
        City city = CityDictionary.getInstance().searchCityByName("New York");
        int i = city.getPopulation();
        assertEquals(10000, i);
    }

    @Test
    public void seattleDirectoryPopulationTest() {
        City city = CityDictionary.getInstance().searchCityByName("Seattle");
        int i = city.getPopulation();
        assertEquals(8000, i);
    }

    @Test
    public void wuhanDirectoryPopulationTest() {
        City city = CityDictionary.getInstance().searchCityByName("WuHan");
        int i = city.getPopulation();
        assertEquals(3000, i);
    }
}
