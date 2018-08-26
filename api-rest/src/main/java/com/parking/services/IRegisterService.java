package com.parking.services;

import java.util.List;

import com.parking.entity.*;

/**
 * Clase con los métodos para realizar la gestion del registro de vehiculos al parqueadero
 * @author carlos.martinez
 *
 */
public interface IRegisterService {

	public List<RegisterEntity> getListRegister();
	
	public RegisterEntity saveRegister(RegisterEntity vehicle);
	
	public void deleteRegister(Long id);
	
	public RegisterEntity updatedRegister(RegisterEntity vehicle, Long id);
	
	public RegisterEntity findById(Long id);
	
	public RegisterEntity calculateFee(Long id);
	
}
