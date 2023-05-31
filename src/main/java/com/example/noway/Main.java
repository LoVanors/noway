package com.example.noway;

import com.example.noway.models.entities.Customer;
import com.example.noway.services.CustomerService;
import com.example.noway.services.Impl.CustomerServiceImpl;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerServiceImpl();

        Customer customer=Customer.builder()
                .username("a")
                .email("a@hotmail.com")
                .password("1234")
                .build();
        customerService.register(customer);
    }

}
