package com.spring.demo.countryService.controllers;

import com.spring.demo.countryService.beans.Country;
import com.spring.demo.countryService.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/getCountries")
    public List<Country> getCountries(){
        return  countryService.getAllCountries();
    }

    @GetMapping("/getCountries/{id}")
    public ResponseEntity<Country> getCountriesById(@PathVariable(value = "id") int id){
        Country country = null;
        try{
            country = countryService.getCountryById(id);
            return  new ResponseEntity<Country>(country, HttpStatus.OK);
        }catch (Exception ex){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/getCountries/countryname")
    public Country getCountriesById(@RequestParam(value = "name") String countryName){
        return  countryService.getCountryByName(countryName);
    }

    @PostMapping("/addCountry")
    public Country addCountry(@RequestBody Country country){
        return countryService.addNewCountry(country);
    }

    @PutMapping("/updateCountry")
    public Country updateCountry(@RequestBody Country country){
        return countryService.updateCountry(country);
    }

    @DeleteMapping("/deleteCountry/{id}")
    public AddResponse updateCountry(@PathVariable(value = "id") int id){
        return countryService.deleteCountry(id);
    }

}
