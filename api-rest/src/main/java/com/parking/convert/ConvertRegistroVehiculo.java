package com.parking.convert;

import java.util.List;

import com.parking.domain.RegistroVehiculo;
import com.parking.jpa.entity.RegistroVehiculoEntity;

public class ConvertRegistroVehiculo {
	
	private ConvertRegistroVehiculo() {}
	
	public static RegistroVehiculo convertirADominio(RegistroVehiculoEntity vehiculoEntity) {
		RegistroVehiculo vehiculo = null;
		if(vehiculoEntity != null) {
			vehiculo = new RegistroVehiculo(vehiculoEntity.getPlaca(), vehiculoEntity.getCilindraje(), 
									vehiculoEntity.getTipo(), vehiculoEntity.getFechaIngreso(), 
									vehiculoEntity.getFechaSalida(), vehiculoEntity.getCosto());
		}
		return vehiculo;
	}
	
	public static List<RegistroVehiculo> convertirADominioLista(List<RegistroVehiculoEntity> vehiculolistaEntity) {
		List<RegistroVehiculo> vehiculoLista = null;
		if(vehiculolistaEntity != null) {
			for(int index = 0; index < vehiculolistaEntity.size(); index ++) {
				vehiculoLista.add(convertirADominio(vehiculolistaEntity.get(index)));
			}
		}
		return vehiculoLista;
	}	
	
	public static RegistroVehiculoEntity convertirAEntity(RegistroVehiculo vehiculo) {
		RegistroVehiculoEntity vehiculoEntity = new RegistroVehiculoEntity();
		vehiculoEntity.setPlaca(vehiculo.getPlaca());
		vehiculoEntity.setCilindraje(vehiculo.getCilindraje());
		vehiculoEntity.setTipo(vehiculo.getTipo());
		vehiculoEntity.setFechaIngreso(vehiculo.getFechaIngreso());
		vehiculoEntity.setFechaSalida(vehiculo.getFechaSalida());
		vehiculoEntity.setCosto(vehiculo.getCosto());
		return vehiculoEntity;
	}	

}
