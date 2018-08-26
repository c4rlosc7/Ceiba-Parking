package com.parking.models;

import java.util.Date;

public class Register {
	
	private Long id;
	private String placa;
	private String cilindraje;
	private int tipo;
	private Date fechaIngreso;
	private Date fechaSalida;
	private long costo;
	
	public Register() {		
	}

	
	/* Constructor con parametros */
	public Register(Long id, String placa, String cilindraje, int tipo, Date fechaIngreso, Date fechaSalida, long costo) {
		this.id = id;
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.tipo = tipo;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.costo = costo;
	}
	
	/* Getters y Setters */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public long getCosto() {
		return costo;
	}
	public void setCosto(long costo) {
		this.costo = costo;
	}	

	
	
}
