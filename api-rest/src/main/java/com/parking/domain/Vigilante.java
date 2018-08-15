package com.parking.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.parking.constant.Constantes;
import com.parking.jpa.dao.IVehiculoDao;
import com.parking.jpa.entity.Vehiculo;

public class Vigilante implements VigilanteRegistros {		

	private IVehiculoDao vehiculoDao;
	Constantes constante;	
	
	/*
	 * Constructor con parametros Dao
	 */
	public Vigilante(IVehiculoDao vehiculoDao) {
		this.vehiculoDao = vehiculoDao;
	}

	/*
	 * Consutructor sin parametros
	 */
	public Vigilante() {

	}	
	
	@Override
	public List<Vehiculo> obtenerVehiculos() {
		List<Vehiculo> listaVehiculos;		
		listaVehiculos = (List<Vehiculo>) vehiculoDao.findAll();		
		return listaVehiculos;
	}
	
	@Override
	public int cantidadCarros() {
		int cantidadCarros = 0;
		List<Vehiculo> listaVehiculos = obtenerVehiculos();
		for(Vehiculo veh : listaVehiculos) {
			if(veh.getTipo() == constante.CARRO) {
				cantidadCarros += 1;
			}
		}
		return cantidadCarros;
	}

	@Override
	public int cantidadMotos() {
		return 0;
	}	

	@Override
	public boolean espacioDisponibleParqueadero() {
		int cantidad = cantidadVehiculosParqueados();
		return cantidad < 20;
	}

	@Override
	public int cantidadVehiculosParqueados() {		
		List<Vehiculo> listaVehiculos;		
		listaVehiculos = (List<Vehiculo>) vehiculoDao.findAll();
		int cantidadVehiculos = listaVehiculos.size();		
		return cantidadVehiculos;
	}


}
