package info6205.City;

import com.info6205.City.City;
import com.info6205.City.CityDictionary;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CityDictionaryTest {

    private CityDictionary cityDictionary = new CityDictionary();

    @Test
    public void searchCityByNameTest() {
        City searchCity = cityDictionary.searchCityByName("Boston");

        assertEquals(searchCity.getName(), "Boston");
    }
}
