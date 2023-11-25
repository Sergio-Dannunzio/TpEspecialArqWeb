package com.example.demo.dto;

import java.io.Serializable;

public class RegisterRequestDTO implements Serializable{

    private String username;
    private String password;
    private boolean admin;
    private boolean maintenance;
    
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
	public boolean isAdmin() {
		return true;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public boolean isMaintenance() {
		return true;
	}
	public void setMaintenance(boolean maintenance) {
		this.maintenance = maintenance;
	}
    
    
}
