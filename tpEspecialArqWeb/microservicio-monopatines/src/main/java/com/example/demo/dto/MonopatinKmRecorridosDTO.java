package com.example.demo.dto;

public class MonopatinKmRecorridosDTO {
    private Long id_monopatin;
    private Double kilometros_recorridos;


    public MonopatinKmRecorridosDTO() { }

    public MonopatinKmRecorridosDTO(Long id_monopatin, Double kilometros_recorridos){
        this.id_monopatin = id_monopatin;
        this.kilometros_recorridos = kilometros_recorridos;
    }

	public Long getId_monopatin() {
		return id_monopatin;
	}

	public void setId_monopatin(Long id_monopatin) {
		this.id_monopatin = id_monopatin;
	}

	public Double getKilometros_recorridos() {
		return kilometros_recorridos;
	}

	public void setKilometros_recorridos(Double kilometros_recorridos) {
		this.kilometros_recorridos = kilometros_recorridos;
	}
    
    
}
