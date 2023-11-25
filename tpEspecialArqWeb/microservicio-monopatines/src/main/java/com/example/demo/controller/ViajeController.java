package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ViajeDTO;
import com.example.demo.jwt.SystemSecurity;
import com.example.demo.service.ViajeService;

import lombok.Data;

@RestController
@Data
@RequestMapping("/viajes")
public class ViajeController {

	@Autowired
    private final ViajeService viajeService;

    public ViajeController(ViajeService viajeService) {
		this.viajeService = viajeService;
	}

    @GetMapping("")
    public ResponseEntity<?> traerTodos(@RequestHeader("Authorization") String token){
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
        try{
            return ResponseEntity.status(HttpStatus.OK).body(viajeService.traerTodos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> traerPorId(@RequestHeader("Authorization") String token, @PathVariable Long id){
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
        try{
            return ResponseEntity.status(HttpStatus.OK).body(viajeService.traerPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("")
    public ResponseEntity<?> crearViaje(@RequestHeader("Authorization") String token, @RequestBody ViajeDTO viaje){
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
        try{
            return ResponseEntity.status(HttpStatus.OK).body(viajeService.crearViaje(viaje));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarViaje(@RequestHeader("Authorization") String token, @PathVariable Long id){
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
        try{
            return ResponseEntity.status(HttpStatus.OK).body(viajeService.eliminarViaje(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
    @PutMapping("/{id_viaje}")
    public ResponseEntity<?> finalizarViaje(@RequestHeader("Authorization") String token, @PathVariable Long id_viaje){
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
        try{
            return ResponseEntity.status(HttpStatus.OK).body(viajeService.finalizarViaje(id_viaje));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/cantidadViajesMayorA/{cantidad}/anio/{anio}")
    public ResponseEntity<?> cantidadViajesMayorAAnioo(@RequestHeader("Authorization") String token, @PathVariable Integer cantidad, @PathVariable Integer anio){
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
        try{
            return ResponseEntity.status(HttpStatus.OK).body(viajeService.cantidadViajesMayorAAnioo(cantidad, anio));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
    @GetMapping("/facturacionViajesDesde/{mes1}/hasta/{mes2}/anio/{anio}")
    public Double reporteFacturacionViajesRangoMesesPorAnio(@RequestHeader("Authorization") String token, @PathVariable Integer mes1, @PathVariable Integer mes2,@PathVariable Integer anio){
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
    	return viajeService.reporteCantidadViajesPorAnio(mes1, mes1, anio);


    }

}