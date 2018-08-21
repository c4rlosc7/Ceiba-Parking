package com.parking.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.parking.jpa.entity.VehicleRegisterEntity;

public interface IVehicleRegisterRepository extends CrudRepository<VehicleRegisterEntity, Long> {

	@Query("SELECT COUNT(u.tipo) FROM VehicleRegisterEntity u WHERE u.tipo = 1")
	int findAllCars();
	
	@Query("SELECT COUNT(u.tipo) FROM VehicleRegisterEntity u WHERE u.tipo = 2")
	int findAllMotorcycles();
	
}
