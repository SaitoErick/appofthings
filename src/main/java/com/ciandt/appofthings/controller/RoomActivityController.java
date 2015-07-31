package com.ciandt.appofthings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ciandt.appofthings.domain.RoomStatus;
import com.ciandt.appofthings.service.RoomStatusService;
import com.ciandt.appofthings.service.RoomStatusHistoryService;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/status", produces = "application/json")
public class RoomActivityController {

	@Autowired
	private RoomStatusService roomStatusService;
	@Autowired
	private RoomStatusHistoryService roomStatusHistoryService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	String listAll(
			@RequestParam(value = "callback", required = false, defaultValue = "") String callback) {
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(roomStatusService.findAll());

		if (callback.isEmpty())
			return jsonResponse;

		return callback + " (" + jsonResponse + ")";
	}
	
	@RequestMapping(value = "/history/{room}/{limit}", method = RequestMethod.GET)
	public @ResponseBody
	String history(
			@RequestParam(value = "callback", required = false, defaultValue = "") String callback, @PathVariable("room") String room, @PathVariable("limit") int limit) {
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(roomStatusHistoryService.findHistory(room,limit));

		if (callback.isEmpty())
			return jsonResponse;

		return callback + " (" + jsonResponse + ")";
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	String findById(
			@RequestParam(value = "callback", required = false, defaultValue = "") String callback, @PathVariable("id") Long id) {
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(roomStatusService.findById(id));

		if (callback.isEmpty())
			return jsonResponse;

		return callback + " (" + jsonResponse + ")";
	}
	
	
	@RequestMapping(value = "/{base}", method = RequestMethod.GET)
	public @ResponseBody
	List<RoomStatus> listAllByBase(@PathVariable String base) {
		return null;
	}

	@RequestMapping(value = "/{base}/{building}", method = RequestMethod.GET)
	public @ResponseBody
	List<RoomStatus> listAllByBuilding(@PathVariable("base") String base,
			@PathVariable("building") String building) {
		return null;
	}

	@RequestMapping(value = "/{base}/{building}/{floor}", method = RequestMethod.GET)
	public @ResponseBody
	List<RoomStatus> listAllByFloor(@PathVariable("base") String base,
			@PathVariable("building") String building,
			@PathVariable("floor") String floor) {
		return null;
	}

	@RequestMapping(value = "/{base}/{building}/{floor}/{room}", method = RequestMethod.GET)
	public @ResponseBody
	List<RoomStatus> listAllByRoom(@PathVariable("base") String base,
			@PathVariable("building") String building,
			@PathVariable("floor") String floor,
			@PathVariable("room") String room) {
		return null;
	}

}