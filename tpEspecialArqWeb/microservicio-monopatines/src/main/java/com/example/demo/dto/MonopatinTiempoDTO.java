package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class MonopatinTiempoDTO {
    private Long id_monopatin;
    private Long tiempo_total;
    private Long tiempo_total_funcionando;
    private Long tiempo_total_pausado;
    
    
    
	public MonopatinTiempoDTO() {
	}

	public MonopatinTiempoDTO(Long id_monopatin, Long tiempo_total, Long tiempo_total_funcionando,
			Long tiempo_total_pausado) {
		this.id_monopatin = id_monopatin;
		this.tiempo_total = tiempo_total;
		this.tiempo_total_funcionando = tiempo_total_funcionando;
		this.tiempo_total_pausado = tiempo_total_pausado;
	}

	public Long getId_monopatin() {
		return id_monopatin;
	}

	public void setId_monopatin(Long id_monopatin) {
		this.id_monopatin = id_monopatin;
	}

	public Long getTiempo_total() {
		return tiempo_total;
	}

	public void setTiempo_total(Long tiempo_total) {
		this.tiempo_total = tiempo_total;
	}

	public Long getTiempo_total_funcionando() {
		return tiempo_total_funcionando;
	}

	public void setTiempo_total_funcionando(Long tiempo_total_funcionando) {
		this.tiempo_total_funcionando = tiempo_total_funcionando;
	}

	public Long getTiempo_total_pausado() {
		return tiempo_total_pausado;
	}

	public void setTiempo_total_pausado(Long tiempo_total_pausado) {
		this.tiempo_total_pausado = tiempo_total_pausado;
	}
    
    
}
