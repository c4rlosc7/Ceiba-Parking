package co.com.ceiba.estacionamiento.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.com.ceiba.estacionamiento.entity.RegisterEntity;

public interface IRegisterRepository extends CrudRepository<RegisterEntity, Long> {

	@Query("SELECT COUNT(u.tipo) FROM RegisterEntity u WHERE u.tipo = 1 AND u.fechaSalida IS NULL")
	int findAllCars();
	
	@Query("SELECT COUNT(u.tipo) FROM RegisterEntity u WHERE u.tipo = 2 AND u.fechaSalida IS NULL")
	int findAllMotorcycles();
	
}
