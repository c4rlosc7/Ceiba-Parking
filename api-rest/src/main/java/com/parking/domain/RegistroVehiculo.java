package com.parking.domain;

public class RegistroVehiculo {
	
	private String placa;
	private String cilindraje;
	private int tipo;
	private String fechaIngreso;
	private String fechaSalida;
	private String costo;
	
	public RegistroVehiculo() {		
	}
	
	/* Constructor con parametros */
	public RegistroVehiculo(String placa, String cilindraje, int tipo, String fechaIngreso, String fechaSalida, String costo) {
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
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}	

	
	
}
