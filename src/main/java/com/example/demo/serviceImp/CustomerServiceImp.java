package com.example.demo.serviceImp;

import com.example.demo.domeins.Customer;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 21.09.2019.
 */

@Service
public class CustomerServiceImp implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public String addNewToCustomer(Customer customer) throws Exception{
        String s;
        try {
            customerRepository.save(customer);
            return "Новый клиент сохранен!";
        } catch (Exception ex) {
            s = ex.getMessage();
            return s;
        }
    }

    @Override
    public Customer getCustomerById(Integer id) throws Exception {
        try {
            Customer customer = customerRepository.findById(id).get();
            return customer;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
