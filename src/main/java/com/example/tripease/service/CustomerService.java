package com.example.tripease.service;

import com.example.tripease.exception.CustomerNotFoundException;
import com.example.tripease.model.Customer;
import com.example.tripease.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
        Customer savedCustomer =customerRepository.save(customer);
        return savedCustomer;
    }

    public Customer getCustomerById(int customerId) {
        Optional<Customer> optionalCustomer= customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid customer Id");
        }
        return optionalCustomer.get();
    }
}
