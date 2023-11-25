package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ParadaMongodb;
import com.example.demo.repository.ParadaRepository;


import jakarta.transaction.Transactional;

@Service
public class ParadaService {
	
	@Autowired
    private final ParadaRepository paradaRepository;
    
    public ParadaService(ParadaRepository paradaRepository) {
		this.paradaRepository = paradaRepository;
	}

    public List<ParadaMongodb> traerTodos() {
        return paradaRepository.findAll();
    }

    public ParadaMongodb traerPorId(String id_parada) throws Exception {
        Optional<ParadaMongodb> parada = paradaRepository.findById(id_parada);

        if(parada.isEmpty()){
            throw new Exception("No existe una parada con id '" + id_parada );
        }

        return parada.get();
    }

    public ParadaMongodb crear(ParadaMongodb parada) throws Exception {
        return paradaRepository.save(parada);
    }

    public ParadaMongodb eliminar(String id_parada) throws Exception {
    	ParadaMongodb parada_eliminar = this.traerPorId(id_parada);

        this.paradaRepository.deleteById(id_parada);
        return parada_eliminar;
    }

    public ParadaMongodb editar(String id_parada, ParadaMongodb nuevaInfo) throws Exception {
    	ParadaMongodb parada_editar = this.traerPorId(id_parada);

        parada_editar.setLocacion(nuevaInfo.getLocacion());
        parada_editar.setIsHabilitada(nuevaInfo.getIsHabilitada());

        return paradaRepository.save(parada_editar);
    }

    /*public Optional<ParadaMongodb> buscarParadaPorLocacion(String locacion) throws Exception {
        if(locacion == null){ throw new Exception("La locacion es nula"); }

        return this.paradaRepository.buscarParadaPorLocacion(locacion);
    }*/
}