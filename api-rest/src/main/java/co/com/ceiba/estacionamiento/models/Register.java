package co.com.ceiba.estacionamiento.models;

import java.time.LocalDateTime;
import java.util.Date;

public class Register {
	
	private Long id;
	private String placa;
	private int cilindraje;
	private int tipo;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private long costo;
	
	public Register() {		
	}

	
	/* Constructor con parametros */
	public Register(Long id, 
					String placa, 
					int cilindraje, 
					int tipo, 
					LocalDateTime fechaIngreso, 
					LocalDateTime fechaSalida, 
					long costo) {
		
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
	public int getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public long getCosto() {
		return costo;
	}
	public void setCosto(long costo) {
		this.costo = costo;
	}	

	
	
}
