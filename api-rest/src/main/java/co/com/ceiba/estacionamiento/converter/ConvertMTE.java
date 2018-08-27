package co.com.ceiba.estacionamiento.converter;

import java.util.List;

import co.com.ceiba.estacionamiento.entity.RegisterEntity;
import co.com.ceiba.estacionamiento.models.Register;

public class ConvertMTE {
	
	private ConvertMTE() {}
	
	/**
	 * Método que convierte una entidad a un modelo
	 * @param vehicleEntity
	 * @return
	 */
	public static Register convertEntityToModel(RegisterEntity vehicleEntity) {
		Register vehicle = null;
		if(vehicleEntity != null) {
			vehicle = new Register(vehicleEntity.getId(),
										   vehicleEntity.getPlaca(), 
										   vehicleEntity.getCilindraje(), 
										   vehicleEntity.getTipo(), 
										   vehicleEntity.getFechaIngreso(), 
										   vehicleEntity.getFechaSalida(), 
										   vehicleEntity.getCosto());
		}
		return vehicle;
	}
	
	/**
	 * Método que convierte una lista de entidades a una lista de modelo
	 * @param vehiclelistEntity
	 * @return
	 */
	public static List<Register> convertEntityToModelList(List<RegisterEntity> registerEntityList) {
		List<Register> list = null;
		if(registerEntityList != null) {
			for(int index = 0; index < registerEntityList.size(); index ++) {
				list.add(convertEntityToModel(registerEntityList.get(index)));
			}
		}
		return list;
	}	
	
	/**
	 * Método que convierte un modelo a una entidad
	 * @param vehicle
	 * @return
	 */
	public static RegisterEntity convertModelToEntity(Register register) {
		
		RegisterEntity registerEntity = new RegisterEntity();
		
		registerEntity.setId(register.getId());
		registerEntity.setPlaca(register.getPlaca());
		registerEntity.setCilindraje(register.getCilindraje());
		registerEntity.setTipo(register.getTipo());
		registerEntity.setFechaIngreso(register.getFechaIngreso());
		registerEntity.setFechaSalida(register.getFechaSalida());
		registerEntity.setCosto(register.getCosto());
		
		return registerEntity;
	}	
	
	/**
	 * Método que convierte una lista de modelo a una entidad
	 * @param vehiclelistEntity
	 * @return
	 */
	public static List<RegisterEntity> convertModelToEntityList(List<Register> registerList) {
		List<RegisterEntity> list = null;
		if(registerList != null) {
			for(int index = 0; index < registerList.size(); index ++) {
				list.add(convertModelToEntity(registerList.get(index)));
			}
		}
		return list;
	}

}
