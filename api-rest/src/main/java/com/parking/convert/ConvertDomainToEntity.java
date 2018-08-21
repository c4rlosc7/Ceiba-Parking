package com.parking.convert;

import java.util.List;

import com.parking.domain.VehicleRegister;
import com.parking.jpa.entity.VehicleRegisterEntity;

public class ConvertDomainToEntity {
	
	private ConvertDomainToEntity() {}
	
	/**
	 * Método que convierte una entidad a un dominio
	 * @param vehiculoEntity
	 * @return
	 */
	public static VehicleRegister convertEntityToDomain(VehicleRegisterEntity vehiculoEntity) {
		VehicleRegister vehiculo = null;
		if(vehiculoEntity != null) {
			vehiculo = new VehicleRegister(vehiculoEntity.getPlaca(), vehiculoEntity.getCilindraje(), 
									vehiculoEntity.getTipo(), vehiculoEntity.getFechaIngreso(), 
									vehiculoEntity.getFechaSalida(), vehiculoEntity.getCosto());
		}
		return vehiculo;
	}
	
	/**
	 * Método que convierte una lista de entidades a una lista de dominio
	 * @param vehiculolistaEntity
	 * @return
	 */
	public static List<VehicleRegister> convertEntityToDomainList(List<VehicleRegisterEntity> vehiculolistaEntity) {
		List<VehicleRegister> lista = null;
		if(vehiculolistaEntity != null) {
			for(int index = 0; index < vehiculolistaEntity.size(); index ++) {
				lista.add(convertEntityToDomain(vehiculolistaEntity.get(index)));
			}
		}
		return lista;
	}	
	
	/**
	 * Método que convierte un dominio a una entidad
	 * @param vehiculo
	 * @return
	 */
	public static VehicleRegisterEntity convertirAEntity(VehicleRegister vehiculo) {
		VehicleRegisterEntity vehiculoEntity = new VehicleRegisterEntity();
		vehiculoEntity.setPlaca(vehiculo.getPlaca());
		vehiculoEntity.setCilindraje(vehiculo.getCilindraje());
		vehiculoEntity.setTipo(vehiculo.getTipo());
		vehiculoEntity.setFechaIngreso(vehiculo.getFechaIngreso());
		vehiculoEntity.setFechaSalida(vehiculo.getFechaSalida());
		vehiculoEntity.setCosto(vehiculo.getCosto());
		return vehiculoEntity;
	}	

}
