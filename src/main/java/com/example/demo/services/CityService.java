package com.example.demo.services;

import com.example.demo.domeins.City;

/**
 * Created by Admin on 30.09.2019.
 */
public interface CityService {

    String addNewToCity (City city) throws Exception;
    City getCityById(Integer id) throws Exception;

}
