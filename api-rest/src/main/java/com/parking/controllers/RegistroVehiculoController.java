package com.parking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.jpa.entity.RegistroVehiculoEntity;
import com.parking.models.services.IRegistroVehiculoService;

@RestController
@RequestMapping("/api")
public class RegistroVehiculoController {

	@Autowired
	private IRegistroVehiculoService vehiculoService;
	
	@GetMapping("/vehiculos")
	public List<RegistroVehiculoEntity> index(){
		return vehiculoService.obtenerRegistrosVehiculos();
	}
	
	@PostMapping("/agregar")
	public RegistroVehiculoEntity agregar(@RequestBody RegistroVehiculoEntity vehiculo) {
		return null;
	}
	
}
