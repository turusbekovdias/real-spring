package com.example.demo.repositories;

import com.example.demo.domeins.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Admin on 21.09.2019.
 */

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
