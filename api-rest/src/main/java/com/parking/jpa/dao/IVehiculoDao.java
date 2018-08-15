package com.parking.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.parking.jpa.entity.Vehiculo;

public interface IVehiculoDao extends CrudRepository<Vehiculo, Long> {

}
