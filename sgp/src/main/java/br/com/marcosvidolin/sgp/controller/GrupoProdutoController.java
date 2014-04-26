package br.com.marcosvidolin.sgp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.marcosvidolin.sgp.entity.GrupoProduto;
import br.com.marcosvidolin.sgp.service.IGrupoProdutoService;

/**
 * Controller responsavel por expor o CRUD de GrupoProduto para o cliente.
 * 
 * @author Marcos Vidolin
 * @since 06/11/2013
 */
@Controller
@RequestMapping("/grupoproduto")
public class GrupoProdutoController {

	/**
	 * Servico do {@link GrupoProduto}.
	 */
	@Autowired
	private IGrupoProdutoService grupoProdutoService;

	/**
	 * Lista todos os GrupoProdutos do sistema.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		modelMap.addAttribute("grupoProdutos", grupoProdutoService.findAll());
		return "/grupoProduto/list";
	}

	/**
	 * Exibe um GrupoProduto especifico.
	 * 
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String view(@PathVariable Long id, ModelMap modelMap) {
		modelMap.addAttribute("grupoProduto", grupoProdutoService.findById(id));
		return "/grupoProduto/view";
	}

	/**
	 * Prepara o formulario de criacao de GrupoProduto.
	 * 
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {
		modelMap.addAttribute("grupoProduto", new GrupoProduto());
		return "/grupoProduto/create";
	}

	/**
	 * Cria um GrupoProduto.
	 * 
	 * @param grupoProduto
	 * @param result
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid GrupoProduto grupoProduto, BindingResult result) {
		if (result.hasErrors())
			return "/grupoProduto/create";
		grupoProdutoService.createAndEncryptPassword(grupoProduto);
		return "redirect:/grupoproduto";
	}

	/**
	 * Prepara o formulario de atualizacao de GrupoProduto.
	 * 
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
		modelMap.addAttribute("grupoProduto", grupoProdutoService.findById(id));
		return "/grupoProduto/update";
	}

	/**
	 * Atualiza um GrupoProduto.
	 * 
	 * @param grupoProduto
	 * @param result
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public String update(@Valid GrupoProduto grupoProduto, BindingResult result) {
		if (result.hasErrors())
			return "/grupoProduto/update";
		grupoProdutoService.updateAndEncryptPassword(grupoProduto);
		return "redirect:/grupoproduto";
	}

	/**
	 * Prepara o formulario de delecao de GrupoProduto.
	 * 
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteForm(@PathVariable("id") Long id, ModelMap modelMap) {
		modelMap.addAttribute("grupoProduto", grupoProdutoService.findById(id));
		return "/grupoProduto/delete";
	}

	/**
	 * Remove um GrupoProduto.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public String delete(GrupoProduto grupoProduto) {
		grupoProdutoService.remove(grupoProdutoService.findById(grupoProduto
				.getId()));
		return "redirect:/grupoproduto";
	}

}