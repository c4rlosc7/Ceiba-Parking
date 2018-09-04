package co.com.ceiba.estacionamiento.models;

import java.time.LocalDateTime;

public class Register {

	private Long id;
	private Vehicle vehicle;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private long costo;

	public Register() {
	}

	/* Constructor */
	public Register(Long id, Vehicle vehicle, LocalDateTime fechaIngreso) {

		this.id = id;
		this.vehicle = vehicle;
		this.fechaIngreso = fechaIngreso;
		
	}

	/* Getters y Setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
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
