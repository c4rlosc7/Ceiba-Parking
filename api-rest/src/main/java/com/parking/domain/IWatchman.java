package com.parking.domain;

import java.util.Date;

public interface IWatchman {	
	
	public void validateInRegister(VehicleRegister register);
	
	public long getDaysBetweenTwoDays(Date d1, Date d2);
	
	public long getHoursBetweenTwoDays(Date d1, Date d2);
	
}
