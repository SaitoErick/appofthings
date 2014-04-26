package br.com.marcosvidolin.sgp.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.marcosvidolin.sgp.entity.Usuario;
import br.com.marcosvidolin.sgp.repository.IUsuarioRepository;

@Repository
public class UsuarioRepository implements IUsuarioRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Usuario findById(Long id) throws EntityNotFoundException {
		Usuario usuario = em.find(Usuario.class, id);
		if (usuario == null)
			throw new EntityNotFoundException();
		return usuario;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {
		return em.createQuery("SELECT u FROM Usuario u").getResultList();
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {
		em.persist(usuario);
	}

	@Override
	@Transactional
	public void update(Usuario usuario) {
		em.merge(usuario);
	}

	@Override
	@Transactional
	public void remove(Usuario usuario) {
		em.remove(usuario);
	}
}