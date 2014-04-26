package com.ciandt.appofthings.domain;

public class SensorLocal {

	private String arduinoName;
	private Sensor sensor;
	private Local local;

	public SensorLocal() {
	}

	public SensorLocal(String arduinoName, Sensor sensor, Local local) {
		this.arduinoName = arduinoName;
		this.sensor = sensor;
		this.local = local;
	}

	public String getArduinoName() {
		return arduinoName;
	}

	public void setArduinoName(String arduinoName) {
		this.arduinoName = arduinoName;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

}
