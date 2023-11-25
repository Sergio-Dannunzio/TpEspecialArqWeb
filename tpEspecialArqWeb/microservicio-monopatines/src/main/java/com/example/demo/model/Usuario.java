package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Usuario implements Serializable{

	    private Long id;
	    private String nombre;
	    private String apellido;
	    private LocalDateTime fecha;
	    private String password;
		private String email;
	    private List<Cuenta> cuentas;
	    private List<Rol> roles;

	    public Usuario() {
	        this.cuentas = new ArrayList<>();
	        this.roles = new ArrayList<>();
	    }
	    
		public Usuario(String nombre, String apellido, String email, String password) {
			super();
			this.nombre = nombre;
			this.apellido = apellido;
			this.email = email;
			this.password = password;
			this.cuentas = new ArrayList<>();
			this.roles = new ArrayList<>();
			
		}
	    


		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public LocalDateTime getFecha() {
			return fecha;
		}

		public void setFecha(LocalDateTime fecha) {
			this.fecha = fecha;
		}

		public List<Cuenta> getCuentas() {
			return cuentas;
		}

		public void setCuentas(List<Cuenta> cuentas) {
			this.cuentas = cuentas;
		}

		/*public Usuario(String nombre, String apellido) {
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.fecha = LocalDateTime.now();
	        this.cuentas = new ArrayList<>();
	        this.roles = new ArrayList<>();
	    }*/


		public String getPassword() {
			return password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setPassword(String password) {
			this.password = password;
		}



		public List<Rol> getRoles() {
			return roles;
		}

		public void setRoles(List<Rol> roles) {
			this.roles = roles;
		}
    
		
}