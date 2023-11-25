package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.jwt.SystemSecurity;
import com.example.demo.model.ParadaMongodb;
import com.example.demo.service.ParadaService;


@RestController
@RequestMapping("parada")
public class ParadaController {
	
	@Autowired
	private final ParadaService paradaService;

    public ParadaController(ParadaService paradaService) {
    	this.paradaService = paradaService;
	}

	@GetMapping("")
    public List<ParadaMongodb> traerTodos(){

            return paradaService.traerTodos();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> traerPorId(@RequestHeader("Authorization") String token, @PathVariable("id") String id_parada){
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
        try{
            return ResponseEntity.status(HttpStatus.OK).body(paradaService.traerPorId(id_parada));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    /*@GetMapping("/buscarParadaHabilitada/locacion/{locacion}")
    public ResponseEntity<?> buscarParadaPorLocacion(@PathVariable("locacion") String locacion){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(paradaService.buscarParadaPorLocacion(locacion));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }*/

    @PostMapping("")
    public ResponseEntity<?> crearParada(@RequestHeader("Authorization") String token, @RequestBody ParadaMongodb parada){
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
        try{
            return ResponseEntity.status(HttpStatus.OK).body(paradaService.crear(parada));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarParada(@RequestHeader("Authorization") String token, @PathVariable("id") String id_parada){
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
        try{
            return ResponseEntity.status(HttpStatus.OK).body(paradaService.eliminar(id_parada));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarParada(@RequestHeader("Authorization") String token, @PathVariable("id") String id_parada, @RequestBody ParadaMongodb nuevaInfo){
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
        try{
            return ResponseEntity.status(HttpStatus.OK).body(paradaService.editar(id_parada, nuevaInfo));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
