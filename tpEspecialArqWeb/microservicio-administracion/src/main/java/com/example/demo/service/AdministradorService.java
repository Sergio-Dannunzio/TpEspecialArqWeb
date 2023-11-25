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

import com.example.demo.dto.MonopatinKilometrajeDTO;
import com.example.demo.dto.MonopatinTiempoDTO;
import com.example.demo.jwt.SystemSecurity;
import com.example.demo.model.Viaje;
import com.example.demo.model.classes.Monopatin;
import com.example.demo.model.classes.Parada;
import com.example.demo.model.entity.Cuenta;
import com.example.demo.model.entity.Tarifa;
import com.example.demo.repository.TarifaRepository;

@Service
public class AdministradorService {

    private final TarifaRepository tarifaRepository;
	
	RestTemplate restTemplate = new RestTemplate();

    @Autowired
	public AdministradorService(TarifaRepository tarifaRepository) {
		this.tarifaRepository = tarifaRepository;
	}

	@SuppressWarnings("rawtypes")
	public Monopatin agregarMonopatin(Monopatin monopatin) {
		HttpHeaders headers = new HttpHeaders();
		String authHeader = "Bearer " + SystemSecurity.getToken();
		headers.set(HttpHeaders.AUTHORIZATION, authHeader);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<Monopatin> requestEntity = new HttpEntity<>(monopatin, headers);
		ResponseEntity<Monopatin> response = restTemplate.exchange(
				"http://localhost:8003/monopatines",
				HttpMethod.POST,
				requestEntity,
				new ParameterizedTypeReference<>() {}
				);
        headers.setContentType(MediaType.APPLICATION_JSON);
		return response.getBody();
	}
	
    public Monopatin editarEstadoMonopatin(Long id_monopatin, String estado) throws Exception {
        HttpHeaders headers = new HttpHeaders();
		String authHeader = "Bearer " + SystemSecurity.getToken();
		headers.set(HttpHeaders.AUTHORIZATION, authHeader);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Void> reqEntity = new HttpEntity<>(headers);
        ResponseEntity<Monopatin> respuesta = restTemplate.exchange(
                "http://localhost:8003/monopatines/" + id_monopatin,
                HttpMethod.GET,
                reqEntity,
                new ParameterizedTypeReference<>() {});

        Monopatin monopatin = respuesta.getBody();
        monopatin.setEstado(estado);

        HttpEntity<Monopatin> reqEntity2 = new HttpEntity<>(monopatin, headers);
        ResponseEntity<Monopatin> respuesta2 = restTemplate.exchange(
                "http://localhost:8003/monopatines/" + id_monopatin,
                HttpMethod.PUT,
                reqEntity2,
                new ParameterizedTypeReference<>() {});
        headers.setContentType(MediaType.APPLICATION_JSON);

        return respuesta2.getBody();
    }

	
    public Cuenta cambiarEstadoCuenta(Long id_cuenta, String habilitada) throws Exception {
        habilitada = habilitada.toLowerCase();
        //Solo se aceptan los strings "true" y "false"
        if(!habilitada.equals("true") && !habilitada.equals("false")){
            throw new Exception("Estado de cuenta invalido. Parametros validos: ('true' | 'false') !");
        }

        HttpHeaders headers = new HttpHeaders();
		String authHeader = "Bearer " + SystemSecurity.getToken();
		headers.set(HttpHeaders.AUTHORIZATION, authHeader);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Void> reqEntity = new HttpEntity<>(headers);
        ResponseEntity<Cuenta> respuesta = restTemplate.exchange(
                "http://localhost:8005/cuentas/" + id_cuenta,
                HttpMethod.GET,
                reqEntity,
                new ParameterizedTypeReference<>() {
                });
        headers.setContentType(MediaType.APPLICATION_JSON);
        Cuenta cuenta_editada = respuesta.getBody();
        if(habilitada.equals("true")) {
        	cuenta_editada.setIsHabilitada(true);
        }
        if(habilitada.equals("false")) {
        	cuenta_editada.setIsHabilitada(false);
        }

        HttpEntity<Cuenta> reqEntity2 = new HttpEntity<>(cuenta_editada, headers);
        ResponseEntity<Cuenta> respuesta2 = restTemplate.exchange(
                "http://localhost:8005/cuentas/" + id_cuenta,
                HttpMethod.PUT,
                reqEntity2,
                new ParameterizedTypeReference<>() {
                });
        headers.setContentType(MediaType.APPLICATION_JSON);

        return respuesta2.getBody();
    }


