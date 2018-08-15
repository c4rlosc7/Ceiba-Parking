package com.parking.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parking.domain.Vigilante;
import com.parking.jpa.dao.IVehiculoDao;
import com.parking.jpa.entity.Vehiculo;

@Service
public class VehiculoServiceImplement implements IVehiculoService {
	
	@Autowired
	private IVehiculoDao vehiculoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Vehiculo> obtenerVehiculos() {
		return (List<Vehiculo>) vehiculoDao.findAll();
	}

	@Override
	public Vehiculo agregar(Vehiculo vehiculo) {
		// aqui validacion del vigilante
		return vehiculoDao.save(vehiculo);
	}

}
