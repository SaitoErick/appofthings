package com.ciandt.appofthings.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Index
@Entity
public class RoomStatusHistory {

	@Id
	private Long id;
	private Local local;
	private Boolean busy = Boolean.FALSE;
	@Index
	private Date lastActivity = new Date();
	private Set<Sensor> sensors = new HashSet<Sensor>();

	public RoomStatusHistory() {
	}

	public RoomStatusHistory(Local local, Boolean busy) {
		this.local = local;
		this.busy = busy;
	}

	public RoomStatusHistory(Local local, Boolean busy, Set<Sensor> sensors) {
		this.local = local;
		this.busy = busy;
		this.sensors = sensors;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Boolean getBusy() {
		return busy;
	}

	public void setBusy(Boolean busy) {
		this.busy = busy;
	}

	public Date getLastActivity() {
		return lastActivity;
	}

	public void setLastActivity(Date lastActivity) {
		this.lastActivity = lastActivity;
	}

	public Set<Sensor> getSensors() {
		return sensors;
	}

	public void setSensors(Set<Sensor> sensors) {
		this.sensors = sensors;
	}

	public void addSensor(Sensor sensor) {
		if (sensor.getStatus().toUpperCase()
				.equals(SensorStatus.ON.getSensorSatus()))
			this.busy = Boolean.TRUE;
		this.sensors.add(sensor);
	}

	public RoomStatus toRoomStatus() {
		return new RoomStatus(this.local, this.busy, this.lastActivity);
	}

}