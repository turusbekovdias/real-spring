package com.example.demo.services;

import com.example.demo.domeins.Tariff;

/**
 * Created by Admin on 30.09.2019.
 */
public interface TariffService {
    String addNewToTariff(Tariff tariff) throws Exception;
    Tariff getTariffById(Integer id) throws Exception;
}
