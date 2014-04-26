package br.com.marcosvidolin.sgp.repository;

import java.util.List;

import br.com.marcosvidolin.sgp.entity.Produto;

public interface IProdutoRepository {

	Produto findById(Long id);

	List<Produto> findAll();

	void save(Produto produto);

	void update(Produto produto);

	void remove(Produto produto);

}
