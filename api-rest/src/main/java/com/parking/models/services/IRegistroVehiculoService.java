package com.parking.models.services;

import java.util.List;

import com.parking.jpa.entity.*;

public interface IRegistroVehiculoService {

	public List<RegistroVehiculoEntity> getRegistrosVehiculos();
	
	public RegistroVehiculoEntity saveRegistro(RegistroVehiculoEntity registro);
	
	public void deleteRegistoVehiculo(Long id);
}
