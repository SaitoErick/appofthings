package com.ciandt.appofthings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ciandt.appofthings.domain.Local;
import com.ciandt.appofthings.service.LocalService;

@Controller
@RequestMapping(value = "/admin/local")
public class LocalController {

	@Autowired
	private LocalService service;

	@RequestMapping(method = RequestMethod.POST)
	public String create(Local local) {
		service.save(local);
		return "redirect:/admin/local/form/list";
	}

	@RequestMapping(method = RequestMethod.PUT)
	public String update(Local local) {
		service.save(local);
		return "redirect:/admin/local/form/list";
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public String delete(Local local) {
		service.delete(local);
		return "redirect:/admin/local/form/list";
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<Local> list() {
		return service.findAll();
	}

	@RequestMapping(value = "/{base}", method = RequestMethod.GET)
	public @ResponseBody
	List<Local> findByBase(@PathVariable String base) {
		return service.findByBase(base);
	}

	@RequestMapping(value = "/{base}/{building}", method = RequestMethod.GET)
	public @ResponseBody
	List<Local> findByBaseAndBuilding(String base, String building) {
		return service.findByBaseAndBuilding(base, building);
	}

	// form pages

	@RequestMapping(value = "/form/list", method = RequestMethod.GET)
	public String listForm(ModelMap modelMap) {
		modelMap.addAttribute("locals", service.findAll());
		return "/admin/local/form/list";
	}

	@RequestMapping(value = "/form/view/{id}", method = RequestMethod.GET)
	public String viewForm(@PathVariable Long id, ModelMap modelMap) {
		modelMap.addAttribute("local", service.findById(id));
		return "/admin/local/form/view";
	}

	@RequestMapping(value = "/form/create", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {
		modelMap.addAttribute("local", new Local());
		return "/admin/local/form/create";
	}

	@RequestMapping(value = "/form/update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
		modelMap.addAttribute("local", service.findById(id));
		return "/admin/local/form/update";
	}

	@RequestMapping(value = "/form/delete/{id}", method = RequestMethod.GET)
	public String deleteForm(@PathVariable("id") Long id, ModelMap modelMap) {
		modelMap.addAttribute("local", service.findById(id));
		return "/admin/local/form/delete";
	}

}