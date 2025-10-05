package com.example.tripease.service;

import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
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

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setAge(customerRequest.getAge());
        customer.setEmailId(customerRequest.getEmailId());
        customer.setGender(customerRequest.getGender());

        Customer savedCustomer =customerRepository.save(customer);

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setAge(savedCustomer.getAge());
        customerResponse.setEmailId(savedCustomer.getEmailId());
        customerResponse.setAge(savedCustomer.getAge());

        return customerResponse;
    }

    public CustomerResponse getCustomerById(int customerId) {
        Optional<Customer> optionalCustomer= customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid customer Id");
        }
        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setName(optionalCustomer.get().getName());
        customerResponse.setAge(optionalCustomer.get().getAge());
        customerResponse.setEmailId(optionalCustomer.get().getEmailId());
        return customerResponse;
    }
}
