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

import com.example.demo.jwt.SystemSecurity;
import com.example.demo.model.Monopatin;
import com.example.demo.model.TokenInfo;
import com.example.demo.model.Usuario;
import com.example.demo.service.MonopatinServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("monopatines")
@RequiredArgsConstructor
public class MonopatinController {
	
	private final MonopatinServiceImpl monopatinService;

	@Autowired
	public MonopatinController(MonopatinServiceImpl monopatinService) {
		this.monopatinService = monopatinService;
	}
	
	/*@GetMapping("/validate")
	public ResponseEntity<?> authenticate(@RequestBody String usuario){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(monopatinService.getUsuario(usuario));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
	}
	*/
	
	@GetMapping("")
	public Iterable<Monopatin> findAll(@RequestHeader("Authorization") String token){
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
		return this.monopatinService.findAll();
	}
	
    @GetMapping("/kilometros")
    public ResponseEntity<?> traerOrdenadosPorKilometros(@RequestHeader("Authorization") String token){
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
        try{
            return ResponseEntity.status(HttpStatus.OK).body(monopatinService.traerOrdenadosPorKilometros());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @GetMapping("/tiempos/conPausas")
    public ResponseEntity<?> traerOrdenadosPorTiempoConPausas(@RequestHeader("Authorization") String token){
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
    	try{
            return ResponseEntity.status(HttpStatus.OK).body(monopatinService.traerOrdenadosPorTiempoConPausas());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }
    
    @GetMapping("/tiempos/sinPausas")
    public ResponseEntity<?> traerOrdenadosPorTiempoSinPausas(@RequestHeader("Authorization") String token){
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
    	try{
            return ResponseEntity.status(HttpStatus.OK).body(monopatinService.traerOrdenadosPorTiempoSinPausas());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }
	
	@GetMapping("/estados")
    public ResponseEntity<?> getEstados(@RequestHeader("Authorization") String token){
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
		try{
            return ResponseEntity.status(HttpStatus.OK).body(monopatinService.getEstados());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> traerPorId(@RequestHeader("Authorization") String token, @PathVariable("id") Long id_monopatin){
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
    	try{
            return ResponseEntity.status(HttpStatus.OK).body(monopatinService.traerPorId(id_monopatin));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }
    
    @GetMapping("/locacion/{locacion}")
    public ResponseEntity<?> traerPorLocacion(@RequestHeader("Authorization") String token, @PathVariable("locacion") String locacion){
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
    	try{
            return ResponseEntity.status(HttpStatus.OK).body(monopatinService.traerPorLocacion(locacion));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }
    
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarMonopatin(@RequestHeader("Authorization") String token, @PathVariable("id")  Long id_monopatin){
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
        try{
            return ResponseEntity.status(HttpStatus.OK).body(monopatinService.eliminar(id_monopatin));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
	}

    @PostMapping("")
    public ResponseEntity<?> crearMonopatin(@RequestHeader("Authorization") String token, @RequestBody Monopatin monopatin){
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
        try{
            return ResponseEntity.status(HttpStatus.OK).body(monopatinService.crear(monopatin));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> editarMonopatin(@RequestHeader("Authorization") String token, @PathVariable("id") Long idMonopatin, @RequestBody Monopatin nuevaInfo){
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
    	try{
            return ResponseEntity.status(HttpStatus.OK).body(monopatinService.editar(idMonopatin, nuevaInfo));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
