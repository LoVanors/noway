package com.example.noway.services.Impl;

import com.example.noway.models.entities.Travel;
import com.example.noway.repositories.Impl.TravelRepositoryImpl;
import com.example.noway.repositories.TravelRepository;
import com.example.noway.services.TravelService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.mindrot.jbcrypt.BCrypt;

import java.io.Serializable;
@Named
@SessionScoped
public class TravelServiceImpl implements TravelService, Serializable {

    @Inject
    private TravelRepository travelRepository;

    public TravelServiceImpl(){this.travelRepository=new TravelRepositoryImpl();}
    @Override
    public Travel add(Travel travel) {
        if (travel.getDestination().trim().equals("")){
            throw new RuntimeException();
        }
        travelRepository.add(travel);
        return travel;
    }

    @Override
    public Travel update() {
        return null;
    }

    @Override
    public Travel delete() {
        return null;
    }
}
