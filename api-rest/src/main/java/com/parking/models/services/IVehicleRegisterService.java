package com.parking.models.services;

import java.util.List;

import com.parking.jpa.entity.*;

/**
 * Clase con los métodos para realizar la gestion del registro de vehiculos al parqueadero
 * @author carlos.martinez
 *
 */
public interface IVehicleRegisterService {

	public List<VehicleRegisterEntity> getListVehicleRegister();
	
	public VehicleRegisterEntity saveVehicleRegister(VehicleRegisterEntity vehicle);
	
	public void deleteVehicleRegister(Long id);
	
	public VehicleRegisterEntity updatedVehicleRegister(VehicleRegisterEntity vehicle, Long id);
	
	public VehicleRegisterEntity findById(Long id);
	
	public void calculateFee(VehicleRegisterEntity vehicle, Long id);
	
}
