package com.parking.models.services;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parking.convert.ConvertRegistroVehiculo;
import com.parking.domain.RegistroVehiculo;
import com.parking.domain.Vigilante;
import com.parking.exceptions.ParqueoException;
import com.parking.jpa.entity.RegistroVehiculoEntity;
import com.parking.repositories.IRegistroVehiculoRepository;

@Service
public class RegistroVehiculoServiceImplement implements IRegistroVehiculoService {
	
	@Autowired
	private IRegistroVehiculoRepository vehiculoRepository;	
	
	private ConvertRegistroVehiculo convertidor;
	
	private Vigilante vigilante = new Vigilante();
	
	public static final String ERROR_CARGANDO_DATOS = "Error carga los datos";

	@Override
	@Transactional(readOnly = true)
	public List<RegistroVehiculoEntity> getRegistrosVehiculos() {
		return (List<RegistroVehiculoEntity>) vehiculoRepository.findAll();
	}

	@Override
	@Transactional
	public RegistroVehiculoEntity saveRegistro(RegistroVehiculoEntity registro) {
		RegistroVehiculo registroDomain = convertidor.convertirADominio(registro);
		//vigilante.espacioDisponible(registroDomain);
		vigilante.validRegistro(registroDomain);
		return vehiculoRepository.save(registro);
	}

	/*@Override
	@Transactional
	public RegistroVehiculoEntity deleteRegistoVehiculo(Long id) {
		return vehiculoRepository.findById(id);
	}*/
	
	/**
	 * Método que obtiene todos los registros agregados en la DB
	 * @return registroVehiculoLista
	 */
	public List<RegistroVehiculo> obtenerListaVehiculosDomain() {
		try {
			List<RegistroVehiculoEntity> registroVehiculosList = (List<RegistroVehiculoEntity>) vehiculoRepository.findAll();
			List<RegistroVehiculo> registroVehiculoLista = convertidor.convertirADominioLista(registroVehiculosList);
			return registroVehiculoLista;
		} catch (NoResultException e) {
			throw new ParqueoException(ERROR_CARGANDO_DATOS);
		}
	}	

}
