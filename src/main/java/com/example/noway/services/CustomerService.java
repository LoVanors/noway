package com.example.noway.services;

import com.example.noway.models.entities.Customer;

public interface CustomerService {
    Customer login(Customer newCustomer);
    Customer register(Customer customer);
}
