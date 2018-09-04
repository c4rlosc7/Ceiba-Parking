package co.com.ceiba.estacionamiento.controllers;

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

import co.com.ceiba.estacionamiento.entity.RegisterEntity;
import co.com.ceiba.estacionamiento.models.Register;
import co.com.ceiba.estacionamiento.models.Vehicle;
import co.com.ceiba.estacionamiento.services.IRegisterService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class VehicleRegisterController {

	@Autowired
	private IRegisterService vehicleService;
	
	/**
	 * Listar registro de vehiculos con la fecha salida en null
	 * @return
	 */
	@GetMapping("/vehicles")
	@ResponseStatus(HttpStatus.OK)
	public List<Register> getListRegisterCtr(){
		return vehicleService.getListRegisterSrv();
	}
	
	/**
	 * Agregar nuevo registro al parqueadero
	 * @param vehicle
	 * @return
	 */
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Register entryRegister(@RequestBody Vehicle veh) {
		return vehicleService.entryRegisterSrv(veh);
	}
	
	/**
	 * Elimina registro del parqueadero
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteRegister(@PathVariable Long id) {
		vehicleService.deleteRegister(id);
	}
	
	/**
	 * Método actualizar registro
	 * @param vehiculo
	 * @return
	 */
	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public RegisterEntity updateRegister(@RequestBody RegisterEntity vehicle, @PathVariable Long id) {
		return vehicleService.updatedRegister(vehicle, id);
	}
	
	/**
	 * Calculo del costo del parquedo
	 * @return
	 */
	@PutMapping("/calculate/{id}")
	@ResponseStatus(HttpStatus.OK)
	public RegisterEntity calculateFee(@PathVariable Long id) {
		return vehicleService.calculateFee(id);
	}
	
}
