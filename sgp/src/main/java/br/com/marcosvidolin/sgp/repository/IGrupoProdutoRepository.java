package br.com.marcosvidolin.sgp.repository;

import java.util.List;

import br.com.marcosvidolin.sgp.entity.GrupoProduto;

public interface IGrupoProdutoRepository {

	GrupoProduto findById(Long id);

	List<GrupoProduto> findAll();

	void save(GrupoProduto grupoProduto);

	void update(GrupoProduto grupoProduto);

	void remove(GrupoProduto grupoProduto);

}
