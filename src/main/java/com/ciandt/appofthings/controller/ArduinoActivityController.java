package com.ciandt.appofthings.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ciandt.appofthings.domain.ArduinoActivity;
import com.ciandt.appofthings.service.RoomStatusHistoryService;

@Controller
@RequestMapping(value = "/activity", consumes = "application/json", produces = "application/json")
public class ArduinoActivityController {

	private static final Logger LOGGER = Logger
			.getLogger(ArduinoActivityController.class.getName());

	@Autowired
	private RoomStatusHistoryService roomStatusActivityService;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	ArduinoActivity activity(@RequestBody ArduinoActivity arduinoActivity) {
		LOGGER.info("Saving activity");
		roomStatusActivityService.saveActivityFrom(arduinoActivity);
		return arduinoActivity;
	}

}