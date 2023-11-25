package com.example.demo.model.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="tarifa")
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String clave;
    @Column
    private Double valor;
    
    @Column
    private Double valorPorPausa;
    
    @Column
    private Date fechaEntradaVigencia;

	public Tarifa() {
	}

	public Tarifa(String clave, Double valor, Double valorPorPausa, Date fechaEntradaVigencia) {
		this.clave = clave;
		this.valor = valor;
		this.valorPorPausa = valorPorPausa;
		this.fechaEntradaVigencia = fechaEntradaVigencia;
	}

	public Long getId() {
		return id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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

	public Date getFechaEntradaVigencia() {
		return fechaEntradaVigencia;
	}

	public void setFechaEntradaVigencia(Date fechaEntradaVigencia) {
		this.fechaEntradaVigencia = fechaEntradaVigencia;
	}
    
    
}
