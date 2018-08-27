package co.com.ceiba.estacionamiento.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.estacionamiento.converter.ConvertMTE;
import co.com.ceiba.estacionamiento.entity.RegisterEntity;
import co.com.ceiba.estacionamiento.exceptions.*;
import co.com.ceiba.estacionamiento.models.Register;
import co.com.ceiba.estacionamiento.repositories.IRegisterRepository;
import co.com.ceiba.estacionamiento.services.RegisterServiceImplement;

public class Watchman implements IWatchman {

	public static final String NO_HAY_ESPACIO_PARA_CARRO = "No hay espacio para mas carros en el parqueadero";
	public static final String NO_HAY_ESPACIO_PARA_MOTO = "No hay mas espacio para mas motos en el parqueadero";
	public static final String INGRESO_NO_AUTORIZADO = "No esta autorizado para ingresar";
	public static final String ERROR_CARGANDO_DATOS = "Error carga los datos";

	public static final int CARRO = 1;
	public static final int MOTO = 2;

	public static final int MAX_CARROS = 20;
	public static final int MAX_MOTOS = 10;

	public static final int HORAS_MAX = 9;
	public static final char CARACTER_A = 'A';

	public static final int DIA_DOMINGO = 1;
	public static final int DIA_LUNES = 2;

	public static final int COSTO_X_HORA_CARRO = 1000;
	public static final int COSTO_X_HORA_MOTO = 500;
	public static final int COSTO_X_DIA_CARRO = 8000;
	public static final int COSTO_X_DIA_MOTO = 4000;
	public static final int CILINDRAE_BASE = 500;
	public static final int VALOR_ADICIONAL_ALTO_CILIDRAJE = 2000;

	@Autowired
	private IRegisterRepository vehicleRepository;

	/**
	 * Constructor sin parametros
	 */
	public Watchman() {
	}

	/**
	 * Constructor con parametros
	 * 
	 * @param vehicleRepository
	 */
	public Watchman(IRegisterRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}

	/**
	 * Valida regla del negocio si la placa inicia por la letra "A"
	 * 
	 * @param placa
	 */
	public void authorizedPlate(String placa) {
		char letter = placa.charAt(0);
		if (letter == CARACTER_A) authorizedDay();
	}

	/**
	 * M�todo que valida el d�a que va a ingresar el vehiculo, si esta autorizado a
	 * entrar
	 */
	public void authorizedDay() {
		Date today = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek != DIA_DOMINGO && dayOfWeek != DIA_LUNES) {
			throw new ParkingException(INGRESO_NO_AUTORIZADO);
		}
	}

	/**
	 * M�todo que valida el espacio disponible de carros o motos
	 * 
	 * @param tipo
	 */
	public void availableSpace(int type) {
		int numVehicles = 0;
		if (type == CARRO) {
			numVehicles = vehicleRepository.findAllCars();
			if (numVehicles >= 20)
				throw new ParkingException(NO_HAY_ESPACIO_PARA_CARRO);
		} else if (type == MOTO) {
			numVehicles = vehicleRepository.findAllMotorcycles();
			if (numVehicles >= 10)
				throw new ParkingException(NO_HAY_ESPACIO_PARA_MOTO);
		}
	}

	/**
	 * Implementa las reglas del negocio
	 * 
	 * @param register
	 */
	@Override
	public void validateInRegister(Register register) {
		authorizedPlate(register.getPlaca());
		availableSpace(register.getTipo());
	}

	/**
	 * M�todo que retorna la diferencia entre 2 fechas en d�as
	 */
	@Override
	public long getDaysBetweenTwoDays(Date d1, Date d2) {
		long time = Math.abs(d1.getTime() - d2.getTime());
		return TimeUnit.MILLISECONDS.toDays(time);
	}
	

	/**
	 * M�todo que retorn la diferencia entre 2 fechas en horas
	 */
	@Override
	public long getHoursBetweenTwoDays(Date d1, Date d2) {
		long time = Math.abs(d1.getTime() - d2.getTime());
		long hours = TimeUnit.MILLISECONDS.toHours(time);
		return hours + 1;
	}
	
	/**
	 * M�todo que evalua si el cilindraje ingresado en el vehiculo procesado es mayor al cilindraje base
	 * @param cylinder
	 * @return
	 */
	public boolean cylinderGreaterThan500(short cylinder) {
		return cylinder > CILINDRAE_BASE;
	}
	

	@Override
	public Register calculo(Register register) {
		long hours = getHoursBetweenTwoDays(register.getFechaIngreso(), register.getFechaSalida());
		if (hours < HORAS_MAX) {
			if (register.getTipo() == CARRO) {
				register.setCosto(hours * COSTO_X_HORA_CARRO);
			} else if (register.getTipo() == MOTO) {
				register.setCosto(hours * COSTO_X_HORA_MOTO);
			}
		} else {
			long days = getDaysBetweenTwoDays(register.getFechaIngreso(), register.getFechaSalida());
			if (register.getTipo() == CARRO) {
				register.setCosto(days * COSTO_X_DIA_CARRO);
			} else if (register.getTipo() == MOTO) {
				register.setCosto(days * COSTO_X_DIA_MOTO);
			}
		}
		return register;
	}

}