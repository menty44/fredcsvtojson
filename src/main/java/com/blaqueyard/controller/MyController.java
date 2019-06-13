package com.blaqueyard.controller;

import java.util.List;

import com.blaqueyard.model.Country;
import com.blaqueyard.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private ICountryService countryService;

    @RequestMapping("/countries")
    public List<Country> listCountries() {

        return countryService.findAll();
    }
}
