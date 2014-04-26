package com.ciandt.appofthings.repository;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ciandt.appofthings.domain.Local;

@Repository
public class LocalRepository {

	public void save(Local local) {
		ofy().save().entity(local).now();
	}

	public void delete(Local local) {
		ofy().delete().entity(local).now();
	}

	public Local findById(Long id) {
		return ofy().load().type(Local.class).id(id).now();
	}

	public List<Local> findAll() {
		return ofy().load().type(Local.class).order("base").order("building")
				.order("floor").order("room").list();
	}

	public List<Local> findByBase(String base) {
		return ofy().load().type(Local.class).filter("base", base).list();
	}

	public List<Local> findByBaseAndBuilding(String base, String building) {
		return ofy().load().type(Local.class).filter("base", base)
				.filter("building", building).list();
	}

}