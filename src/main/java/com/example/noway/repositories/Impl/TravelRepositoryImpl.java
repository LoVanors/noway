package com.example.noway.repositories.Impl;

import com.example.noway.models.entities.Customer;
import com.example.noway.models.entities.Travel;
import com.example.noway.repositories.TravelRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.io.Serializable;
import java.util.Optional;
@Named
@SessionScoped
public class TravelRepositoryImpl extends BaseRepositoryImpl<Travel> implements TravelRepository, Serializable {
    @Override
    public Travel findByDestination(String destination) {
        EntityManager em = getEm();

        TypedQuery<Travel> query = em.createQuery(
                "SELECT u FROM Travel u WHERE u.destination = :destination", Travel.class);
        query.setParameter("destination", destination);

        return query.getSingleResult();
    }

}
