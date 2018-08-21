package com.parking.domain;

import java.util.List;

import com.parking.jpa.entity.VehicleRegisterEntity;

public interface IWatchman {	
	
	public boolean espacioDisponible(VehicleRegister vehiculo);
	
}
