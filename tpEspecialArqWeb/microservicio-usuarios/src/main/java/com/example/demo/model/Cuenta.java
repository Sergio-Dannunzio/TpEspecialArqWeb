package com.example.demo.model;

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

@Entity
@Table(name = "cuenta")
public class Cuenta {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private Long id_mercado_pago; // muchas cuentas pueden tener la misma cuenta de mercado pago!
	    private Double saldo;
	    private Boolean isHabilitada;
	    @Column(name = "fecha_alta")
	    private LocalDateTime fecha_alta;

	    @ManyToMany(fetch = FetchType.LAZY)
	    private List<Usuario> usuarios;

	    public Cuenta() {
	        this.usuarios = new ArrayList<>();
	    }

	    public Cuenta (Long id_mercado_pago){
	        this.id_mercado_pago = id_mercado_pago;
	        this.saldo = 0.0;
	        this.isHabilitada = true;
	        this.fecha_alta = LocalDateTime.now();
	        this.usuarios = new ArrayList<>();
	    }
	    

	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId_mercado_pago() {
			return id_mercado_pago;
		}

		public void setId_mercado_pago(Long id_mercado_pago) {
			this.id_mercado_pago = id_mercado_pago;
		}

		public Double getSaldo() {
			return saldo;
		}

		public void setSaldo(Double saldo) {
			this.saldo = saldo;
		}

		public Boolean getIsHabilitada() {
			return isHabilitada;
		}

		public void setIsHabilitada(Boolean isHabilitada) {
			this.isHabilitada = isHabilitada;
		}

		public LocalDateTime getFecha_alta() {
			return fecha_alta;
		}

		public void setFecha_alta(LocalDateTime fecha_alta) {
			this.fecha_alta = fecha_alta;
		}

		public List<Usuario> getUsuarios() {
			return usuarios;
		}

		public void setUsuarios(List<Usuario> usuarios) {
			this.usuarios = usuarios;
		}

}