	public ResponseEntity<Monopatin> eliminarMonopatin(Long monopatinId) {
        HttpHeaders headers = new HttpHeaders();
		String authHeader = "Bearer " + SystemSecurity.getToken();
		headers.set(HttpHeaders.AUTHORIZATION, authHeader);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Long> reqEntity = new HttpEntity<>(monopatinId, headers);
        ResponseEntity<Monopatin> respuesta = restTemplate.exchange(
           "http://localhost:8003/monopatines/" + monopatinId,
                HttpMethod.DELETE,
                reqEntity,
                new ParameterizedTypeReference<>() {}
        );
        headers.setContentType(MediaType.APPLICATION_JSON);

        return respuesta;
	}


	public List<Monopatin> traerTodosMonopatin() {
        HttpHeaders headers = new HttpHeaders();
		String authHeader = "Bearer " + SystemSecurity.getToken();
		headers.set(HttpHeaders.AUTHORIZATION, authHeader);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Void> reqEntity = new HttpEntity<>(headers);
        ResponseEntity<List<Monopatin>> respuesta = restTemplate.exchange(
                "http://localhost:8003/monopatines",
                HttpMethod.GET,
                reqEntity,
                new ParameterizedTypeReference<List<Monopatin>>() {
        });
        headers.setContentType(MediaType.APPLICATION_JSON);

        return respuesta.getBody();
	}

	public Parada agregarParada(Parada parada) {
        HttpHeaders headers = new HttpHeaders();
		String authHeader = "Bearer " + SystemSecurity.getToken();
		headers.set(HttpHeaders.AUTHORIZATION, authHeader);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Parada> reqEntity = new HttpEntity<>(parada, headers);
        ResponseEntity<Parada> respuesta = restTemplate.exchange(
                "http://localhost:8007/parada",
                HttpMethod.POST,
                reqEntity,
                new ParameterizedTypeReference<>() {}
        );
        headers.setContentType(MediaType.APPLICATION_JSON);

        return respuesta.getBody();
	}

	public List<Parada> traerTodasParadas() {
        HttpHeaders headers = new HttpHeaders();
		String authHeader = "Bearer " + SystemSecurity.getToken();
		headers.set(HttpHeaders.AUTHORIZATION, authHeader);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Void> reqEntity = new HttpEntity<>(headers);
        ResponseEntity<List<Parada>> respuesta = restTemplate.exchange(
            "http://localhost:8007/parada",
            HttpMethod.GET,
            reqEntity,
            new ParameterizedTypeReference<>() {
            });
        headers.setContentType(MediaType.APPLICATION_JSON);

        return respuesta.getBody();
	}

	public Object traerTodasTarifas() {
		return tarifaRepository.findAll();
	}

	public Tarifa crearTarifa(Tarifa tarifa) {
		return tarifaRepository.save(tarifa);
	}

	public Object reporteCantidadViajesPorAnio(Integer cantidad, Integer anio) {
        HttpHeaders headers = new HttpHeaders();
		String authHeader = "Bearer " + SystemSecurity.getToken();
		headers.set(HttpHeaders.AUTHORIZATION, authHeader);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Void> reqEntity = new HttpEntity<>(headers);
        ResponseEntity<List<Viaje>> respuesta = restTemplate.exchange(
                "http://localhost:8003/viajes/cantidadViajesMayorA/" + cantidad + "/anio/ "+ anio,
                HttpMethod.GET,
                reqEntity,
                new ParameterizedTypeReference<List<Viaje>>() {});
        headers.setContentType(MediaType.APPLICATION_JSON);

        return respuesta.getBody();
	}

