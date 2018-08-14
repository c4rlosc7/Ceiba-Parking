package com.parking.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.parking.models.entity.Vehiculo;

public interface IVehiculoDao extends CrudRepository<Vehiculo, Long> {

}
