package com.cebem.medidor.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cebem.medidor.models.Mision;

public interface MisionRepository extends MongoRepository<Mision, String> {
    List<Mision> findByDificultad(String dificultad);

    List<Mision> findByResultado(String resultado);

    List<Mision> findByDificultadAndResultado(String dificultad, String resultado);
}