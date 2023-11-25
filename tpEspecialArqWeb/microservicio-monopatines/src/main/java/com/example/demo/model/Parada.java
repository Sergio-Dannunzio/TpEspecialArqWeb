package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parada {
    private Long id_parada;
    private String locacion;
    private Boolean isHabilitada;
    
	public Long getId_parada() {
		return id_parada;
	}
	public void setId_parada(Long id_parada) {
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
