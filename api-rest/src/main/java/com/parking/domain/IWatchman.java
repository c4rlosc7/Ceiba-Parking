package com.parking.domain;

import java.util.Date;

import com.parking.models.Register;

public interface IWatchman {	
	
	public void validateInRegister(Register register);
	
	public long getDaysBetweenTwoDays(Date d1, Date d2);
	
	public long getHoursBetweenTwoDays(Date d1, Date d2);
	
	public Register calculo(Register register);
	
}
