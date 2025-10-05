package com.example.tripease.service;

import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.exception.CustomerNotFoundException;
import com.example.tripease.model.Customer;
import com.example.tripease.repository.CustomerRepository;
import com.example.tripease.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {

        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);

        Customer savedCustomer =customerRepository.save(customer);

        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public CustomerResponse getCustomerById(int customerId) {
        Optional<Customer> optionalCustomer= customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid customer Id");
        }
        Customer savedCustomer = optionalCustomer.get();

        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }


}
