package com.ciandt.appofthings.repository;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Repository;

import com.ciandt.appofthings.domain.Thing;

@Repository
public class ThingRepository {

	public void save(Thing thing) {
		ofy().save().entity(thing).now();
	}

	public void delete(Thing thing) {
		ofy().delete().entity(thing).now();
	}

	public Thing findById(Long id) {
		return ofy().load().type(Thing.class).id(id).now();
	}

	public List<Thing> findAllByName(String name) {
		return ofy().load().type(Thing.class).filter("name", name).list();
	}

	public Thing findByNameAndSensorName(String name, String sensorName) {
		List<Thing> things = ofy().load().type(Thing.class)
				.filter("name", name).filter("sensorName", sensorName).list();

		if (things == null || things.isEmpty())
			throw new EntityNotFoundException("No Thing with name " + name
					+ " and sensor name " + sensorName + " was found.");

		if (things.size() > 1)
			throw new EntityExistsException("More than one Thing with name "
					+ name + " and sensor name " + sensorName + " was found.");

		return things.get(0);
	}

	public List<Thing> findAll() {
		return ofy().load().type(Thing.class).list();
	}

}