package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * this class holds our City type objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This method adds a City type object to the cities list
     * @param c: the object to add
     */
    public void add(City c){
        if (hasCity(c))
            throw new IllegalArgumentException();
        cities.add(c);
    }

    /**
     * This method is used to get access to the cities list
     * @return the cities list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This method checks if the given city is in cities list
     * @param city: the city to be searched for in the list
     * @return false if cities list does not have the given city, true if cities list has the given city
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This method removes the given city from cities list only if that city is found in the list
     * @param c: city to remove from list
     */
    public void delete(City c){
        if (cities.contains(c))
            cities.remove(c);
        else
            throw new IllegalArgumentException();
    }

    /**
     * This method counts the cities in cities list
     * @return number of cities
     */
    public int countCities(){
        return cities.size();
    }
}
