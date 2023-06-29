package com.spring.demo.countryService.repositories;

import com.spring.demo.countryService.beans.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Integer> {
}
