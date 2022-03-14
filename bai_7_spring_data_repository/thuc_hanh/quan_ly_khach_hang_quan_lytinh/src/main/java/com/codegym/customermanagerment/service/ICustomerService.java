package com.codegym.customermanagerment.service;

import com.codegym.customermanagerment.model.Customer;
import com.codegym.customermanagerment.model.Province;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void saveCustomer(Customer customer);
    void deleteCustomer(Long id);
    Customer findCustomerById(Long id);

    List<Customer> findByName(String name);
}
