package com.parking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.parking.jpa.entity.RegistroVehiculoEntity;
import com.parking.models.services.IRegistroVehiculoService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class RegistroVehiculoController {

	@Autowired
	private IRegistroVehiculoService vehiculoService;
	
	/**
	 * Listar registro de vehiculos
	 * @return
	 */
	@GetMapping("/vehiculos")
	public List<RegistroVehiculoEntity> index(){
		return vehiculoService.getRegistrosVehiculos();
	}
	
	/**
	 * Agregar nuevo registro al parqueadero
	 * @param vehiculo
	 * @return
	 */
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public RegistroVehiculoEntity saveRegistro(@RequestBody RegistroVehiculoEntity vehiculo) {
		return vehiculoService.saveRegistro(vehiculo);
	}
	
	/**
	 * Elimina registro del parqueadero
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteRegistro(@PathVariable Long id) {
		vehiculoService.deleteRegistoVehiculo(id);
	}
	
	/**
	 * Calculo del costo del parquedo
	 * @return
	 */
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public RegistroVehiculoEntity calculateFee() {
		return null;
	}
	
	
}
