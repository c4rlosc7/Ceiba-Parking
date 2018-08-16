package com.parking.domain;

import java.util.List;

import com.parking.jpa.entity.RegistroVehiculoEntity;

public interface IVigilanteRegistros {	
	
	public boolean espacioDisponible(RegistroVehiculo vehiculo);
	
}
