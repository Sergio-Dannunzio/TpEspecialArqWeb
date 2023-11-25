package com.example.demo.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.ViajeDTO;
import com.example.demo.model.Cuenta;
import com.example.demo.model.Monopatin;
import com.example.demo.model.Parada;
import com.example.demo.model.Tarifa;
import com.example.demo.model.Viaje;
import com.example.demo.repository.ViajeRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ViajeService {
    private final ViajeRepository viajeRepository;
	private final MonopatinServiceImpl monopatinService;
    private final RestTemplate restTemplate = new RestTemplate();

    
    public ViajeService(ViajeRepository viajeRepository, MonopatinServiceImpl monopatinService) {
		this.viajeRepository = viajeRepository;
		this.monopatinService = monopatinService;
	}

	@Transactional
    public Iterable<Viaje> traerTodos() {
        return viajeRepository.findAll();
    }

    @Transactional
    public Optional<Viaje> traerPorId(Long id) {
        return viajeRepository.findById(id);
    }

    @Transactional
    public Viaje crearViaje(ViajeDTO viaje) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> reqEntity3 = new HttpEntity<>(headers);
        ResponseEntity<Optional<Tarifa>> response3 = restTemplate.exchange(
                "http://localhost:8001/administradores/tarifas/ultima",
                HttpMethod.GET,
                reqEntity3,
                new ParameterizedTypeReference<>() {}
        );
        headers.setContentType(MediaType.APPLICATION_JSON);

        Tarifa tarifa = response3.getBody().get();

        return viajeRepository.save(new Viaje(viaje.getId_cuenta(), viaje.getId_usuario(), viaje.getId_monopatin(), tarifa.getValor(), tarifa.getValorPorPausa()));
    }

    @Transactional
    public Optional<Viaje> eliminarViaje(Long id) throws Exception {
        Optional<Viaje> viajeEliminar = this.traerPorId(id);

        if(viajeEliminar.isPresent()) {
        	viajeRepository.deleteById(id);
            return viajeEliminar;
        }
        else {
            throw new Exception("Usuario no encontrado");
        }
    }

    @Transactional
    public Object editarViaje(Long id, Viaje viaje) throws Exception {
        try{
            Optional<Viaje> viajeEditar = this.traerPorId(id);
            if(viajeEditar.isPresent()) {
                Viaje viajeEncontrado = viajeEditar.get();
                viajeEncontrado = viajeRepository.save(viaje);
                return viajeEncontrado;
            } else {
                throw new Exception("No se ha encontrado el viaje que intenta editar.");
            }
        } catch (Exception e){
            throw new Exception("No se ha editar el viaje.");
        }
    }
    
    @Transactional
    public Viaje finalizarViaje(Long id_viaje) throws Exception {
        // Validamos que exista el viaje
        Optional<Viaje> posible_viaje_a_finalizar = this.traerPorId(id_viaje);
        if(posible_viaje_a_finalizar.isEmpty()){ throw new Exception("No existe el viaje con id " + id_viaje + "!!!"); }

        Viaje viaje_a_finalizar = posible_viaje_a_finalizar.get();

        HttpHeaders headers = new HttpHeaders();

        // Traigo el monopatin por id
        Monopatin monopatin = this.monopatinService.traerPorId(viaje_a_finalizar.getId_monopatin());

        // Valido que el monopatin esté en una locacion valida para dejarse (una parada disponible)
        HttpEntity<Void> httpEntity2 = new HttpEntity<>(headers);
        ResponseEntity<Parada> response2 = restTemplate.exchange(
                "http://localhost:8007/paradas/buscarParada/locacion/" + monopatin.getLocacion(),
                HttpMethod.GET,
                httpEntity2,
                new ParameterizedTypeReference<>() {});
        headers.setContentType(MediaType.APPLICATION_JSON);

        Parada parada = response2.getBody();
        if(!parada.getIsHabilitada()){ throw new Exception("La parada no está disponible!"); }

        monopatin.setEstado("disponible");
        viaje_a_finalizar.setFin(LocalDateTime.now());

        LocalDateTime fechaInicio = viaje_a_finalizar.getInicio();
        LocalDateTime fechaFin = viaje_a_finalizar.getFin();

        // Calcula la diferencia en minutos
        Duration duracion = Duration.between(fechaInicio, fechaFin);
        long minutosViaje = duracion.toMinutes();

        Double costo_total = minutosViaje * viaje_a_finalizar.getTarifa();
        if(viaje_a_finalizar.getSegundos_estacionado() > (15*60)){
            costo_total *= viaje_a_finalizar.getPorc_recargo();
        }

        viaje_a_finalizar.setCosto_total_viaje(costo_total);


        // Damos por finalizado el viaje y devolvemos el viaje con todas sus columnas
        return viajeRepository.save(viaje_a_finalizar);
    }

    @Transactional
    public List<Viaje> cantidadViajesMayorAAnioo(Integer cantidad, Integer anio) throws Exception {
        return viajeRepository.cantidadViajesMayorAAnioo(cantidad, anio);
    }


	public Double reporteCantidadViajesPorAnio(Integer mes1, Integer mes2, Integer anio) {
            return viajeRepository.getTotalFacturadoEntre(mes1, mes2, anio);
	}
}
