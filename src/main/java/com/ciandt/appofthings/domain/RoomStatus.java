package com.ciandt.appofthings.domain;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Index
@Entity
public class RoomStatus {

	@Id
	@JsonIgnore
	private Long id;
	@JsonIgnore
	private String arduinoName;
	private Local local;
	private Boolean busy = Boolean.FALSE;
	@JsonIgnore
	private Date lastActivity = new Date();

	public RoomStatus() {
	}

	public RoomStatus(Local local, Boolean busy, Date lastActivity) {
		this.local = local;
		this.busy = busy;
		this.lastActivity = lastActivity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArduinoName() {
		return arduinoName;
	}

	public void setArduinoName(String arduinoName) {
		this.arduinoName = arduinoName;
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

}