package com.parking.domain;

import java.util.Date;

public class VehicleRegister {
	
	private String placa;
	private String cilindraje;
	private int tipo;
	private Date fechaIngreso;
	private Date fechaSalida;
	private String costo;
	
	public VehicleRegister() {		
	}
	
	/* Constructor con parametros */
	public VehicleRegister(String placa, String cilindraje, int tipo, Date fechaIngreso, Date fechaSalida, String costo) {
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.tipo = tipo;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.costo = costo;
	}
	
	/* Getters y Setters */
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
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}	

	
	
}
