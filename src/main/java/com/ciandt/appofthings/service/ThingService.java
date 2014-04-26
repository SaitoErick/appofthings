package com.ciandt.appofthings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciandt.appofthings.domain.Thing;
import com.ciandt.appofthings.repository.ThingRepository;

@Service
public class ThingService {

	@Autowired
	private ThingRepository repository;

	public void save(Thing thing) {
		repository.save(thing);
	}

	public void delete(Thing thing) {
		repository.delete(thing);
	}

	public Thing findById(Long id) {
		return repository.findById(id);
	}

	public List<Thing> findAllByName(String name) {
		return repository.findAllByName(name);
	}

	public Thing findByNameAndSensorName(String name, String sensorName) {
		return repository.findByNameAndSensorName(name, sensorName);
	}

	public List<Thing> findAll() {
		return repository.findAll();
	}

}