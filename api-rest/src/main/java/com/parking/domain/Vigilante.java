package com.parking.domain;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.constant.Constantes;
import com.parking.convert.ConvertRegistroVehiculo;
import com.parking.exceptions.*;
import com.parking.jpa.entity.RegistroVehiculoEntity;
import com.parking.models.services.RegistroVehiculoServiceImplement;
import com.parking.repositories.IRegistroVehiculoRepository;

public class Vigilante implements IVigilanteRegistros {

	public static final String NO_HAY_ESPACIO_PARA_CARRO = "No hay espacio para mas carros en el parqueadero";
	public static final String NO_HAY_ESPACIO_PARA_MOTO = "No hay mas espacio para mas motos en el parqueadero";
	public static final String INGRESO_DOMINGO_LUNES = "Las placas que inician por la letra A solo pueden ingresar los dias domingo y lunes";

	@Autowired
	private RegistroVehiculoServiceImplement serviceImplent;

	private IRegistroVehiculoRepository vehiculoRepository;

	private Constantes constantes = new Constantes();
	
	private ConvertRegistroVehiculo convertidor;


	 public Vigilante(IRegistroVehiculoRepository vehiculoRepository) {
		 this.vehiculoRepository = vehiculoRepository; 
	 }

	public Vigilante() {
	}

	@Autowired
	public Vigilante(RegistroVehiculoServiceImplement serviceImplent) {
		this.serviceImplent = serviceImplent;
	}

	@Override
	public boolean espacioDisponible(RegistroVehiculo vehiculo) {
		int totalVehiculo = getVehiculosXTipo(vehiculo);
		if (vehiculo.getTipo() == constantes.CARRO) {
			if (totalVehiculo < 20)
				return true;
		} else if (vehiculo.getTipo() == constantes.MOTO) {
			if (totalVehiculo < 10)
				return true;
		}
		return false;
	}
	
	public List<RegistroVehiculo> obtenerListaVehiculosDomain() {
		List<RegistroVehiculoEntity> registroVehiculosList = (List<RegistroVehiculoEntity>) vehiculoRepository.findAll();
		List<RegistroVehiculo> registroVehiculoLista = convertidor.convertirADominioLista(registroVehiculosList);
		return registroVehiculoLista;
	}	
	

	public int getVehiculosXTipo(RegistroVehiculo vehiculo) {
		try {
			int cantidad = 0;
			List<RegistroVehiculo> lista = obtenerListaVehiculosDomain();
			for (RegistroVehiculo regi : lista) {
				if (regi.getTipo() == vehiculo.getTipo()) {
					cantidad += 1;
				}
			}
			return cantidad;
		} catch (NoResultException e) {
			throw new ParqueoException(NO_HAY_ESPACIO_PARA_MOTO);
		}
	}

}
