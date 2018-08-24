package com.parking.convert;

import java.util.List;

import com.parking.domain.VehicleRegister;
import com.parking.jpa.entity.VehicleRegisterEntity;

public class ConvertDomainToEntity {
	
	private ConvertDomainToEntity() {}
	
	/**
	 * Método que convierte una entidad a un dominio
	 * @param vehicleEntity
	 * @return
	 */
	public static VehicleRegister convertEntityToDomain(VehicleRegisterEntity vehicleEntity) {
		VehicleRegister vehicle = null;
		if(vehicleEntity != null) {
			vehicle = new VehicleRegister(vehicleEntity.getPlaca(), 
										   vehicleEntity.getCilindraje(), 
										   vehicleEntity.getTipo(), 
										   vehicleEntity.getFechaIngreso(), 
										   vehicleEntity.getFechaSalida(), 
										   vehicleEntity.getCosto());
		}
		return vehicle;
	}
	
	/**
	 * Método que convierte una list de entidades a una list de dominio
	 * @param vehiclelistEntity
	 * @return
	 */
	public static List<VehicleRegister> convertEntityToDomainList(List<VehicleRegisterEntity> vehiclelistEntity) {
		List<VehicleRegister> list = null;
		if(vehiclelistEntity != null) {
			for(int index = 0; index < vehiclelistEntity.size(); index ++) {
				list.add(convertEntityToDomain(vehiclelistEntity.get(index)));
			}
		}
		return list;
	}	
	
	/**
	 * Método que convierte un dominio a una entidad
	 * @param vehicle
	 * @return
	 */
	public static VehicleRegisterEntity convertDomainToEntity(VehicleRegister vehicle) {
		
		VehicleRegisterEntity vehicleEntity = new VehicleRegisterEntity();
		
		vehicleEntity.setPlaca(vehicle.getPlaca());
		vehicleEntity.setCilindraje(vehicle.getCilindraje());
		vehicleEntity.setTipo(vehicle.getTipo());
		vehicleEntity.setFechaIngreso(vehicle.getFechaIngreso());
		vehicleEntity.setFechaSalida(vehicle.getFechaSalida());
		vehicleEntity.setCosto(vehicle.getCosto());
		
		return vehicleEntity;
	}	

}
