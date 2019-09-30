package com.example.demo.serviceImp;

import com.example.demo.domeins.City;
import com.example.demo.repositories.CityRepository;
import com.example.demo.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 30.09.2019.
 */
@Service
public class CityServiceImp implements CityService{

    @Autowired
    CityRepository cityRepository;

    @Override
    public String addNewToCity(City city) throws Exception{
        String s;
        try {
            cityRepository.save(city);
            return "Новый клиент сохранен!";
        } catch (Exception ex) {
            s = ex.getMessage();
            return s;
        }
    }

    @Override
    public City getCityById(Integer id) throws Exception {
        try {
            City city = cityRepository.findById(id).get();
            return city;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
