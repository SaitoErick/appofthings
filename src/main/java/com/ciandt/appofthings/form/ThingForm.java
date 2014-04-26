package com.ciandt.appofthings.form;

import com.ciandt.appofthings.domain.Thing;

public class ThingForm {

	private Long id;
	private String name;
	private Long localId;
	private String sensorName;
	private Boolean isActive = Boolean.TRUE;

	public ThingForm() {
	}

	public ThingForm(Thing thing) {
		this.id = thing.getId();
		this.name = thing.getName();
		this.localId = thing.getLocal().getId();
		this.sensorName = thing.getSensorName();
		this.isActive = thing.getIsActive();
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

	public Long getLocalId() {
		return localId;
	}

	public void setLocalId(Long localId) {
		this.localId = localId;
	}

	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Thing toThing() {
		Thing thing = new Thing();
		thing.setId(this.id);
		thing.setSensorName(this.sensorName);
		thing.setName(this.name);
		thing.setLocal(null);
		return thing;
	}

}