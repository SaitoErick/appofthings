package br.com.marcosvidolin.sgp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.marcosvidolin.sgp.entity.Produto;
import br.com.marcosvidolin.sgp.service.IProdutoService;

/**
 * Controller responsavel por expor o CRUD de Produto para o cliente.
 * 
 * @author Marcos Vidolin
 * @since 06/11/2013
 */
@Controller
@RequestMapping("/produto")
public class ProdutoController {

	/**
	 * Servico do {@link Produto}.
	 */
	@Autowired
	private IProdutoService produtoService;

	/**
	 * Lista todos os Produtos do sistema.
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		modelMap.addAttribute("produtos", produtoService.findAll());
		return "/produto/list";
	}

	/**
	 * Exibe um Produto especifico.
	 * 
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String view(@PathVariable Long id, ModelMap modelMap) {
		modelMap.addAttribute("produto", produtoService.findById(id));
		return "/produto/view";
	}

	/**
	 * Prepara o formulario de criacao de Produto.
	 * 
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {
		modelMap.addAttribute("produto", new Produto());
		return "/produto/create";
	}

	/**
	 * Cria um Produto.
	 * 
	 * @param produto
	 * @param result
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid Produto produto, BindingResult result) {
		if (result.hasErrors())
			return "/produto/create";
		produtoService.createAndEncryptPassword(produto);
		return "redirect:/produto";
	}

	/**
	 * Prepara o formulario de atualizacao de Produto.
	 * 
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
		modelMap.addAttribute("produto", produtoService.findById(id));
		return "/produto/update";
	}

	/**
	 * Atualiza um Produto.
	 * 
	 * @param produto
	 * @param result
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public String update(@Valid Produto produto, BindingResult result) {
		if (result.hasErrors())
			return "/produto/update";
		produtoService.updateAndEncryptPassword(produto);
		return "redirect:/produto";
	}

	/**
	 * Prepara o formulario de delecao de Produto.
	 * 
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteForm(@PathVariable("id") Long id, ModelMap modelMap) {
		modelMap.addAttribute("produto", produtoService.findById(id));
		return "/produto/delete";
	}

	/**
	 * Remove um Produto.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public String delete(Produto produto) {
		produtoService.remove(produtoService.findById(produto.getId()));
		return "redirect:/produto";
	}

}