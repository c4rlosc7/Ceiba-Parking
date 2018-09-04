package co.com.ceiba.estacionamiento.domain;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import co.com.ceiba.estacionamiento.exceptions.ParkingException;
import co.com.ceiba.estacionamiento.repositories.IRegisterRepository;

public class RulesParking {
	
	@Autowired
	private IRegisterRepository vehicleRepository;
	

	public static final char CARACTER_A = 'A';
	public static final int CILINDRAE_BASE = 500;
	
	/**
	 * Método que valida si la placa inicia por la letra A
	 * @param placa
	 */
	public static boolean authorizedPlate(String placa) {
		char letter = placa.charAt(0);
		return letter == CARACTER_A;
	}
	
	/**
	 * Método que valida el día que va a ingresar el vehiculo, si esta autorizado a
	 * entrar
	 */
	/*public static void authorizedDay(int dayOfWeek) {
		if (dayOfWeek != DIA_DOMINGO && dayOfWeek != DIA_LUNES) {
			throw new ParkingException(INGRESO_NO_AUTORIZADO);
		}
	}*/
	
	/**
	 * Método que retorna un entero dependiendo del día de la semana E.G domingo = 1
	 * @return
	 */
	public static int todayIs() {
		Date today = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		return c.get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * Método que retorna la diferencia entre 2 fechas en días
	 */
	public static long getDaysBetweenTwoDays(LocalDateTime d1, LocalDateTime d2) {
		return Math.abs(d1.getDayOfYear() - d2.getDayOfYear());
	}
	

	/**
	 * Método que retorn la diferencia entre 2 fechas en horas
	 */
	public static long getHoursBetweenTwoDays(LocalDateTime d1, LocalDateTime d2) {
		long time = Math.abs(d1.toInstant(ZoneOffset.UTC).toEpochMilli() - d2.toInstant(ZoneOffset.UTC).toEpochMilli());
		return TimeUnit.MILLISECONDS.toHours(time);
	}
	
	/**
	 * Método que evalua si el cilindraje ingresado en el vehiculo procesado es mayor al cilindraje base
	 * @param cylinder
	 * @return
	 */
	public static boolean cylinderGreaterThan500(int cylinder) {
		return cylinder > CILINDRAE_BASE;
	}
	
}
