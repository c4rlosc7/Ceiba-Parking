package co.com.ceiba.estacionamiento.converter;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.estacionamiento.entity.RegisterEntity;
import co.com.ceiba.estacionamiento.exceptions.ParkingException;
import co.com.ceiba.estacionamiento.models.Register;

public class ConvertMTE {

	/**
	 * Constructor
	 */
	public ConvertMTE() { // Constructor vacio
	}

	/**
	 * Método que convierte una entidad a un modelo
	 * 
	 * @param vehicleEntity
	 * @return
	 */
	public static Register convertEntityToModel(RegisterEntity registerEntity) {
		try {
			Register register = null;
			if (registerEntity != null) {
				register = new Register(registerEntity.getId(), registerEntity.getPlaca(), 
									   registerEntity.getCilindraje(),registerEntity.getTipo(), 
									   registerEntity.getFechaIngreso(), registerEntity.getFechaSalida(),
									   registerEntity.getCosto());
			}
			return register;
		} catch (Exception e) {
			throw new ParkingException(e.getMessage());
		}
	}

	/**
	 * Método que convierte una lista de entidades a una lista de modelo
	 * 
	 * @param vehiclelistEntity
	 * @return
	 */
	public static List<Register> convertEntityToModelList(List<RegisterEntity> registerEntityList) {
		try {
			List<Register> list = new ArrayList<>();
			if (registerEntityList != null) {
				for(RegisterEntity en: registerEntityList) {
					list.add( convertEntityToModel(en) );
				}
			}
			return list;
		} catch (Exception e) {
			throw new ParkingException(e.getMessage());
		}
	}

	/**
	 * Método que convierte un modelo a una entidad
	 * 
	 * @param vehicle
	 * @return
	 */
	public static RegisterEntity convertModelToEntity(Register register) {
		try {
			RegisterEntity registerEntity = new RegisterEntity();

			registerEntity.setId(register.getId());
			registerEntity.setPlaca(register.getPlaca());
			registerEntity.setCilindraje(register.getCilindraje());
			registerEntity.setTipo(register.getTipo());
			registerEntity.setFechaIngreso(register.getFechaIngreso());
			registerEntity.setFechaSalida(register.getFechaSalida());
			registerEntity.setCosto(register.getCosto());

			return registerEntity;
		} catch (Exception e) {
			throw new ParkingException(e.getMessage());
		}
	}

	/**
	 * Método que convierte una lista de modelo a una entidad
	 * 
	 * @param vehiclelistEntity
	 * @return
	 */
	public static List<RegisterEntity> convertModelToEntityList(List<Register> registerList) {
		try {
			List<RegisterEntity> list = new ArrayList<>();
			if (registerList != null) {
				for(Register r: registerList) {
					list.add( convertModelToEntity(r) );
				}
			}
			return list;
		} catch (Exception e) {
			throw new ParkingException(e.getMessage());
		}
	}

}
