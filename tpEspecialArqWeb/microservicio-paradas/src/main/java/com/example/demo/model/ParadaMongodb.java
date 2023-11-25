package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Document(value = "paradas")
public class ParadaMongodb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @org.springframework.data.annotation.Id
    private String id_parada;
    private String locacion;
    private Boolean isHabilitada;
    
	public ParadaMongodb( String locacion, Boolean isHabilitada) {
		this.locacion = locacion;
		this.isHabilitada = isHabilitada;
	}
	public String getId_parada() {
		return id_parada;
	}
	public void setId_parada(String id_parada) {
		this.id_parada = id_parada;
	}

	public String getLocacion() {
		return locacion;
	}
	public void setLocacion(String locacion) {
		this.locacion = locacion;
	}
	public Boolean getIsHabilitada() {
		return isHabilitada;
	}
	public void setIsHabilitada(Boolean isHabilitada) {
		this.isHabilitada = isHabilitada;
	}
    
}
