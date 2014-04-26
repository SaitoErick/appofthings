package br.com.marcosvidolin.sgp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.marcosvidolin.sgp.entity.Usuario;
import br.com.marcosvidolin.sgp.service.IUsuarioService;

/**
 * Controller responsavel por expor o CRUD de usuario para o cliente.
 * 
 * @author Marcos Vidolin
 * @since 25/09/2013
 */
@Controller
@RequestMapping("/admin/usuario")
public class UsuarioController {

	/**
	 * Servico do {@link Usuario}.
	 */
	@Autowired
	private IUsuarioService usuarioService;

	/**
	 * On an incoming request, any methods annotated with @ModelAttribute are
	 * called before any controller handler method (like requestHandlingMethod
	 * in the example above). These methods add data to a java.util.Map that is
	 * added to the Spring model before the execution of the handler method.
	 * 
	 * @see http 
	 *      ://www.intertech.com/Blog/understanding-spring-mvc-model-and-session
	 *      -attributes/
	 * @return
	 */
	@ModelAttribute("testUsuario")
	public Usuario addStuffToRequestScope() {
		System.out.println("Inserindo um usuario no scope de request");
		Usuario bean = new Usuario();
		bean.setLogin("mvidolin-test");
		return bean;
	}

	/**
	 * Lista todos os usuarios do sistema.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		modelMap.addAttribute("usuarios", usuarioService.findAll());
		return "/admin/usuario/list";
	}

	/**
	 * Exibe um usuario especifico.
	 * 
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String view(@PathVariable Long id, ModelMap modelMap) {
		modelMap.addAttribute("usuario", usuarioService.findById(id));
		return "/admin/usuario/view";
	}

	/**
	 * Prepara o formulario de criacao de usuario.
	 * 
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {
		modelMap.addAttribute("usuario", new Usuario());
		return "/admin/usuario/create";
	}

	/**
	 * Cria um usuario.
	 * 
	 * @param usuario
	 * @param result
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid Usuario usuario, BindingResult result) {
		if (result.hasErrors())
			return "/admin/usuario/create";
		usuarioService.createAndEncryptPassword(usuario);
		return "redirect:/admin/usuario";
	}

	/**
	 * Prepara o formulario de atualizacao de usuario.
	 * 
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
		modelMap.addAttribute("usuario", usuarioService.findById(id));
		return "/admin/usuario/update";
	}

	/**
	 * Atualiza um usuario.
	 * 
	 * @param usuario
	 * @param result
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public String update(@Valid Usuario usuario, BindingResult result) {
		if (result.hasErrors())
			return "/admin/usuario/update";
		usuarioService.updateAndEncryptPassword(usuario);
		return "redirect:/admin/usuario";
	}

	/**
	 * Prepara o formulario de delecao de usuario.
	 * 
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteForm(@PathVariable("id") Long id, ModelMap modelMap) {
		modelMap.addAttribute("usuario", usuarioService.findById(id));
		return "/admin/usuario/delete";
	}

	/**
	 * Remove um usuario.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public String delete(Usuario usuario) {
		usuarioService.remove(usuarioService.findById(usuario.getId()));
		return "redirect:/admin/usuario";
	}

	@RequestMapping(value = "/test/json", method = RequestMethod.GET/*
																	 * , headers
																	 * =
																	 * "Content-Type=application/json"
																	 */)
	@ResponseBody
	Object[] listAsJSON() {
		return new Object[] { "ActionScript", "AppleScript", "Asp", "BASIC",
				"C", "C++", "Clojure", "COBOL", "ColdFusion", "Erlang" };
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "/admin/usuario/test";
	}

}