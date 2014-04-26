package br.com.marcosvidolin.sgp.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.marcosvidolin.sgp.entity.GrupoProduto;
import br.com.marcosvidolin.sgp.repository.IGrupoProdutoRepository;
import br.com.marcosvidolin.sgp.service.IGrupoProdutoService;

@Service
public class GrupoProdutoService implements IGrupoProdutoService {

	@Autowired
	private IGrupoProdutoRepository repository;

	@Override
	public GrupoProduto findById(Long id) throws EntityNotFoundException {
		return repository.findById(id);
	}

	@Override
	public List<GrupoProduto> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void create(GrupoProduto grupoProduto) {
		repository.save(grupoProduto);
	}

	@Override
	@Transactional
	public void update(GrupoProduto grupoProduto) {
		repository.update(grupoProduto);
	}

	@Override
	@Transactional
	public void remove(GrupoProduto grupoProduto) {
		repository.remove(grupoProduto);
	}

	@Override
	@Transactional
	public void createAndEncryptPassword(GrupoProduto grupoProduto) {
		this.create(grupoProduto);
	}

	@Override
	@Transactional
	public void updateAndEncryptPassword(GrupoProduto grupoProduto) {
		this.update(grupoProduto);
	}

}
