package com.example.noway.repositories.Impl;


import com.example.noway.models.entities.Customer;
import com.example.noway.repositories.CustomerRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer> implements CustomerRepository, Serializable {

    @Override
    public Customer findByUsername(String username) {
        EntityManager em = getEm();

        TypedQuery<Customer> query = em.createQuery(
                "SELECT u FROM Customer u WHERE u.username = :username", Customer.class);
        query.setParameter("username", username);

        return query.getSingleResult();
    }

    @Override
    public List<Customer> getAll() {
        EntityManager em = getEm();

        TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c", Customer.class);
        List<Customer> customerList = query.getResultList();

        return customerList;
    }

}
