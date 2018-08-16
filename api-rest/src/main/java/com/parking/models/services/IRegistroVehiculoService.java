package com.parking.models.services;

import java.util.List;

import com.parking.domain.RegistroVehiculo;
import com.parking.jpa.entity.*;

public interface IRegistroVehiculoService {

	public List<RegistroVehiculoEntity> obtenerRegistrosVehiculos();
	
	public void agregarRegistro(RegistroVehiculoEntity vehiculo);
	
	public RegistroVehiculoEntity agregarRegistro(RegistroVehiculo registro);
		
	
}
