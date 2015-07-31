package com.ciandt.appofthings.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciandt.appofthings.domain.ArduinoActivity;
import com.ciandt.appofthings.domain.Local;
import com.ciandt.appofthings.domain.RoomStatus;
import com.ciandt.appofthings.domain.RoomStatusHistory;
import com.ciandt.appofthings.domain.Sensor;
import com.ciandt.appofthings.domain.SensorLocal;
import com.ciandt.appofthings.repository.RoomStatusHistoryRepository;
import com.ciandt.appofthings.util.SensorLocalUtil;

@Service
public class RoomStatusHistoryService {

	@Autowired
	private RoomStatusHistoryRepository repository;

	@Autowired
	private ThingService thingService;

	@Autowired
	private LocalService localService;

	@Autowired
	private RoomStatusService roomStatusService;

	public void save(RoomStatusHistory roomStatusHistory) {
		repository.save(roomStatusHistory);
	}

	public void delete(RoomStatusHistory roomStatusHistory) {
		repository.delete(roomStatusHistory);
	}

	public RoomStatusHistory findById(Long id) {
		return repository.findById(id);
	}

	public List<RoomStatusHistory> findAll() {
		return repository.findAll();
	}
	
	public List<RoomStatusHistory> findHistory(String room, int limit) {
		return repository.findHistory(room, limit);
	}

	/**
	 * Retorna a sola em que um sensor se encontr.
	 * 
	 * @param arduinoName
	 * @param sensor
	 * @return
	 */
	private SensorLocal getSensorLocal(final String arduinoName,
			final Sensor sensor) {
		Local local = thingService.findByNameAndSensorName(arduinoName,
				sensor.getName()).getLocal();
		return new SensorLocal(arduinoName, sensor, local);
	}

	public void saveActivityFrom(final ArduinoActivity arduinoActivity) {

		String arduinoName = arduinoActivity.getName();

		// faco isso para saber os locais (salas) dos sensores do arduino
		List<SensorLocal> sensorLocals = new ArrayList<SensorLocal>();
		for (Sensor arduinoSensor : arduinoActivity.getSensors()) {
			sensorLocals.add(this.getSensorLocal(arduinoName, arduinoSensor));
		}

		// remove todas as RoomStatus anteriores
		roomStatusService.deleteAllFromArduinoName(arduinoName);

		// persiste as atividades
		for (Local local : localService.findAll()) {
			List<SensorLocal> result = SensorLocalUtil.getSensorLocalFromLocal(
					sensorLocals, local);
			RoomStatusHistory roomStatusHistory = new RoomStatusHistory(local,
					Boolean.FALSE);
			for (SensorLocal sensorLocal : result) {
				roomStatusHistory.addSensor(sensorLocal.getSensor());
			}

			if (!roomStatusHistory.getSensors().isEmpty()) {
				RoomStatus roomStatus = roomStatusHistory.toRoomStatus();
				roomStatus.setArduinoName(arduinoName);
				roomStatusService.save(roomStatus);
				this.save(roomStatusHistory);
			}
		}

	}

}