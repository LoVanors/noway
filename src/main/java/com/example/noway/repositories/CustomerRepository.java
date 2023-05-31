package com.example.noway.repositories;

import com.example.noway.models.entities.Customer;

public interface CustomerRepository extends BaseRepository<Customer> {
    Customer findByUsername(String username);
}
