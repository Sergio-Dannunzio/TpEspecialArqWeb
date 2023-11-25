package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;


import com.example.demo.dto.MonopatinKmRecorridosDTO;
import com.example.demo.dto.MonopatinTiempoDTO;
import com.example.demo.dto.MonopatinesEstadosDTO;
import com.example.demo.model.Monopatin;
import com.example.demo.model.TokenInfo;
import com.example.demo.model.Usuario;
import com.example.demo.repository.MonopatinRepository;

import jakarta.transaction.Transactional;

@Service
public class MonopatinServiceImpl{

	private final MonopatinRepository monopatinRepository;
    private final RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	public MonopatinServiceImpl(MonopatinRepository monopatinRepository) {
		this.monopatinRepository = monopatinRepository;
	}


	public Iterable<Monopatin> findAll() {
		return this.monopatinRepository.findAll();
	}


    @Transactional
    public Monopatin traerPorId(Long id_monopatin) throws Exception {
        Optional<Monopatin> monopatin = monopatinRepository.findById(id_monopatin);

        if(monopatin.isEmpty()){
            throw new Exception("No existe un monopatin con id '" + id_monopatin);
        }

        return monopatin.get();
    }
    
    public MonopatinesEstadosDTO getEstados() {
        return monopatinRepository.getEstados();
    }

    @Transactional
    public Monopatin crear(Monopatin monopatin) throws Exception {
        return monopatinRepository.save(monopatin);
    }

    @Transactional
    public Monopatin eliminar(Long id_monopatin) throws Exception {
        Monopatin monopatin_eliminar = this.traerPorId(id_monopatin);

        monopatinRepository.deleteById(id_monopatin);
        return monopatin_eliminar;
    }


    @Transactional
    public Monopatin editar(Long idMonopatin, Monopatin nuevaInfo) throws Exception {
        Monopatin monopatin_editar = this.traerPorId(idMonopatin);

        monopatin_editar.setGps(nuevaInfo.getGps());
        monopatin_editar.setLocacion(nuevaInfo.getLocacion());
        monopatin_editar.setEstado(nuevaInfo.getEstado());

        return monopatinRepository.save(monopatin_editar);
    }

    public List<MonopatinKmRecorridosDTO> traerOrdenadosPorKilometros() throws Exception {
        return this.monopatinRepository.traerOrdenadosPorKilometrosDESC();
    }

    public List<MonopatinTiempoDTO> traerOrdenadosPorTiempoConPausas() throws Exception {
        return this.monopatinRepository.traerOrdenadosPorTiempoConPausasDESC();
    }

    public List<MonopatinTiempoDTO> traerOrdenadosPorTiempoSinPausas() throws Exception {
        return this.monopatinRepository.traerOrdenadosPorTiempoSinPausasDESC();
    }


	public List<Monopatin> traerPorLocacion(String locacion) {
		List<Monopatin> monopatines = monopatinRepository.findByLocacion(locacion);
		return monopatines;
	}

}
