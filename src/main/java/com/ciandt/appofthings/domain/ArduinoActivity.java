package com.ciandt.appofthings.domain;

import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

/*
 { 
 "name": "ArduinoCPS16", 
 "numSensors": 13 , 
 "sensors": [
 { "sensor": "sensor0", "status": "On"},
 { "sensor": "sensor1", "status": "Off"},
 { "sensor": "sensor2", "status": "On"}, 
 { "sensor": "sensor3", "status": "Off"}, 
 { "sensor": "sensor4", "status": "Off"}, 
 { "sensor": "sensor5", "status": "Off"}, 
 { "sensor": "sensor6", "status": "On"}, 
 { "sensor": "sensor7", "status": "Off"}, 
 { "sensor": "sensor8", "status": "On"}, 
 { "sensor": "sensor9", "status": "On"}, 
 { "sensor": "sensor10", "status": "Off"}, 
 { "sensor": "sensor11", "status": "Off"}, 
 { "sensor": "sensor12", "status": "Off"}
 ] 
 }
 */
@XmlRootElement
public class ArduinoActivity {

	@NotEmpty
	private String name;
	private Integer numSensors;
	private Set<Sensor> sensors;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumSensors() {
		return numSensors;
	}

	public void setNumSensors(Integer numSensors) {
		this.numSensors = numSensors;
	}

	public Set<Sensor> getSensors() {
		return sensors;
	}

	public void setSensors(Set<Sensor> sensors) {
		this.sensors = sensors;
	}

}
