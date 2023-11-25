package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Tarifa;

@Repository
public interface TarifaRepository extends CrudRepository<Tarifa, Long>{

    @Query("""
            SELECT t 
            FROM Tarifa t 
            ORDER BY t.fechaEntradaVigencia DESC 
            LIMIT 1
            """)
    public Optional<Tarifa> buscarUltimaTarifa();
}
