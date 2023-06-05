package com.example.noway.services.Impl;

import com.example.noway.exceptions.EntityNotFoundException;
import com.example.noway.exceptions.InvalidPasswordException;
import com.example.noway.models.entities.Customer;
import com.example.noway.repositories.CustomerRepository;
import com.example.noway.services.CustomerService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.mindrot.jbcrypt.BCrypt;

import java.io.Serializable;

@Named
@SessionScoped
public class CustomerServiceImpl implements CustomerService, Serializable {

    @Inject
    CustomerRepository customerRepository;

    @Override
    public Customer login(Customer newCustomer) {
        String login = newCustomer.getUsername();
        Customer customer = customerRepository.findByUsername(login);
        if (customer == null) {
            throw new EntityNotFoundException("ce compte n'existe pas");
        }
        //if (!BCrypt.checkpw(newCustomer.getPassword(), customer.getPassword())) //ne fonctionne pas, pourquoi?
        if (!BCrypt.checkpw(newCustomer.getPassword(), customerRepository.findByUsername(login).getPassword())) {
            throw new InvalidPasswordException("mot de passe invalide");
        }
        return customer;
    }

    @Override
    public Customer register(Customer customer) {
        if (customer.getUsername().trim().equals("")){
            throw new RuntimeException();
        }
        if (customer.getEmail().trim().equals("")){
            throw new RuntimeException();
        }
        if (customer.getPassword().trim().equals("")){
            throw new RuntimeException();
        }
        customer.setPassword(BCrypt.hashpw(customer.getPassword(),BCrypt.gensalt()));
        customerRepository.add(customer);
        return customer;
    }

    @Override
    public Customer delete(Customer customer) {
        customerRepository.delete(customer);
        return null;
    }


}
