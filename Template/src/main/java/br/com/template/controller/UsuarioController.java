package br.com.template.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.template.entity.Usuario;
import br.com.template.service.IUsuarioService;

/**
 * Controller responsavel por expor o CRUD de usuario para o cliente.
 * 
 * @author Marcos Vidolin
 * @since 25/09/2013
 * 
 */
@Controller
@RequestMapping("/admin/usuarios/**")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	/**
	 * Retorna uma lista contendo todos os usuarios cadastrados.
	 * 
	 * @return List
	 * @throws Exception 
	 */
	@RequestMapping(value = "/admin/usuarios/", method = RequestMethod.GET)
	public String list() throws Exception {
		if (true)
		throw new Exception();
		usuarioService.findAll();
		return null;
	}

	@RequestMapping(value = "/admin/usuarios/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Usuario show(@PathVariable("id") Long id) {
		return usuarioService.findById(id);
	}

	/**
	 * Redireciona para o formulario de cadastro de {@link Usuario}.
	 * 
	 * @param modelMap
	 * @return
	 */
	public String form(ModelMap modelMap) {
		modelMap.addAttribute("usuario", new Usuario());
		return "admin/usuarios/create";
	}

	/**
	 * Cria um usuario.
	 * 
	 * @param usuario
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/admin/usuarios", method = RequestMethod.POST)
	public String create(@Valid Usuario usuario, BindingResult result) {
		if (result.hasErrors())
			return "admin/usuarios/create";
		usuarioService.save(usuario);
		return "redirect:/admin/usuarios";
	}

}