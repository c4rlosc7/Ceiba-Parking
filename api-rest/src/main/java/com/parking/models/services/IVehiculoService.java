package com.parking.models.services;

import java.util.List;

import com.parking.jpa.entity.*;

public interface IVehiculoService {

	public List<Vehiculo> findAll();
	
}
