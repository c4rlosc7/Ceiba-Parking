package co.com.ceiba.estacionamiento.models;

import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.estacionamiento.exceptions.ParkingException;

public class Vehicle extends ReglasVehiculo {

	private String placa;
	private int cilindraje;
	private int tipo;
	
	/* Constructor */
	public Vehicle() { }
	
	public Vehicle(String placa, int cilindraje, int tipo) {
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
	
	public boolean espacioDisponible(int tipo) {
		getCantidadVehiculo(tipo);
		return false;
	}
	
	/**
	 * Método que valida si la placa inicia por la letra A
	 * @param placa
	 */
	public boolean authorizedPlate() {
		String placa = getPlaca();
		char letter = placa.charAt(0);
		return letter == 'A';
	}
	
	public void primeraRegla() {
		if(authorizedPlate()) {
			authorizedDay(todayIs());
		}
	}
	
	/**
	 * Método que retorna un entero dependiendo del día de la semana E.G domingo = 1
	 * @return
	 */
	public int todayIs() {
		Date today = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		return c.get(Calendar.DAY_OF_WEEK);
	}
	
}
