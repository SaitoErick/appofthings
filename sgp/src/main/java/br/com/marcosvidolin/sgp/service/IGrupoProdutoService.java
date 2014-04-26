package br.com.marcosvidolin.sgp.service;

import java.util.List;

import br.com.marcosvidolin.sgp.entity.GrupoProduto;

public interface IGrupoProdutoService {

	GrupoProduto findById(Long id);

	List<GrupoProduto> findAll();

	void create(GrupoProduto grupoProduto);

	void update(GrupoProduto grupoProduto);

	void remove(GrupoProduto grupoProduto);

	void createAndEncryptPassword(GrupoProduto grupoProduto);

	void updateAndEncryptPassword(GrupoProduto grupoProduto);

}
