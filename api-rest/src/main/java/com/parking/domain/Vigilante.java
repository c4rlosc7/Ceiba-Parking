package com.parking.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.parking.constant.Constantes;
import com.parking.jpa.entity.RegistroVehiculoEntity;
import com.parking.models.services.RegistroVehiculoServiceImplement;
import com.parking.repositories.IRegistroVehiculoRepository;

public class Vigilante implements VigilanteRegistros {
	
	public static final String NO_HAY_ESPACIO_PARA_CARRO = "No hay espacio para mas carros en el parqueadero";
	public static final String NO_HAY_ESPACIO_PARA_MOTO = "No hay mas espacio para mas motos en el parqueadero";
	public static final String INGRESO_DOMINGO_LUNES = "Las placas que inician por la letra A solo pueden ingresar los dias domingo y lunes";

	private RegistroVehiculoServiceImplement vehiculoServiceImplement;
	
	private Constantes constantes;
	
	public Vigilante(RegistroVehiculoServiceImplement vehiculoService) {
		this.vehiculoServiceImplement = vehiculoService;
	}

	/*
	 * Consutructor sin parametros
	 */
	public Vigilante() {
	}

	@Override
	public void espacioDisponible(int tipo) {
		int cantidad = 0;
		List<RegistroVehiculo> listaVehiculos = vehiculoServiceImplement.obtenerRegistrosVehiculosDomain();
		for(RegistroVehiculo reg : listaVehiculos) {
			if(reg.getTipo() == tipo) {
				cantidad += 1;
			}
		}
		validarEspacioDisponible(cantidad, tipo);
	}
	
	public void validarEspacioDisponible(int cantidad, int tipo) {
		if(tipo == constantes.CARRO) {
			if(cantidad < constantes.MAX_CARROS) {
				//vehiculoServiceImplement.agregarRegistro()
			}
		}else if(tipo == constantes.MOTO) {
			if(cantidad < constantes.MAX_MOTOS) {
				//
			}
		}
	}




}
