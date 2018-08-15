package com.parking.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.parking.constant.Constantes;
import com.parking.jpa.dao.IVehiculoDao;
import com.parking.jpa.entity.Vehiculo;
import com.parking.models.services.VehiculoServiceImplement;

public class Vigilante implements VigilanteRegistros {		

	private VehiculoServiceImplement vehiculoService;
	Constantes constante;	
	
	public Vigilante(VehiculoServiceImplement vehiculoService) {
		this.vehiculoService = vehiculoService;
	}

	/*
	 * Consutructor sin parametros
	 */
	public Vigilante() {
	}


	@Override
	public int cantidadCarros() {
		int cantidadCarros = 0;
		List<Vehiculo> listaVehiculos;
		listaVehiculos = vehiculoService.obtenerVehiculos();
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


}
