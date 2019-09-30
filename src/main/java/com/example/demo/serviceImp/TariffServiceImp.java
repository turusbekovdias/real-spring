package com.example.demo.serviceImp;

import com.example.demo.domeins.Tariff;
import com.example.demo.repositories.TariffRepository;
import com.example.demo.services.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 30.09.2019.
 */
@Service
public class TariffServiceImp implements TariffService{

    @Autowired
    TariffRepository tariffRepository;

    @Override
    public String addNewToTariff(Tariff tariff) throws Exception{
        String s;
        try {
            tariffRepository.save(tariff);
            return "Новый клиент сохранен!";
        } catch (Exception ex) {
            s = ex.getMessage();
            return s;
        }
    }

    @Override
    public Tariff getTariffById(Integer id) throws Exception {
        try {
            Tariff tariff = tariffRepository.findById(id).get();
            return tariff;
        } catch (Exception ex) {
            throw ex;
        }
    }

}
