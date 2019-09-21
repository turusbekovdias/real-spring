package com.example.demo.controllers;

import com.example.demo.domeins.Customer;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractMap;

/**
 * Created by Admin on 21.09.2019.
 */

@RestController
@RequestMapping(path="/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(path="/addCustomer", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> newCustomer(@RequestBody Customer customer) {
        String res;
        res = addNewCustomer(customer);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
    }

    @RequestMapping(path="/getCustomer", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getCustomerId(@RequestParam Integer id) {
        String res;
        AbstractMap.SimpleImmutableEntry obj = getCusById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(obj.getValue());
    }

    ///////////////////////////////////////// Connection with Services

    public String addNewCustomer (Customer customer) {
        String res;
        try {
            res = customerService.addNewToCustomer(customer);
        }   catch (Exception ex) {
            res = "Ошибка!" + ex.getMessage();
        }
        return res;
    }

    public AbstractMap.SimpleImmutableEntry<String, Customer> getCusById (Integer id) {
        Customer customer = new Customer();
        String res = new String();
        try {
            customer = customerService.getCustomerById(id);
        }   catch (Exception ex) {
            res = "Ошибка!" + ex.getMessage();
        }
        return new AbstractMap.SimpleImmutableEntry<String, Customer>(res, customer);
    }

}

