package com.parking.repositories;

import org.springframework.data.repository.CrudRepository;

import com.parking.jpa.entity.RegistroVehiculoEntity;

public interface IRegistroVehiculoRepository extends CrudRepository<RegistroVehiculoEntity, Long> {

}
