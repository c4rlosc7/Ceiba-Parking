package com.parking.domain;

import java.util.List;

import com.parking.jpa.dao.IVehiculoDao;
import com.parking.jpa.entity.Vehiculo;

public class Vigilante implements VigilanteRegistros {

	private IVehiculoDao vehiculoDao;

	public Vigilante(IVehiculoDao vehiculoDao) {
		this.vehiculoDao = vehiculoDao;
	}

	public Vigilante() {

	}

	@Override
	public boolean espacioDisponible() {
		int cantidadVehiculos;
		List<Vehiculo> listaVehiculos;
		listaVehiculos = (List<Vehiculo>) vehiculoDao.findAll();
		cantidadVehiculos = listaVehiculos.size();
		return cantidadVehiculos < 20;		
	}

}
