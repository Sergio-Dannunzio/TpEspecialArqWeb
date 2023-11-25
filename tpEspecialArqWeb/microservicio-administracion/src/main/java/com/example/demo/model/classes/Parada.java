package com.example.demo.model.classes;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@SuppressWarnings("serial")
public class Parada implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @org.springframework.data.annotation.Id
    private String id_parada;
    private String locacion;
    private Boolean isHabilitada;
	
	
	public Parada() {

	}


	public Parada(Parada p) {
		this.id_parada = p.getId_parada();
		this.locacion = p.getLocacion();
		this.isHabilitada = p.getIsHabilitada();
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
