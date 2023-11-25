package com.example.demo.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.TransferenciaDTO;
import com.example.demo.jwt.SystemSecurity;
import com.example.demo.model.Monopatin;
import com.example.demo.model.Parada;
import com.example.demo.model.Usuario;
import com.example.demo.model.Viaje;
import com.example.demo.repository.UsuarioRepository;

import jakarta.transaction.Transactional;


@Service
public class UsuarioService {

	@Autowired
	private final UsuarioRepository usuarioRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    
    
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Transactional
    public Iterable<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public Optional<Usuario> traerPorId(Long id) throws Exception {
        Optional<Usuario> usuarioRecuperado = usuarioRepository.findById(id);
        if (usuarioRecuperado.isPresent()) {
            return usuarioRecuperado;
        } else {
            throw new Exception("No se pudo encontrar el usuario con el ID proporcionado.");
        }
    }

    @Transactional
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Optional<Usuario> eliminarUsuario(Long id) throws Exception {
        Optional<Usuario> usuarioEliminar = this.traerPorId(id);

        if(usuarioEliminar.isPresent()) {
        	usuarioRepository.deleteById(id);
            return usuarioEliminar;
        }
        else {
            throw new Exception("Usuario no encontrado");
        }
    }

	public Object traerCercanos(String locacion) {
		 HttpHeaders headers = new HttpHeaders();
		 String authHeader = "Bearer " + SystemSecurity.getToken();
			headers.set(HttpHeaders.AUTHORIZATION, authHeader);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	     HttpEntity<Void> reqEntity = new HttpEntity<>(headers);
	     ResponseEntity<List<Monopatin>> respuesta = restTemplate.exchange(
	                "http://localhost:8003/monopatines/locacion/" + locacion,
	                HttpMethod.GET,
	                reqEntity,
	                new ParameterizedTypeReference<>() {});

	      List<Monopatin> monopatin = respuesta.getBody();
		return monopatin;
	}

}
