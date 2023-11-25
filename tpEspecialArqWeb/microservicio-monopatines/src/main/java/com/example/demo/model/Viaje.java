package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "viaje")
public class Viaje implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_cuenta;
    private Long id_usuario;
    private Long id_monopatin;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private Double km_recorridos;
    private Double tarifa;
    private Double porc_recargo;
    private Long segundos_estacionado;
    private Double costo_total_viaje;

    public Viaje() { }

    public Viaje(Long id_cuenta, Long id_usuario, Long id_monopatin, Double tarifa, Double porc_recargo) {
        this.id_cuenta = id_cuenta;
        this.id_usuario = id_usuario;
        this.id_monopatin = id_monopatin;
        this.porc_recargo = porc_recargo;
        this.tarifa = tarifa;
        this.inicio = LocalDateTime.now();
        this.fin = null;
        this.km_recorridos = 0.0;
        this.segundos_estacionado = new Long(0L);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(Long id_cuenta) {
		this.id_cuenta = id_cuenta;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Long getId_monopatin() {
		return id_monopatin;
	}

	public void setId_monopatin(Long id_monopatin) {
		this.id_monopatin = id_monopatin;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public LocalDateTime getFin() {
		return fin;
	}

	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}

	public Double getKm_recorridos() {
		return km_recorridos;
	}

	public void setKm_recorridos(Double km_recorridos) {
		this.km_recorridos = km_recorridos;
	}

	public Double getTarifa() {
		return tarifa;
	}

	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
	}

	public Double getPorc_recargo() {
		return porc_recargo;
	}

	public void setPorc_recargo(Double porc_recargo) {
		this.porc_recargo = porc_recargo;
	}

	public Long getSegundos_estacionado() {
		return segundos_estacionado;
	}

	public void setSegundos_estacionado(Long segundos_estacionado) {
		this.segundos_estacionado = segundos_estacionado;
	}

	public Double getCosto_total_viaje() {
		return costo_total_viaje;
	}

	public void setCosto_total_viaje(Double costo_total_viaje) {
		this.costo_total_viaje = costo_total_viaje;
	}
    
    
}
