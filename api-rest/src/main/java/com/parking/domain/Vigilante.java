package com.parking.domain;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import com.parking.convert.ConvertRegistroVehiculo;
import com.parking.exceptions.*;
import com.parking.jpa.entity.RegistroVehiculoEntity;
import com.parking.models.services.RegistroVehiculoServiceImplement;
import com.parking.repositories.IRegistroVehiculoRepository;

public class Vigilante implements IVigilanteRegistros {

	public static final String NO_HAY_ESPACIO_PARA_CARRO = "No hay espacio para mas carros en el parqueadero";
	public static final String NO_HAY_ESPACIO_PARA_MOTO = "No hay mas espacio para mas motos en el parqueadero";
	public static final String INGRESO_DOMINGO_LUNES = "Las placas inicia por la letra A. Solo pueden ingresar los dias Domingo y Lunes";	
	
	public static final int CARRO = 1;
	public static final int MOTO  = 2;
	
	public static final int MAX_CARROS = 20;
	public static final int MAX_MOTOS = 10;
	
	public static final char CARACTER_A = 'A';	

	@Autowired
	private RegistroVehiculoServiceImplement serviceImplent;

	private IRegistroVehiculoRepository vehiculoRepository;
	
	private ConvertRegistroVehiculo convertidor;

	/**
	 * Constructor sin parametros
	 */
	public Vigilante() {
	}
	
	/**
	 * Constructor con parametros
	 * @param vehiculoRepository
	 */
	 public Vigilante(IRegistroVehiculoRepository vehiculoRepository) {
		 this.vehiculoRepository = vehiculoRepository; 
	 }

	@Override
	public boolean espacioDisponible(RegistroVehiculo vehiculo) {
		return false;
	}
	
	/**
	 * Valida regla del negocio si la placa inicia por la letra "A"
	 * @param placa
	 */
	public void validarPlacaXA(String placa) {
		char letra = placa.charAt(0);
		if(letra == CARACTER_A) {			
			throw new ParqueoException(INGRESO_DOMINGO_LUNES);
		}
	}
	
	/**
	 * Método que permite conocer la cantidad de carros disponibles
	 */
	public void espacioCarros() {
		int cantidad = 0;
		List<RegistroVehiculo> listaVehiculos = serviceImplent.obtenerListaVehiculosDomain();
		for(RegistroVehiculo veh : listaVehiculos) {
			if(veh.getTipo() == CARRO) {
				cantidad += 1;
			}			
		}
		if(cantidad >= MAX_CARROS) {
			throw new ParqueoException(NO_HAY_ESPACIO_PARA_CARRO);
		}		
	}
	
	/**
	 * Método que permite conocer la cantidad de motos disponibles
	 */	
	public void espacioMotos() {
		int cantidad = 0;
		List<RegistroVehiculo> listaVehiculos = serviceImplent.obtenerListaVehiculosDomain();
		for(RegistroVehiculo veh : listaVehiculos) {
			if(veh.getTipo() == MOTO) {
				cantidad += 1;
			}
		}
		if(cantidad >= MAX_MOTOS) {
			throw new ParqueoException(NO_HAY_ESPACIO_PARA_MOTO);
		}
	}
	
	/**
	 * 
	 * @param tipo
	 */
	public void validarEspacio(int tipo) {
		if(tipo == CARRO) {
			espacioCarros();
		}else if(tipo == MOTO) {
			espacioMotos();
		}
	}
	
	/**
	 * Implementa las reglas del negocio
	 * @param registro
	 */
	public void validRegistro(RegistroVehiculo registro) {
		validarPlacaXA(registro.getPlaca());
		validarEspacio(registro.getTipo());
	}	

}
