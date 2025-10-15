package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity(){
        return new City("Edmonton","AB");
    }
    @Test
    public void testAdd(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City c = new City("Regina", "SK");
        cityList.add(c);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(c));
    }

    @Test
    public void testAddException(){
        CityList cityList = mockCityList();
        City c = new City("Yellowknife", "NW");
        cityList.add(c);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(c);
        });
    }
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City c = new City("Vancouver", "BC");
        assertFalse(cityList.hasCity(c));
        cityList.add(c);
        assertTrue(cityList.hasCity(c));
    }
    @Test
    void testDeleteCity(){
        CityList cityList = mockCityList();
        City c = new City("Calgary","AB");
        cityList.add(c);
        assertTrue(cityList.hasCity(c));
        cityList.delete(c);
        assertFalse(cityList.hasCity(c));
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(c);
        });
    }
    @Test
    void testCountCities(){
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());
        City c1 = mockCity();
        cityList.add(c1);
        assertEquals(1, cityList.countCities());
        City c2 = new City("City", "PC");
        cityList.add(c2);
        assertEquals(2, cityList.countCities());
    }
}
