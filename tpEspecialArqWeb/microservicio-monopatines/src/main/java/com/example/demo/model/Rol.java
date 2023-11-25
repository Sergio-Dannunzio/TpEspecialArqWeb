package com.example.demo.model;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Rol {

    @Serial
    private static final long serialVersionUID = 1L;

    private String nombre;
    
    private List<Usuario> usuarios;
    
    public Rol () {
    	this.usuarios = new ArrayList<>();
    }
    
    public Rol(String nombre) {
		this.nombre = nombre;
		this.usuarios = new ArrayList<>();
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

    
}
