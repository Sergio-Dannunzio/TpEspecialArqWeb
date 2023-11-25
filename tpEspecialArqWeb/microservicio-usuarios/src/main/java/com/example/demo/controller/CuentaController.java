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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cuenta;
import com.example.demo.service.CuentaUsuarioService;



@RestController
@RequestMapping("/cuentas")
public class CuentaController {

	private final CuentaUsuarioService cuentaUsuarioService;

	@Autowired
    public CuentaController(CuentaUsuarioService cuentaUsuarioService) {
		this.cuentaUsuarioService = cuentaUsuarioService;
	}

    @GetMapping("")
    public ResponseEntity<?> traerTodas(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(cuentaUsuarioService.traerTodas());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("No se pudieron recuperar los datos.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> traerPorId(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(cuentaUsuarioService.traerPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @PostMapping("/{id_mercado_pago}")
    public ResponseEntity<?> crearCuenta(@PathVariable Long id_mercado_pago){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(cuentaUsuarioService.crearCuenta(id_mercado_pago));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarCuenta(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(cuentaUsuarioService.eliminarCuenta(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarCuenta(@PathVariable Long id, @RequestBody Cuenta cuenta){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(cuentaUsuarioService.editarCuenta(id, cuenta));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @PutMapping("{id_cuenta}/cargarSaldo/{monto}")
    public ResponseEntity<?> cargarSaldo(@PathVariable Long id_cuenta, @PathVariable Double monto){
        try{
            return ResponseEntity.status(200).body(cuentaUsuarioService.cargarSaldo(id_cuenta, monto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @PutMapping("{id_cuenta}/restarSaldo/{monto}")
    public ResponseEntity<?> restarSaldo(@PathVariable Long id_cuenta, @PathVariable Double monto){
        try{
            return ResponseEntity.status(200).body(cuentaUsuarioService.restarSaldo(id_cuenta, monto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }
}
