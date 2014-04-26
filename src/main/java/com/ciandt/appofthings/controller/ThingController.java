package com.ciandt.appofthings.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ciandt.appofthings.domain.Local;
import com.ciandt.appofthings.domain.Thing;
import com.ciandt.appofthings.form.ThingForm;
import com.ciandt.appofthings.service.LocalService;
import com.ciandt.appofthings.service.ThingService;

@Controller
@RequestMapping(value = "/admin/thing")
public class ThingController {

	private static final Logger LOGGER = Logger.getLogger(ThingController.class
			.getName());

	@Autowired
	private ThingService thingService;

	@Autowired
	private LocalService localService;

	@RequestMapping(method = RequestMethod.POST)
	public String create(ThingForm thingForm) {

		LOGGER.info(thingForm.getLocalId().toString());
		LOGGER.info(thingForm.getName());

		Local local = localService.findById(thingForm.getLocalId());
		Thing thing = new Thing(thingForm.getName(), thingForm.getSensorName(),
				local);

		try {
			thingService.save(thing);
		} catch (EntityExistsException e) {
			LOGGER.severe(e.getMessage());
		}

		return "redirect:/admin/thing/form/list";
	}

	@RequestMapping(method = RequestMethod.PUT)
	public String update(ThingForm thingForm) {
		Thing thing = thingForm.toThing();
		Local local = localService.findById(thingForm.getLocalId());
		thing.setLocal(local);
		thingService.save(thing);

		return "redirect:/admin/thing/form/list";
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public String delete(ThingForm thingForm) {
		thingService.delete(thingForm.toThing());

		return "redirect:/admin/thing/form/list";
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<Thing> list() {
		return thingService.findAll();
	}

	// form pages

	@RequestMapping(value = "/form/list", method = RequestMethod.GET)
	public String listForm(ModelMap modelMap) {
		modelMap.addAttribute("thingForm", new ThingForm());
		modelMap.addAttribute("locals", this.getLocalMap());
		modelMap.addAttribute("things", thingService.findAll());
		return "/admin/thing/form/list";
	}

	@RequestMapping(value = "/form/view/{id}", method = RequestMethod.GET)
	public String viewForm(@PathVariable Long id, ModelMap modelMap) {
		modelMap.addAttribute("thing", thingService.findById(id));
		return "/admin/thing/form/view";
	}

	@RequestMapping(value = "/form/create", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {

		modelMap.addAttribute("locals", this.getLocalMap());
		modelMap.addAttribute("thingForm", new ThingForm());

		return "/admin/thing/form/create";
	}

	@RequestMapping(value = "/form/update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, ModelMap modelMap) {

		Thing thing = thingService.findById(id);
		ThingForm thingForm = new ThingForm(thing);
		modelMap.addAttribute("thingForm", thingForm);
		modelMap.addAttribute("locals", this.getLocalMap());

		return "/admin/thing/form/update";
	}

	@RequestMapping(value = "/form/delete/{id}", method = RequestMethod.GET)
	public String deleteForm(@PathVariable("id") Long id, ModelMap modelMap) {
		modelMap.addAttribute("thing", thingService.findById(id));
		return "/admin/thing/form/delete";
	}

	private Map<Long, String> getLocalMap() {
		Map<Long, String> localMap = new HashMap<Long, String>();
		List<Local> locals = localService.findAll();
		for (Local local : locals) {
			localMap.put(local.getId(), local.toString());
		}
		return localMap;
	}

}