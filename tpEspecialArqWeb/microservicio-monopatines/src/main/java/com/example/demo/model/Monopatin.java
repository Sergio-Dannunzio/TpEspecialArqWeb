package com.example.demo.model;

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
@Table(name="monopatin")
public class Monopatin {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long gps;
    private String locacion;
    private String estado;

    
    
    public Monopatin() {
	}

	public Monopatin(Monopatin monopatin) {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
