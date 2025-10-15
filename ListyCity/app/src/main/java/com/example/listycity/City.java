package com.example.listycity;

/**
 * This is a class that defines a City
 */
public class City implements Comparable<City>{
    private String city;
    private String province;

    /**
     * This method is a constructor that creates a city with the given information.
     * @param city: name of the city
     * @param province: name of the province the city is in
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * This method retrieves the name of the city
     * @return city name
     */
    String getCityName(){
        return this.city;
    }

    /**
     * This method retrieves the name of the province the city is in
     * @return province name
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * This method defines how cities are compared against each other; alphabetically by city name
     * @param o the object to be compared.
     * @return integer representing order of the cities
     */
    @Override
    public int compareTo(City o) {
        return this.city.compareTo(o.getCityName());
    }
}