package co.com.ceiba.estacionamiento.models;

public class Vehicle {
	
	private Long id;
	private String placa;
	private int cilindraje;
	private int tipo;
	
	public Vehicle(Long id, String placa, int cilindraje, int tipo) {
		this.id = id;
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.tipo = tipo;
	}

}
