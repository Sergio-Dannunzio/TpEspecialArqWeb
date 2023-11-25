package com.example.demo.dto;

public class TransferenciaDTO {
    private Double monto_anterior;
    private Double monto_nuevo;
    private Double diferencia;
    
	public TransferenciaDTO(Double monto_anterior, Double monto_nuevo, Double diferencia) {
		this.monto_anterior = monto_anterior;
		this.monto_nuevo = monto_nuevo;
		this.diferencia = diferencia;
	}
	public Double getMonto_anterior() {
		return monto_anterior;
	}
	public void setMonto_anterior(Double monto_anterior) {
		this.monto_anterior = monto_anterior;
	}
	public Double getMonto_nuevo() {
		return monto_nuevo;
	}
	public void setMonto_nuevo(Double monto_nuevo) {
		this.monto_nuevo = monto_nuevo;
	}
	public Double getDiferencia() {
		return diferencia;
	}
	public void setDiferencia(Double diferencia) {
		this.diferencia = diferencia;
	}
    
    
}
