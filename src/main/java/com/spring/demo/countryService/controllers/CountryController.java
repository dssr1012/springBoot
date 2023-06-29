package com.spring.demo.countryService.controllers;

import com.spring.demo.countryService.beans.Country;
import com.spring.demo.countryService.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/getCountries")
    public List getCountries(){
        return  countryService.getAllCountries();
    }

    @GetMapping("/getCountries/{id}")
    public Country getCountriesById(@PathVariable(value = "id") int id){
        return  countryService.getCountryById(id);
    }

    @GetMapping("/getCountries/countryname")
    public Country getCountriesById(@RequestParam(value = "name") String countryName){
        return  countryService.getCountryByName(countryName);
    }

    @PostMapping("/addcountry")
    public Country addCountry(@RequestBody Country country){
        return countryService.addNewCountry(country);
    }

    @PutMapping("/updatecountry")
    public Country updateCountry(@RequestBody Country country){
        return countryService.updateCountry(country);
    }

    @DeleteMapping("/deletecountry/{id}")
    public AddResponse updateCountry(@PathVariable(value = "id") int id){
        return countryService.deleteCountry(id);
    }

}
