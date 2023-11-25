package com.example.demo.model.classes;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Monopatin implements Serializable{

    private Long gps;
    private String locacion;
    private String estado;
	
	
	public Monopatin() {
	}

	public Monopatin(Monopatin m) {
		this.estado = m.getEstado();
		this.locacion = m.getLocacion();
		this.gps = m.getGps();
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLocacion() {
		return locacion;
	}

	public void setLocacion(String locacion) {
		this.locacion = locacion;
	}

	public Long getGps() {
		return gps;
	}

	public void setGps(Long gps) {
		this.gps = gps;
	}


	
}
