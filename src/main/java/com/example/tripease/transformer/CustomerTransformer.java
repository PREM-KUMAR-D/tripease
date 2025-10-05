package com.example.tripease.transformer;

import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.model.Customer;

public class CustomerTransformer {
    public static Customer customerRequestToCustomer(CustomerRequest customerRequest){

        return  Customer.builder().name(customerRequest.getName())
                .age(customerRequest.getAge())
                .emailId(customerRequest.getEmailId())
                .gender(customerRequest.getGender())
                .build();
    }
    public static CustomerResponse customerToCustomerResponse(Customer customer){

        return CustomerResponse.builder()
                .age(customer.getAge())
                .emailId(customer.getEmailId())
                .name(customer.getName())
                .build();

    }
}
