package com.example.demo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "parada")
public class Parada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_parada;
    private Double latitud;
    private Double longitud;
    private Boolean isHabilitada;
	public Long getId_parada() {
		return id_parada;
	}
	public void setId_parada(Long id_parada) {
		this.id_parada = id_parada;
	}
	public Double getLatitud() {
		return latitud;
	}
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	public Double getLongitud() {
		return longitud;
	}
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}
	public Boolean getIsHabilitada() {
		return isHabilitada;
	}
	public void setIsHabilitada(Boolean isHabilitada) {
		this.isHabilitada = isHabilitada;
	}
    
    
}
