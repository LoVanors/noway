package com.example.noway;

import com.example.noway.models.entities.Customer;
import com.example.noway.models.entities.Travel;
import com.example.noway.repositories.CustomerRepository;
import com.example.noway.repositories.Impl.CustomerRepositoryImpl;
import com.example.noway.services.CustomerService;
import com.example.noway.services.Impl.CustomerServiceImpl;
import com.example.noway.services.Impl.TravelServiceImpl;
import com.example.noway.services.TravelService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerServiceImpl();
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
//
//        Customer customer=Customer.builder()
//                .username("a")
//                .email("a@hotmail.com")
//                .password("1234")
//                .build();
//        customerService.register(customer);
//        TravelService travelService = new TravelServiceImpl();
//
//        Travel travel = Travel.builder()
//                .destination("test2")
//                .description("ceci est un test")
//                .price(Double.valueOf(3.2))
//                .startDate(LocalDate.of(2024,1,1))
//                .endDate(LocalDate.of(2024,1,2))
//                .image("images/logo.jpg")
//                .build();
//        travelService.add(travel);

        List<Customer> customerList=customerRepository.getAll();
        for (Customer cus: customerList) {
            System.out.println(cus.toString());

        }
    }

}
