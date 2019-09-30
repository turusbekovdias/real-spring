package com.example.demo.services;

import com.example.demo.domeins.Guarante;

/**
 * Created by Admin on 30.09.2019.
 */
public interface GuaranteService {
    String addNewToGuarante(Guarante guarante) throws Exception;
    Guarante getGuaranteById(Integer id) throws Exception;

}
