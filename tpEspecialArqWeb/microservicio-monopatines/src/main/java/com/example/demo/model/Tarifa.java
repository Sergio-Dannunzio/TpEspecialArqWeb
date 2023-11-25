package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "tarifa")
public class Tarifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha_creacion;
    private Double valor;
    private Double valorPorPausa;
    private LocalDateTime fechaEntradaVigencia;

    public Tarifa() {
    }

    public Tarifa(Double valor, Double valorPorPausa) {
        this.fecha_creacion = LocalDateTime.now();
        this.valor = valor;
        this.valorPorPausa = valorPorPausa;
        this.fechaEntradaVigencia = null;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(LocalDateTime fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorPorPausa() {
		return valorPorPausa;
	}

	public void setValorPorPausa(Double valorPorPausa) {
		this.valorPorPausa = valorPorPausa;
	}

	public LocalDateTime getFechaEntradaVigencia() {
		return fechaEntradaVigencia;
	}

	public void setFechaEntradaVigencia(LocalDateTime fechaEntradaVigencia) {
		this.fechaEntradaVigencia = fechaEntradaVigencia;
	}
    
    
}