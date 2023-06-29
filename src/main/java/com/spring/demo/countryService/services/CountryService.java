package com.spring.demo.countryService.services;

import com.spring.demo.countryService.beans.Country;
import com.spring.demo.countryService.controllers.AddResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class CountryService {

    static HashMap<Integer, Country> countryIdMap;

    public CountryService(){
        countryIdMap = new HashMap<Integer,Country>();

        Country indianCountry = new Country(1,"India", "Delhi");
        Country usaCountry = new Country(2,"USA", "Delhi");
        Country ukCountry = new Country(3,"UK", "Delhi");

        countryIdMap.put(1,indianCountry);
        countryIdMap.put(2, usaCountry);
        countryIdMap.put(3, ukCountry);
    }

    public List getAllCountries(){
        List countries = new ArrayList(countryIdMap.values());
        return countries;
    }

    public Country getCountryById(int id){
        Country country = countryIdMap.get(id);
        return country;
    }

    public Country getCountryByName(String name){
        Country country = null;
        for (int i:countryIdMap.keySet()){
            if(countryIdMap.get(i).getCountryName().equals(name))
                country=countryIdMap.get(i);
        }
        return country;
    }

    public Country addNewCountry(Country country){
        country.setId(getMaxId());
        countryIdMap.put(country.getId(),country);
        return country;
    }

    public Country updateCountry(Country country){
        if(country.getId()>0)
            countryIdMap.put(country.getId(),country);
        return country;
    }

    public AddResponse deleteCountry(int id){
        countryIdMap.remove(id);
        AddResponse response = new AddResponse();
        response.setId(id);
        response.setMessage("Country deleted...");
        return response;
    }

    // Utility method to get max id
    public static int getMaxId(){
        int max = 0;
        for (int id:countryIdMap.keySet())
            if(max<=id)
                max=id;
        return max+1;
    }

}
