package co.com.ceiba.estacionamiento.services;

import java.util.List;

import co.com.ceiba.estacionamiento.entity.*;
import co.com.ceiba.estacionamiento.models.Register;
import co.com.ceiba.estacionamiento.models.Vehicle;

/**
 * Clase con los m�todos para realizar la gestion del registro de vehiculos al parqueadero
 * @author carlos.martinez
 *
 */
public interface IRegisterService {

	public List<Register> getListRegisterSrv();
	
	public Register entryRegisterSrv(Vehicle veh);
	
	public void deleteRegister(Long id);
	
	public RegisterEntity updatedRegister(RegisterEntity vehicle, Long id);
	
	public RegisterEntity findById(Long id);
	
	public RegisterEntity calculateFee(Long id);

	
}
