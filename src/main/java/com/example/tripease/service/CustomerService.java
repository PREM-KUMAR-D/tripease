package com.example.tripease.service;

import com.example.tripease.model.Customer;
import com.example.tripease.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
        Customer savedCustomer =customerRepository.save(customer);
        return savedCustomer;
    }
}
