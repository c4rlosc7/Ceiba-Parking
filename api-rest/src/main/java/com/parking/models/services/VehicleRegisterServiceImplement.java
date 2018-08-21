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
	private IVehicleRegisterRepository vehicleRepository;
	
	private ConvertDomainToEntity convert;
	
	private Watchman v;
	
	@PostConstruct
	public void initRepository () {
		v = new Watchman(vehicleRepository);
	}	

	@Override
	@Transactional(readOnly = true)
	public List<VehicleRegisterEntity> getListVehicleRegister() {
		return (List<VehicleRegisterEntity>) vehicleRepository.findAll();
	}

	@Override
	@Transactional
	public VehicleRegisterEntity saveVehicleRegister(VehicleRegisterEntity vehicle) {
		VehicleRegister registroDomain = convert.convertEntityToDomain(vehicle);
		v.validateInRegister(registroDomain);
		return vehicleRepository.save(vehicle);
	}

	@Override
	@Transactional
	public void deleteVehicleRegister(Long id) {
		vehicleRepository.deleteById(id);
	}

	@Override
	public VehicleRegisterEntity updatedVehicleRegister(VehicleRegisterEntity vehicle, Long id) {
		VehicleRegisterEntity vehicleUpdate = findById(id);
		vehicleUpdate.setId(vehicle.getId());
		vehicleUpdate.setPlaca(vehicle.getPlaca());
		vehicleUpdate.setCilindraje(vehicle.getCilindraje());
		vehicleUpdate.setTipo(vehicle.getTipo());
		return vehicleRepository.save(vehicleUpdate);
	}

	@Override
	public VehicleRegisterEntity findById(Long id) {
		return vehicleRepository.findById(id).orElse(null);
	}


}
