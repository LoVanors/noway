package com.example.noway.repositories;

import com.example.noway.models.entities.Travel;

public interface TravelRepository extends BaseRepository<Travel> {
    Travel findByDestination(String destination);
}
