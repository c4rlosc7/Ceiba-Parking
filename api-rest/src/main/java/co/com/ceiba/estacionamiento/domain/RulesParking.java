package co.com.ceiba.estacionamiento.domain;

import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import co.com.ceiba.estacionamiento.exceptions.ParkingException;
import co.com.ceiba.estacionamiento.repositories.IRegisterRepository;

public class RulesParking {
	
	@Autowired
	private IRegisterRepository vehicleRepository;
	
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
	
	/**
	 * Método que valida si la placa inicia por la letra A
	 * @param placa
	 */
	public static void authorizedPlate(String placa) {
		char letter = placa.charAt(0);
		if (letter == CARACTER_A) authorizedDay();
	}
	
	/**
	 * Método que valida el día que va a ingresar el vehiculo, si esta autorizado a
	 * entrar
	 */
	public static void authorizedDay() {
		int dayOfWeek = dayOfWeek();
		if (dayOfWeek != DIA_DOMINGO && dayOfWeek != DIA_LUNES) {
			throw new ParkingException(INGRESO_NO_AUTORIZADO);
		}
	}
	
	/**
	 * Método que retorna el numero del día actual
	 * @return
	 */
	public static int dayOfWeek() {
		Date today = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		int day = c.get(Calendar.DAY_OF_WEEK);		
		return day;
	}
	
}
