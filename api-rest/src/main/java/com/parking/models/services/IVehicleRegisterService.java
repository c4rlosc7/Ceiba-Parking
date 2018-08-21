package com.parking.models.services;

import java.util.List;

import com.parking.jpa.entity.*;

public interface IVehicleRegisterService {

	public List<VehicleRegisterEntity> getRegistrosVehiculos();
	
	public VehicleRegisterEntity saveRegistro(VehicleRegisterEntity registro);
	
	public void deleteRegistoVehiculo(Long id);
	
	public int obtenerXTipo();
	
}
