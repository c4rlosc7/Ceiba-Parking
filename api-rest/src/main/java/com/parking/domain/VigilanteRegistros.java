package com.parking.domain;

import java.util.List;

import com.parking.jpa.entity.Vehiculo;

public interface VigilanteRegistros {
	
	public List<Vehiculo> obtenerVehiculos();	
	
	public int cantidadCarros();
	
	public int cantidadMotos();
	
	public int cantidadVehiculosParqueados();
	
	public boolean espacioDisponibleParqueadero();
	

}
