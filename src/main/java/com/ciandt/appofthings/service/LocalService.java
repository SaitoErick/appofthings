package com.ciandt.appofthings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciandt.appofthings.domain.Local;
import com.ciandt.appofthings.repository.LocalRepository;

@Service
public class LocalService {

	@Autowired
	private LocalRepository repository;

	public void save(Local local) {
		repository.save(local);
	}

	public void delete(Local local) {
		repository.delete(local);
	}

	public Local findById(Long id) {
		return repository.findById(id);
	}

	public List<Local> findAll() {
		return repository.findAll();
	}

	public List<Local> findByBase(String base) {
		return repository.findByBase(base);
	}

	public List<Local> findByBaseAndBuilding(String base, String building) {
		return repository.findByBaseAndBuilding(base, building);
	}

}