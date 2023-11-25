package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ParadaMongodb;

@Repository
public interface ParadaRepository extends MongoRepository<ParadaMongodb, String>{

	/*@Query("{'locacion': ?0}")
	Optional<ParadaMongodb> buscarParadaPorLocacion(String locacion);*/

}
