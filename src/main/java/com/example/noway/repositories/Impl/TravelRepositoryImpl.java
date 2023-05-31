package com.example.noway.repositories.Impl;

import com.example.noway.models.entities.Travel;
import com.example.noway.repositories.TravelRepository;

import java.io.Serializable;
import java.util.Optional;

public class TravelRepositoryImpl extends BaseRepositoryImpl<Travel> implements TravelRepository, Serializable {
    @Override
    public Travel findByDestination(String destination) {
        Travel travel=em.find(Travel.class,destination);
        System.out.println("Récupération des informations de : "+travel);
        return travel;
    }

}
