package com.parking.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import com.parking.convert.ConvertDomainToEntity;
import com.parking.exceptions.*;
import com.parking.jpa.entity.VehicleRegisterEntity;
import com.parking.models.services.VehicleRegisterServiceImplement;
import com.parking.repositories.IVehicleRegisterRepository;

public class Watchman implements IWatchman {

	public static final String NO_HAY_ESPACIO_PARA_CARRO = "No hay espacio para mas carros en el parqueadero";
	public static final String NO_HAY_ESPACIO_PARA_MOTO = "No hay mas espacio para mas motos en el parqueadero";
	public static final String INGRESO_NO_AUTORIZADO = "No esta autorizado para ingresar";

	public static final int CARRO = 1;
	public static final int MOTO = 2;

	public static final int MAX_CARROS = 20;
	public static final int MAX_MOTOS = 10;

	public static final char CARACTER_A = 'A';
	public static final String ERROR_CARGANDO_DATOS = "Error carga los datos";
	
	public static final int DIA_DOMINGO = 1;
	public static final int DIA_LUNES = 2;

	@Autowired
	private VehicleRegisterServiceImplement serviceImplent;

	@Autowired
	private IVehicleRegisterRepository vehiculoRepository;

	private ConvertDomainToEntity convertidor;

	/**
	 * Constructor sin parametros
	 */
	public Watchman() {
	}

	/**
	 * Constructor con parametros
	 * @param vehiculoRepository
	 */
	public Watchman(IVehicleRegisterRepository vehiculoRepository) {
		this.vehiculoRepository = vehiculoRepository;
	}

	@Override
	public boolean espacioDisponible(VehicleRegister vehiculo) {
		return false;
	}

	/**
	 * Método que obtiene todos los registros agregados en la DB
	 * @return registroVehiculoLista
	 */
	public List<VehicleRegister> obtenerListaVehiculosDomain() {
		try {
			List<VehicleRegisterEntity> registroVehiculosList = (List<VehicleRegisterEntity>) vehiculoRepository
					.findAll();
			List<VehicleRegister> registroVehiculoLista = convertidor.convertEntityToDomainList(registroVehiculosList);
			return registroVehiculoLista;
		} catch (NoResultException e) {
			throw new ParkingException(ERROR_CARGANDO_DATOS);
		}
	}

	/**
	 * Valida regla del negocio si la placa inicia por la letra "A"
	 * @param placa
	 */
	public void validarPlacaXA(String placa) {
		char letra = placa.charAt(0);
		if (letra == CARACTER_A) {
			diaAutorizado();
		}
	}
	
	/**
	 * Método que valida el día que va a ingresar el vehiculo, si esta autorizado a entrar
	 */
	public void diaAutorizado() {
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        
        if(dayOfWeek != DIA_DOMINGO && dayOfWeek != DIA_LUNES) {
        	throw new ParkingException(INGRESO_NO_AUTORIZADO);
        }
	}

	/**
	 * Método que valida el espacio disponible de carros o motos
	 * @param tipo
	 */
	public void validarEspacio(int tipo) {
		if (tipo == CARRO) {
			int cantidad = vehiculoRepository.findAllCars();
			if (cantidad >= 20) throw new ParkingException(NO_HAY_ESPACIO_PARA_CARRO);
		} else if (tipo == MOTO) {
			int cantidad = vehiculoRepository.findAllMotorcycles();
			if (cantidad >= 10) throw new ParkingException(NO_HAY_ESPACIO_PARA_MOTO);
		}
	}

	/**
	 * Implementa las reglas del negocio
	 * @param registro
	 */
	public void validRegistro(VehicleRegister registro) {
		validarPlacaXA(registro.getPlaca());
		validarEspacio(registro.getTipo());
	}

}
