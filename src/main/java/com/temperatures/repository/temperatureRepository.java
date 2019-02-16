package com.temperatures.repository;

import org.springframework.data.repository.CrudRepository;

import com.temperatures.model.Temperature;

public interface temperatureRepository extends CrudRepository<Temperature,Integer> {
}
