package br.com.marcosvidolin.sgp.service;

import java.util.List;

import br.com.marcosvidolin.sgp.entity.Produto;

public interface IProdutoService {

	Produto findById(Long id);

	List<Produto> findAll();

	void create(Produto produto);

	void update(Produto produto);

	void remove(Produto produto);

	void createAndEncryptPassword(Produto produto);

	void updateAndEncryptPassword(Produto produto);

}