    public List<MonopatinKilometrajeDTO> reporteMonopatinesOrderByKilometros() throws Exception {
        HttpHeaders headers = new HttpHeaders();
		String authHeader = "Bearer " + SystemSecurity.getToken();
		headers.set(HttpHeaders.AUTHORIZATION, authHeader);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Void> reqEntity = new HttpEntity<>(headers);
        ResponseEntity<List<?>> response = restTemplate.exchange(
        		"http://localhost:8003/monopatines/kilometros",
                HttpMethod.GET,
                reqEntity,
                new ParameterizedTypeReference<>() {}
        );
        headers.setContentType(MediaType.APPLICATION_JSON);
        return  (List<MonopatinKilometrajeDTO>) response.getBody();
    }
	

    public List<MonopatinTiempoDTO> reporteMonopatinesTiemposConPausas() throws Exception {
        HttpHeaders headers = new HttpHeaders();
		String authHeader = "Bearer " + SystemSecurity.getToken();
		headers.set(HttpHeaders.AUTHORIZATION, authHeader);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Void> reqEntity = new HttpEntity<>(headers);
        ResponseEntity<List<?>> response = restTemplate.exchange(
        		"http://localhost:8003/monopatines/tiempos/conPausas",
                HttpMethod.GET,
                reqEntity,
                new ParameterizedTypeReference<>() {}
        );
        headers.setContentType(MediaType.APPLICATION_JSON);
        return (List<MonopatinTiempoDTO>) response.getBody();
    }

    public List<MonopatinTiempoDTO> reporteMonopatinesTiemposSinPausas() throws Exception {
        HttpHeaders headers = new HttpHeaders();
		String authHeader = "Bearer " + SystemSecurity.getToken();
		headers.set(HttpHeaders.AUTHORIZATION, authHeader);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Void> reqEntity = new HttpEntity<>(headers);
        ResponseEntity<List<?>> response = restTemplate.exchange(
        		"http://localhost:8003/monopatines/tiempos/sinPausas",
                HttpMethod.GET,
                reqEntity,
                new ParameterizedTypeReference<>() {}
        );
        headers.setContentType(MediaType.APPLICATION_JSON);
        return (List<MonopatinTiempoDTO>) response.getBody();
    }


	public Object getEstados() {
        HttpHeaders headers = new HttpHeaders();
		String authHeader = "Bearer " + SystemSecurity.getToken();
		headers.set(HttpHeaders.AUTHORIZATION, authHeader);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Void> reqEntity = new HttpEntity<>(headers);
        ResponseEntity<?> respuesta = restTemplate.exchange(
                "http://localhost:8003/monopatines/estados",
                HttpMethod.GET,
                reqEntity,
                new ParameterizedTypeReference<>() {
        });
        headers.setContentType(MediaType.APPLICATION_JSON);

        return respuesta.getBody();
	}


    public Double getTotalFacturado(Integer mes1, Integer mes2, Integer anio) {

        HttpHeaders headers = new HttpHeaders();
		String authHeader = "Bearer " + SystemSecurity.getToken();
		headers.set(HttpHeaders.AUTHORIZATION, authHeader);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Void> reqEntity = new HttpEntity<>(headers);
        ResponseEntity<Object> respuesta = restTemplate.exchange(
                "http://localhost:8003/viajes/facturacionViajesDesde/"+ mes1+"/hasta/"+mes2+"/anio/"+anio,
                HttpMethod.GET,
                reqEntity,
                new ParameterizedTypeReference<>() {
        });
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        return (Double) respuesta.getBody();
    }

	
    public Optional<Tarifa> traerUltimaTarifa() throws Exception {
        Optional<Tarifa> t = tarifaRepository.buscarUltimaTarifa();
        return t;
    }
}
