package com.ciandt.appofthings.domain;

public enum SensorStatus {

	ON("ON"), OFF("OFF");

	private String sensorStatus;

	SensorStatus(String sensorStatus) {
		this.sensorStatus = sensorStatus;
	}

	public String getSensorSatus() {
		return this.sensorStatus;
	}

}
