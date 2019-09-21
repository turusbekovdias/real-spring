package com.example.demo.services;

import com.example.demo.domeins.Customer;

/**
 * Created by Admin on 21.09.2019.
 */
public interface CustomerService {

    String addNewToCustomer(Customer customer) throws Exception;
    Customer getCustomerById(Integer id) throws Exception;

}
