package com.example.demo.controllers;

import com.example.demo.domeins.Tariff;
import com.example.demo.services.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractMap;

/**
 * Created by Admin on 30.09.2019.
 */
@RestController
@RequestMapping(path="/tariff")
public class TariffController {

    @Autowired
    TariffService tariffService;

    @RequestMapping(path="/addTariff", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> newTariff(@RequestBody Tariff tariff) {
        String res;
        res = addNewTariff(tariff);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
    }

    @RequestMapping(path="/getTariff", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getTariffId(@RequestParam Integer id) {
        String res;
        AbstractMap.SimpleImmutableEntry obj = getTarById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(obj.getValue());
    }

    ///////////////////////////////////////// Connection with Services

    public String addNewTariff (Tariff tariff) {
        String res;
        try {
            res = tariffService.addNewToTariff(tariff);
        }   catch (Exception ex) {
            res = "Ошибка!" + ex.getMessage();
        }
        return res;
    }

    public AbstractMap.SimpleImmutableEntry<String, Tariff> getTarById (Integer id) {
        Tariff tariff = new Tariff();
        String res = new String();
        try {
            tariff = tariffService.getTariffById(id);
        }   catch (Exception ex) {
            res = "Ошибка!" + ex.getMessage();
        }
        return new AbstractMap.SimpleImmutableEntry<String, Tariff>(res, tariff);
    }
}
