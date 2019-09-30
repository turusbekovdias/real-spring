package com.example.demo.controllers;

import com.example.demo.domeins.City;
import com.example.demo.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractMap;

/**
 * Created by Admin on 30.09.2019.
 */
@RestController
@RequestMapping(path="/city")
public class CityController {

    @Autowired
    CityService cityService;

    @RequestMapping(path="/addCity", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> newCity(@RequestBody City city) {
        String res;
        res = addNewCity(city);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
    }

    @RequestMapping(path="/getCity", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getCityId(@RequestParam Integer id) {
        String res;
        AbstractMap.SimpleImmutableEntry obj = getCitById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(obj.getValue());
    }

    ///////////////////////////////////////// Connection with Services

    public String addNewCity (City city) {
        String res;
        try {
            res = cityService.addNewToCity(city);
        }   catch (Exception ex) {
            res = "Ошибка!" + ex.getMessage();
        }
        return res;
    }

    public AbstractMap.SimpleImmutableEntry<String, City> getCitById (Integer id) {
        City city = new City();
        String res = new String();
        try {
            city = cityService.getCityById(id);
        }   catch (Exception ex) {
            res = "Ошибка!" + ex.getMessage();
        }
        return new AbstractMap.SimpleImmutableEntry<String, City>(res, city);
    }
}
