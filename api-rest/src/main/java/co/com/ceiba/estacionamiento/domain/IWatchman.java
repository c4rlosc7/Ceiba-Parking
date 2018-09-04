package co.com.ceiba.estacionamiento.domain;

import co.com.ceiba.estacionamiento.models.Register;
import co.com.ceiba.estacionamiento.models.Vehicle;

public interface IWatchman {	
	
	public void validateInRegister(Vehicle veh);	
	
	public Register calculo(Register register);
	
}
