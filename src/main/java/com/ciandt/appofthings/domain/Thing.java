package com.ciandt.appofthings.domain;

import java.util.Date;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Embed;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Cache
@Index
@Embed
@Entity
public class Thing {

	@Id
	private Long id;
	private String name;
	private String sensorName;
	private Local local;
	private Boolean isActive = Boolean.TRUE;
	private Date criation = new Date();

	public Thing() {
	}

	public Thing(String name, String sensorName, Local local) {
		this.name = name;
		this.sensorName = sensorName;
		this.local = local;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCriation() {
		return criation;
	}

	public void setCriation(Date criation) {
		this.criation = criation;
	}

}