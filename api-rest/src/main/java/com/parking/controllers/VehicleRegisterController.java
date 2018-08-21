package com.parking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.parking.jpa.entity.VehicleRegisterEntity;
import com.parking.models.services.IVehicleRegisterService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class VehicleRegisterController {

	@Autowired
	private IVehicleRegisterService vehicleService;
	
	/**
	 * Listar registro de vehiculos con la fecha salida en null
	 * @return
	 */
	@GetMapping("/vehicles")
	@ResponseStatus(HttpStatus.OK)
	public List<VehicleRegisterEntity> getListVehicleRegister(){
		return vehicleService.getListVehicleRegister();
	}
	
	/**
	 * Agregar nuevo registro al parqueadero
	 * @param vehicle
	 * @return
	 */
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public VehicleRegisterEntity saveVehicleRegister(@RequestBody VehicleRegisterEntity vehicle) {
		return vehicleService.saveVehicleRegister(vehicle);
	}
	
	/**
	 * Elimina registro del parqueadero
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteVehicleRegister(@PathVariable Long id) {
		vehicleService.deleteVehicleRegister(id);
	}
	
	/**
	 * Método actualizar registro
	 * @param vehiculo
	 * @return
	 */
	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public VehicleRegisterEntity updateVehicleRegister(@RequestBody VehicleRegisterEntity vehicle, @PathVariable Long id) {
		return vehicleService.updatedVehicleRegister(vehicle, id);
	}
	
	/**
	 * Calculo del costo del parquedo
	 * @return
	 */
	@PostMapping("/calculate")
	@ResponseStatus(HttpStatus.OK)
	public VehicleRegisterEntity calculateFee(@RequestBody VehicleRegisterEntity vehicle, Long id) {
		return null;
	}
	
}
