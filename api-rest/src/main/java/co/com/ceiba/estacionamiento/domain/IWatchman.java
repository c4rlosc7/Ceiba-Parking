package co.com.ceiba.estacionamiento.domain;

import java.util.Date;

import co.com.ceiba.estacionamiento.models.Register;

public interface IWatchman {	
	
	public void validateInRegister(Register register);
	
	public long getDaysBetweenTwoDays(Date d1, Date d2);
	
	public long getHoursBetweenTwoDays(Date d1, Date d2);
	
	public Register calculo(Register register);
	
}
