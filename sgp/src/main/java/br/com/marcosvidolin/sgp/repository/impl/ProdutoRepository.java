package br.com.marcosvidolin.sgp.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.marcosvidolin.sgp.entity.Produto;
import br.com.marcosvidolin.sgp.repository.IProdutoRepository;

@Repository
public class ProdutoRepository implements IProdutoRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Produto findById(Long id) throws EntityNotFoundException {
		Produto produto = em.find(Produto.class, id);
		if (produto == null)
			throw new EntityNotFoundException();
		return produto;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Produto> findAll() {
		return em.createQuery("SELECT p FROM Produto p").getResultList();
	}

	@Override
	@Transactional
	public void save(Produto produto) {
		em.persist(produto);
	}

	@Override
	@Transactional
	public void update(Produto produto) {
		em.merge(produto);
	}

	@Override
	@Transactional
	public void remove(Produto produto) {
		em.remove(produto);
	}
}