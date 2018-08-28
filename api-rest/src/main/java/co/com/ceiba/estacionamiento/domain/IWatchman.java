package co.com.ceiba.estacionamiento.domain;

import co.com.ceiba.estacionamiento.models.Register;

public interface IWatchman {	
	
	public void validateInRegister(Register register);	
	
	public Register calculo(Register register);
	
}
