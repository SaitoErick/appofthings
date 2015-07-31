package com.ciandt.appofthings.repository;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ciandt.appofthings.domain.RoomStatusHistory;

@Repository
public class RoomStatusHistoryRepository {

	public void save(RoomStatusHistory roomStatusHistory) {
		ofy().save().entity(roomStatusHistory).now();
	}

	public void delete(RoomStatusHistory roomStatusHistory) {
		ofy().delete().entity(roomStatusHistory).now();
	}

	public RoomStatusHistory findById(Long id) {
		return ofy().load().type(RoomStatusHistory.class).id(id).now();
	}

	public List<RoomStatusHistory> findAll() {
		return ofy().load().type(RoomStatusHistory.class).list();
	}
	
	public List<RoomStatusHistory> findHistory(String room, int limit) {
		
		return ofy().load().type(RoomStatusHistory.class).filter("local.room", room).limit(limit).list();
	}

}