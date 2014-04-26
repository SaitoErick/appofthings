package br.com.marcosvidolin.sgp.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.marcosvidolin.sgp.entity.Produto;
import br.com.marcosvidolin.sgp.repository.IProdutoRepository;
import br.com.marcosvidolin.sgp.service.IProdutoService;

@Service
public class ProdutoService implements IProdutoService {

	@Autowired
	private IProdutoRepository repository;

	@Override
	public Produto findById(Long id) throws EntityNotFoundException {
		return repository.findById(id);
	}

	@Override
	public List<Produto> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void create(Produto produto) {
		repository.save(produto);
	}

	@Override
	@Transactional
	public void update(Produto produto) {
		repository.update(produto);
	}

	@Override
	@Transactional
	public void remove(Produto produto) {
		repository.remove(produto);
	}

	@Override
	@Transactional
	public void createAndEncryptPassword(Produto produto) {
		this.create(produto);
	}

	@Override
	@Transactional
	public void updateAndEncryptPassword(Produto produto) {
		this.update(produto);
	}

}
