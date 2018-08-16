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
	
	private ConvertRegistroVehiculo convertidor;
	
	private Constantes tipoVehiculo;
	
	private Vigilante vigilante;

	public List<RegistroVehiculo> obtenerRegistrosVehiculosDomain() {
		List<RegistroVehiculoEntity> registroVehiculosList = (List<RegistroVehiculoEntity>) vehiculoRepository.findAll();
		List<RegistroVehiculo> registroVehiculoLista = convertidor.convertirADominioLista(registroVehiculosList);
		return registroVehiculoLista;
	}
	
	@Override
	public void agregarRegistro(RegistroVehiculoEntity vehiculo) {
		vigilante.espacioDisponible(vehiculo.getTipo());
	}

	@Override
	@Transactional(readOnly = true)
	public List<RegistroVehiculoEntity> obtenerRegistrosVehiculos() {
		return (List<RegistroVehiculoEntity>) vehiculoRepository.findAll();
	}

	@Override
	public RegistroVehiculoEntity agregarRegistro(RegistroVehiculo registro) {
		RegistroVehiculoEntity registroEntity = convertidor.convertirAEntity(registro);
		return vehiculoRepository.save(registroEntity);
	}

}
