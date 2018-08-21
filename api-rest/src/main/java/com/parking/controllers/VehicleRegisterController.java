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
	private IVehicleRegisterService vehiculoService;
	
	/**
	 * Listar registro de vehiculos
	 * @return
	 */
	@GetMapping("/vehicles")
	@ResponseStatus(HttpStatus.OK)
	public List<VehicleRegisterEntity> getListRegister(){
		return vehiculoService.getRegistrosVehiculos();
	}
	
	/**
	 * Agregar nuevo registro al parqueadero
	 * @param vehiculo
	 * @return
	 */
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public VehicleRegisterEntity saveRegister(@RequestBody VehicleRegisterEntity vehiculo) {
		return vehiculoService.saveRegistro(vehiculo);
	}
	
	/**
	 * Elimina registro del parqueadero
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteRegister(@PathVariable Long id) {
		vehiculoService.deleteRegistoVehiculo(id);
	}
	
	/**
	 * Método actualizar registro
	 * @param vehiculo
	 * @return
	 */
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public VehicleRegisterEntity updateRegister(@RequestBody VehicleRegisterEntity vehiculo) {
		return null;
	}
	
	/**
	 * Calculo del costo del parquedo
	 * @return
	 */
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public VehicleRegisterEntity calculateFee() {
		return null;
	}
	
	/**
	 * Método para realizar pruebas 
	 * @return
	 */
	@GetMapping("/test")
	public int obtenerXTipo(){
		return vehiculoService.obtenerXTipo();
	}	
	
}
