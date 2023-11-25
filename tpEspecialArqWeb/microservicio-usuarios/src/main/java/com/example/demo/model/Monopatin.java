package com.example.demo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "monopatin")
public class Monopatin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_monopatin;
    private Long gps;
    private String locacion;
    private String estado;
    
	public Long getId_monopatin() {
		return id_monopatin;
	}
	public void setId_monopatin(Long id_monopatin) {
		this.id_monopatin = id_monopatin;
	}
	public Long getGps() {
		return gps;
	}
	public void setGps(Long gps) {
		this.gps = gps;
	}

	public String getLocacion() {
		return locacion;
	}
	public void setLocacion(String locacion) {
		this.locacion = locacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
    
    
}

