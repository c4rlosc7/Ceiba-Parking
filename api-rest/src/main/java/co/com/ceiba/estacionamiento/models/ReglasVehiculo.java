package co.com.ceiba.estacionamiento.models;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.estacionamiento.exceptions.ParkingException;
import co.com.ceiba.estacionamiento.repositories.IRegisterRepository;

public class ReglasVehiculo {
	
	public static final String INGRESO_NO_AUTORIZADO = "No esta autorizado para ingresar";
	public static final int DIA_DOMINGO = 1;
	public static final int DIA_LUNES = 2;
	
	@Autowired
	private IRegisterRepository vehicleRepository;
	
	private int cantidadCarros;
	private int cantidadMotos;
	
	public ReglasVehiculo() {}		

	public ReglasVehiculo(IRegisterRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}

	public int getCantidadCarros() {
		return vehicleRepository.findAllCars();
	}

	public void setCantidadCarros(int cantidadCarros) {
		this.cantidadCarros = cantidadCarros;
	}

	public int getCantidadVehiculo() {
		return vehicleRepository.findAllParking();
	}

	public void setCantidadMotos(int cantidadMotos) {
		this.cantidadMotos = cantidadMotos;
	};
	
	public boolean espacioDisCarro() {
		if(this.cantidadCarros < 20) return true;
		return false;
	}
	
	public boolean espacioDisMoto() {
		if(this.cantidadMotos < 10) return true;
		return false;
	}
	
	/**
	 * Método que valida el día que va a ingresar el vehiculo, si esta autorizado a
	 * entrar
	 */
	public boolean authorizedDay(int dayOfWeek) {
		if (dayOfWeek != DIA_DOMINGO && dayOfWeek != DIA_LUNES) {
			return false;
		}
		return true;
	}
	
	
}
