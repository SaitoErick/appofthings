package br.com.marcosvidolin.sgp.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.marcosvidolin.sgp.entity.GrupoProduto;
import br.com.marcosvidolin.sgp.repository.IGrupoProdutoRepository;

@Repository
public class GrupoProdutoRepository implements IGrupoProdutoRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public GrupoProduto findById(Long id) throws EntityNotFoundException {
		GrupoProduto grupoProduto = em.find(GrupoProduto.class, id);
		if (grupoProduto == null)
			throw new EntityNotFoundException();
		return grupoProduto;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<GrupoProduto> findAll() {
		return em.createQuery("SELECT g FROM GrupoProduto g").getResultList();
	}

	@Override
	@Transactional
	public void save(GrupoProduto grupoProduto) {
		em.persist(grupoProduto);
	}

	@Override
	@Transactional
	public void update(GrupoProduto grupoProduto) {
		em.merge(grupoProduto);
	}

	@Override
	@Transactional
	public void remove(GrupoProduto grupoProduto) {
		em.remove(grupoProduto);
	}
}