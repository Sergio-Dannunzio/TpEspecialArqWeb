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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jwt.SystemSecurity;
import com.example.demo.model.classes.Monopatin;
import com.example.demo.model.classes.Parada;
import com.example.demo.model.entity.Tarifa;
import com.example.demo.service.AdministradorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("administradores")
@RequiredArgsConstructor
public class AdministradorController {
	
	private final AdministradorService administradorService;

	@Autowired
	public AdministradorController(AdministradorService administradorService) {
		this.administradorService = administradorService;
	}
	

	//• Registrar monopatín en mantenimiento (debe marcarse como no disponible para su uso)
	//• Registrar fin de mantenimiento de monopatín
	//Usar disponible o mantenimiento de estado
    @PutMapping("/monopatines/{id}/estado/{estado}")
    public ResponseEntity<?> cambiarEstado(@RequestHeader("Authorization") String token, @PathVariable Long id, @PathVariable String estado){
    	System.out.print(token);
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
        try{
            return ResponseEntity.status(HttpStatus.OK).body(administradorService.editarEstadoMonopatin(id, estado));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }
    
    //b. Como administrador quiero poder anular cuentas para inhabilitar el uso momentáneo de la
    //misma.
    @PutMapping("/cuentas/{id_cuenta}")
    public ResponseEntity<?> cambiarEstadoCuenta(@RequestHeader("Authorization") String token, @PathVariable Long id_cuenta, @RequestParam(name = "habilitada") String habilitada){
    	System.out.print(token);
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
    	try{
            return ResponseEntity.status(HttpStatus.OK).body(administradorService.cambiarEstadoCuenta(id_cuenta, habilitada));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

	//• Agregar monopatín
	@PostMapping("/monopatines/agregar")
	public ResponseEntity<?> agregarMonopatin(@RequestHeader("Authorization") String token, @RequestBody Monopatin monopatin){
    	System.out.print(token);
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
		return ResponseEntity.status(HttpStatus.OK).body(administradorService.agregarMonopatin(monopatin));
	}
	
	//• Quitar monopatín
	@DeleteMapping("/monopatines/{monopatinId}")
	public ResponseEntity<Monopatin> eliminarMonopatin(@RequestHeader("Authorization") String token, @PathVariable Long monopatinId){
    	System.out.print(token);
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
		return this.administradorService.eliminarMonopatin(monopatinId);
	}
	
	//e. Como administrador quiero consultar la cantidad de monopatines actualmente en operación,
	//versus la cantidad de monopatines actualmente en mantenimiento.
	@GetMapping("/monopatines/estados")
    public ResponseEntity<?> getEstados(@RequestHeader("Authorization") String token){
    	System.out.print("asdasd");
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
		try{
            return ResponseEntity.status(HttpStatus.OK).body(administradorService.getEstados());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }
	
	@GetMapping("/monopatines")
    public ResponseEntity<?> traerTodosMonopatin(@RequestHeader("Authorization") String token){
    	System.out.print(token);
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
		try{
            return ResponseEntity.status(HttpStatus.OK).body(administradorService.traerTodosMonopatin());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

	//• Registrar parada
    @PostMapping("/paradas")
    public ResponseEntity<?> agregarParada(@RequestHeader("Authorization") String token, @RequestBody Parada parada){
    	System.out.print(token);
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
    	try{
            return ResponseEntity.status(HttpStatus.OK).body(administradorService.agregarParada(parada));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }


    @GetMapping("/paradas")
    public ResponseEntity<?> traerTodasParadas(@RequestHeader("Authorization") String token){
    	System.out.print(token);
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
    	try{
            return ResponseEntity.status(HttpStatus.OK).body(administradorService.traerTodasParadas());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }


    @GetMapping("/tarifas")
    public ResponseEntity<?> traerTodasTarifas(){
    	try{
            return ResponseEntity.status(HttpStatus.OK).body(administradorService.traerTodasTarifas());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }
    
    @GetMapping("/tarifas/ultima")
    public ResponseEntity<?> traerUltimaTarifa(){
    	try{
            return ResponseEntity.status(HttpStatus.OK).body(administradorService.traerUltimaTarifa());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }


    @PostMapping("/tarifas")
    public ResponseEntity<?> crearTarifa(@RequestHeader("Authorization") String token, @RequestBody Tarifa tarifa){
    	System.out.print(token);
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
    	try{
            return ResponseEntity.status(HttpStatus.OK).body(administradorService.crearTarifa(tarifa));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }



    //c. Como administrador quiero consultar los monopatines con más de X viajes en un cierto año.
    @GetMapping("/reportes/cantidadViajesMayorA/{cantidad}/anio/{anio}")
    public ResponseEntity<?> reporteCantidadViajesPorAnio(@RequestHeader("Authorization") String token, @PathVariable Integer cantidad, @PathVariable Integer anio){
    	System.out.print(token);
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
    	try{
            return ResponseEntity.status(HttpStatus.OK).body(administradorService.reporteCantidadViajesPorAnio(cantidad, anio));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    
    //d. Como administrador quiero consultar el total facturado en un rango de meses de cierto año
    @GetMapping("/facturacionViajesDesde/{mes1}/hasta/{mes2}/anio/{anio}")
    public Double reporteFacturacionViajesRangoMesesPorAnio(@RequestHeader("Authorization") String token, @PathVariable Integer mes1, @PathVariable Integer mes2,@PathVariable Integer anio){
    	System.out.print(token);
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        } 
    	return administradorService.getTotalFacturado(mes1, mes1, anio);

    }

    
    //• Generar reporte de uso de monopatines por kilómetros
    @GetMapping("/reportes/monopatines/kilometros")
    public ResponseEntity<?> reporteMonopatinesOrderByKilometros(@RequestHeader("Authorization") String token){
    	System.out.print(token);
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
    	try{
            return ResponseEntity.status(HttpStatus.OK).body(administradorService.reporteMonopatinesOrderByKilometros());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    //a. Como encargado de mantenimiento quiero poder generar un reporte de uso de monopatines por
    //kilómetros para establecer si un monopatín requiere de mantenimiento. Este reporte debe poder
    //configurarse para incluir (o no) los tiempos de pausa
    @GetMapping("/reportes/monopatines/tiempos/conPausas")
    public ResponseEntity<?> reporteMonopatinesTiemposConPausas(@RequestHeader("Authorization") String token){
    	System.out.print(token);
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }  
    	try{
            return ResponseEntity.status(HttpStatus.OK).body(administradorService.reporteMonopatinesTiemposConPausas());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    
    //a. Como encargado de mantenimiento quiero poder generar un reporte de uso de monopatines por
    //kilómetros para establecer si un monopatín requiere de mantenimiento. Este reporte debe poder
    //configurarse para incluir (o no) los tiempos de pausa
    @GetMapping("/reportes/monopatines/tiempos/sinPausas")
    public ResponseEntity<?> reporteMonopatinesTiemposSinPausas(@RequestHeader("Authorization") String token){
    	System.out.print(token);
    	String request = SystemSecurity.decode(token);
        if(!SystemSecurity.isAllowed(request)){
            throw new RuntimeException(request+ " Not allowed");
        }
    	try{
            return ResponseEntity.status(HttpStatus.OK).body(administradorService.reporteMonopatinesTiemposSinPausas());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

}
