package com.example.demo.dto;


import com.example.demo.entity.Rol;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class LoginResponseDTO {
	
	String username;
	String password;
    @Enumerated(EnumType.STRING)
    private Rol role;
	
	
	public LoginResponseDTO() {

	}	
	
	public LoginResponseDTO(String username, String password, Rol role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Rol getRole() {
		return role;
	}
}
