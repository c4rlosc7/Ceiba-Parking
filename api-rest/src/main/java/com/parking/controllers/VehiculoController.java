package com.parking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.jpa.entity.Vehiculo;
import com.parking.models.services.IVehiculoService;

@RestController
@RequestMapping("/api")
public class VehiculoController {

	@Autowired
	private IVehiculoService vehiculoService;
	
	@GetMapping("/vehiculos")
	public List<Vehiculo> index(){
		return vehiculoService.obtenerVehiculos();
	}
	
}
