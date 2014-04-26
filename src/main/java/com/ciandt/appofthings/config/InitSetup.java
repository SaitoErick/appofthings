package com.ciandt.appofthings.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ciandt.appofthings.domain.Local;
import com.ciandt.appofthings.domain.RoomStatus;
import com.ciandt.appofthings.domain.RoomStatusHistory;
import com.ciandt.appofthings.domain.Thing;
import com.googlecode.objectify.ObjectifyService;

public class InitSetup implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ObjectifyService.register(Local.class);
		ObjectifyService.register(Thing.class);
		ObjectifyService.register(RoomStatus.class);
		ObjectifyService.register(RoomStatusHistory.class);
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

}