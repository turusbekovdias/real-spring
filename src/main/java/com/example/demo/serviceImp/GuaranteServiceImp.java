package com.example.demo.serviceImp;

import com.example.demo.domeins.Guarante;
import com.example.demo.repositories.GuaranteRepository;
import com.example.demo.services.GuaranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 30.09.2019.
 */
@Service
public class GuaranteServiceImp implements GuaranteService {

    @Autowired
    GuaranteRepository guaranteRepository;

    @Override
    public String addNewToGuarante(Guarante guarante) throws Exception{
        String s;
        try {
            guaranteRepository.save(guarante);
            return "Новый клиент сохранен!";
        } catch (Exception ex) {
            s = ex.getMessage();
            return s;
        }
    }

    @Override
    public Guarante getGuaranteById(Integer id) throws Exception {
        try {
            Guarante guarante = guaranteRepository.findById(id).get();
            return guarante;
        } catch (Exception ex) {
            throw ex;
        }
    }

}
