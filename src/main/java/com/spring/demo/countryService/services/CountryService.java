package com.spring.demo.countryService.services;

import com.spring.demo.countryService.beans.Country;
import com.spring.demo.countryService.controllers.AddResponse;
import com.spring.demo.countryService.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries(){
       return countryRepository.findAll();
    }

    public Country getCountryById(int id){
        return countryRepository.findById(id).get();
    }

    public Country getCountryByName(String name){
        List <Country> countries = countryRepository.findAll();
        Country country = null;
        for(Country con:countries){
            if(con.getCountryName().equalsIgnoreCase(name))
                country=con;
        }
        return country;
    }

    public Country addNewCountry(Country country){
        country.setId(getMaxId());
        countryRepository.save(country);
        return country;
    }

    public Country updateCountry(Country country){
        countryRepository.save(country);
        return country;
    }

    public AddResponse deleteCountry(int id){
        countryRepository.deleteById(id);
        AddResponse response = new AddResponse();
        response.setMessage("Deleted...");
        response.setId(id);
        return response;
    }

    // Utility method to get max id
    public int getMaxId(){
        return countryRepository.findAll().size()+1;
    }

}
