package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Cuenta implements Serializable {
    private Long id;
    private Long id_mercado_pago;
    private Double saldo;
    private Boolean isHabilitada;
    private LocalDateTime fecha_alta;

    public Cuenta() { }

    public Cuenta (Long id_mercado_pago){
        this.id_mercado_pago = id_mercado_pago;
        this.saldo = 0.0;
        this.isHabilitada = true;
        this.fecha_alta = LocalDateTime.now();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_mercado_pago() {
		return id_mercado_pago;
	}

	public void setId_mercado_pago(Long id_mercado_pago) {
		this.id_mercado_pago = id_mercado_pago;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Boolean getIsHabilitada() {
		return isHabilitada;
	}

	public void setIsHabilitada(Boolean isHabilitada) {
		this.isHabilitada = isHabilitada;
	}

	public LocalDateTime getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(LocalDateTime fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
    
    
}