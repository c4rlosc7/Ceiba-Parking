package com.parking.models.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parking.convert.ConvertDomainToEntity;
import com.parking.domain.VehicleRegister;
import com.parking.domain.Watchman;
import com.parking.jpa.entity.VehicleRegisterEntity;
import com.parking.repositories.IVehicleRegisterRepository;

@Service
public class VehicleRegisterServiceImplement implements IVehicleRegisterService {
	
	@Autowired
	private IVehicleRegisterRepository vehiculoRepository;
	
	private ConvertDomainToEntity convertidor;
	
	private Watchman vigilante;
	
	@PostConstruct
	public void initRepository () {
		vigilante = new Watchman(vehiculoRepository);
	}	

	@Override
	@Transactional(readOnly = true)
	public List<VehicleRegisterEntity> getRegistrosVehiculos() {
		return (List<VehicleRegisterEntity>) vehiculoRepository.findAll();
	}

	@Override
	@Transactional
	public VehicleRegisterEntity saveRegistro(VehicleRegisterEntity registro) {
		VehicleRegister registroDomain = convertidor.convertEntityToDomain(registro);
		vigilante.validRegistro(registroDomain);
		return vehiculoRepository.save(registro);
	}

	@Override
	@Transactional
	public void deleteRegistoVehiculo(Long id) {
		vehiculoRepository.deleteById(id);
	}

	@Override
	public int obtenerXTipo() {
		return vehiculoRepository.findAllCars();
	}	


}
