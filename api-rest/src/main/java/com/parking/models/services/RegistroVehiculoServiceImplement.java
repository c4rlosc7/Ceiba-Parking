package com.parking.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parking.constant.Constantes;
import com.parking.convert.ConvertRegistroVehiculo;
import com.parking.domain.RegistroVehiculo;
import com.parking.domain.Vigilante;
import com.parking.jpa.entity.RegistroVehiculoEntity;
import com.parking.repositories.IRegistroVehiculoRepository;

@Service
public class RegistroVehiculoServiceImplement implements IRegistroVehiculoService {
	
	@Autowired
	private IRegistroVehiculoRepository vehiculoRepository;		
	
	private Constantes tipoVehiculo;
	
	private ConvertRegistroVehiculo convertidor;
	
	private Vigilante vigilante = new Vigilante();

	@Override
	public List<RegistroVehiculoEntity> getRegistrosVehiculos() {
		return (List<RegistroVehiculoEntity>) vehiculoRepository.findAll();
	}

	@Override
	public RegistroVehiculoEntity saveRegistro(RegistroVehiculoEntity registro) {
		RegistroVehiculo vehiculo = convertidor.convertirADominio(registro);
		vigilante.espacioDisponible(vehiculo);
		return vehiculoRepository.save(registro);
	}

}
