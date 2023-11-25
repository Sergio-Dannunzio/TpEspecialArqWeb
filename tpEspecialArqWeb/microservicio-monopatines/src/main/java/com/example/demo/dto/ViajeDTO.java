package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViajeDTO {
    private Long id_cuenta;
    private Long id_usuario;
    private Long id_monopatin;
    
	public ViajeDTO(Long id_cuenta, Long id_usuario, Long id_monopatin) {
		this.id_cuenta = id_cuenta;
		this.id_usuario = id_usuario;
		this.id_monopatin = id_monopatin;
	}
	public Long getId_cuenta() {
		return id_cuenta;
	}
	public void setId_cuenta(Long id_cuenta) {
		this.id_cuenta = id_cuenta;
	}
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Long getId_monopatin() {
		return id_monopatin;
	}
	public void setId_monopatin(Long id_monopatin) {
		this.id_monopatin = id_monopatin;
	}
    
    
}
