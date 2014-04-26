package com.ciandt.appofthings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciandt.appofthings.domain.RoomStatus;
import com.ciandt.appofthings.repository.RoomStatusRepository;

@Service
public class RoomStatusService {

	@Autowired
	private RoomStatusRepository repository;

	public RoomStatus findById(Long id) {
		return repository.findById(id);
	}

	public void save(RoomStatus roomStatus) {
		repository.save(roomStatus);
	}

	public List<RoomStatus> findAll() {
		return repository.findAll();
	}

	public void delete(RoomStatus roomStatus) {
		repository.delete(roomStatus);
	}

	public void deleteAllFromArduinoName(String arduinoName) {
		repository.deleteAllFromArduinoName(arduinoName);
	}
}