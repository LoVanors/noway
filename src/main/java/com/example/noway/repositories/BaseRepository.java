package com.example.noway.repositories;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<TEntity> {

    void add(TEntity entity);

    Optional<TEntity> getOne();

    List<TEntity> getAll();

    void update(TEntity entity);

    void delete(TEntity entity);

}
