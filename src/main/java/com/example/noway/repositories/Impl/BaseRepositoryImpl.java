package com.example.noway.repositories.Impl;

import com.example.noway.repositories.BaseRepository;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

public class BaseRepositoryImpl<TEntity> implements BaseRepository<TEntity> {

    protected EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction et;

    public BaseRepositoryImpl(){
        this.emf= Persistence.createEntityManagerFactory("noway");
        this.em= emf.createEntityManager();
        this.et=em.getTransaction();
    }
    @Override
    public void add(TEntity entity) {
        et.begin();
        em.persist(entity);
        et.commit();
    }

    @Override
    public Optional<TEntity> getOne() {
        return Optional.empty();
    }

    @Override
    public List<TEntity> getAll() {
        return null;
    }

    @Override
    public void update(TEntity entity) {
        et.begin();
        em.merge(entity);
        System.out.println("Modification de : "+entity);
        et.commit();
    }

    public EntityManager getEm() {
        return em;
    }
}
