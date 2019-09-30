package com.example.demo.controllers;

import com.example.demo.domeins.Guarante;
import com.example.demo.services.GuaranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractMap;

/**
 * Created by Admin on 30.09.2019.
 */
@RestController
@RequestMapping(path="/guarante")
public class GuaranteController {

    @Autowired
    GuaranteService guaranteService;

    @RequestMapping(path="/addGuarante", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> newGuarante(@RequestBody Guarante guarante) {
        String res;
        res = addNewGuarante(guarante);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
    }

    @RequestMapping(path="/getGuarante", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getGuaranteId(@RequestParam Integer id) {
        String res;
        AbstractMap.SimpleImmutableEntry obj = getGuaById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(obj.getValue());
    }

    ///////////////////////////////////////// Connection with Services

    public String addNewGuarante (Guarante guarante) {
        String res;
        try {
            res = guaranteService.addNewToGuarante(guarante);
        }   catch (Exception ex) {
            res = "Ошибка!" + ex.getMessage();
        }
        return res;
    }

    public AbstractMap.SimpleImmutableEntry<String, Guarante> getGuaById (Integer id) {
        Guarante guarante = new Guarante();
        String res = new String();
        try {
            guarante = guaranteService.getGuaranteById(id);
        }   catch (Exception ex) {
            res = "Ошибка!" + ex.getMessage();
        }
        return new AbstractMap.SimpleImmutableEntry<String, Guarante>(res, guarante);
    }
}
