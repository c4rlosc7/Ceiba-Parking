package co.com.ceiba.estacionamiento.services;

import java.util.List;

import co.com.ceiba.estacionamiento.entity.*;
import co.com.ceiba.estacionamiento.models.Register;

/**
 * Clase con los métodos para realizar la gestion del registro de vehiculos al parqueadero
 * @author carlos.martinez
 *
 */
public interface IRegisterService {

	public List<Register> getListRegisterSrv();
	
	public RegisterEntity saveRegister(RegisterEntity vehicle);
	
	public void deleteRegister(Long id);
	
	public RegisterEntity updatedRegister(RegisterEntity vehicle, Long id);
	
	public RegisterEntity findById(Long id);
	
	public RegisterEntity calculateFee(Long id);

	
}
