package com.ciandt.appofthings.repository;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ciandt.appofthings.domain.RoomStatus;

@Repository
public class RoomStatusRepository {

	public RoomStatus findById(Long id) {
		return ofy().load().type(RoomStatus.class).id(id).now();
	}

	public void save(RoomStatus roomStatus) {
		ofy().save().entity(roomStatus).now();
	}

	public List<RoomStatus> findAll() {
		return ofy().load().type(RoomStatus.class).list();
	}

	public List<RoomStatus> findAllByArduinoName(String arduinoName) {
		return ofy().load().type(RoomStatus.class)
				.filter("arduinoName", arduinoName).list();
	}

	public void delete(RoomStatus roomStatus) {
		ofy().delete().entity(roomStatus).now();
	}

	public void deleteAllFromArduinoName(String arduinoName) {
		List<RoomStatus> roomStatus = this.findAllByArduinoName(arduinoName);
		for (RoomStatus r : roomStatus) {
			this.delete(r);
		}
	}
}