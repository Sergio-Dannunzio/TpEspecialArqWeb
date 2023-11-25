package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TransferenciaDTO;
import com.example.demo.model.Cuenta;
import com.example.demo.repository.CuentaUsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class CuentaUsuarioService {

	@Autowired
    private final CuentaUsuarioRepository cuentaUsuarioRepository;

	@Autowired
    public CuentaUsuarioService(CuentaUsuarioRepository cuentaUsuarioRepository) {
		this.cuentaUsuarioRepository = cuentaUsuarioRepository;
	}

	@Transactional
    public Iterable<Cuenta> traerTodas() {
        return cuentaUsuarioRepository.findAll();
    }

    @Transactional
    public Optional<Cuenta> traerPorId(Long id) throws Exception {
        Optional<Cuenta> cuentaRecuperada = cuentaUsuarioRepository.findById(id);
        if (cuentaRecuperada.isPresent()) {
            return cuentaRecuperada;
        }

        throw new Exception("No se pudo encontrar la cuenta con el ID proporcionado.");
    }

    @Transactional
    public Cuenta crearCuenta(Long id_cuenta_mercado_pago) {
        return cuentaUsuarioRepository.save(new Cuenta(id_cuenta_mercado_pago));
    }

    @Transactional
    public Optional<Cuenta> eliminarCuenta(Long id) throws Exception {
        Optional<Cuenta> cuentaEliminar = this.traerPorId(id);
        if(cuentaEliminar.isPresent()) {
        	cuentaUsuarioRepository.deleteById(id);
            return cuentaEliminar;
        }
        else {
            throw new Exception("Cuenta no encontrada");
        }
    }

    @Transactional
    public Cuenta editarCuenta(Long id, Cuenta usuario) throws Exception {
        try{
            Optional<Cuenta> cuentaEditar = this.traerPorId(id);
            if(cuentaEditar.isPresent()) {
                Cuenta cuentaEncontrada = cuentaEditar.get();
                this.eliminarCuenta(cuentaEditar.get().getId());
                cuentaEncontrada = cuentaUsuarioRepository.save(usuario);
                return cuentaEncontrada;
            } else {
                throw new Exception("No se ha encontrado la cuenta que intenta editar.");
            }
        } catch (Exception e){
            throw new Exception("No se ha editado la cuenta.");
        }
    }

    @Transactional
    public TransferenciaDTO cargarSaldo(Long id_cuenta, Double monto) throws Exception {

        Optional<Cuenta> cuenta_nueva = this.traerPorId(id_cuenta);

        Cuenta cuenta = cuenta_nueva.get();
        Double montoAnterior = cuenta.getSaldo();

        cuenta.setSaldo(cuenta.getSaldo() + monto);
        Cuenta cuentaCambiada = this.cuentaUsuarioRepository.save(cuenta);

        return new TransferenciaDTO(montoAnterior, cuenta.getSaldo(), monto);
    }


    @Transactional
    public TransferenciaDTO restarSaldo(Long id_cuenta, Double monto_quitar) throws Exception {

        Optional<Cuenta> cuenta_nueva = this.traerPorId(id_cuenta);

        Cuenta cuenta = cuenta_nueva.get();
        Double montoAnterior = cuenta.getSaldo();

        cuenta.setSaldo(cuenta.getSaldo() - monto_quitar);
        Cuenta cuentaCambiada = this.cuentaUsuarioRepository.save(cuenta);

        return new TransferenciaDTO(montoAnterior, cuentaCambiada.getSaldo(), monto_quitar);
    }

}
