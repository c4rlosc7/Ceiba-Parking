package com.parking.models;

public class Vehicle {
	
	private String placa;
	private String cilindraje;
	private int tipo;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String placa, String cilindraje, int tipo) {
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.tipo = tipo;
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
	
	

}
