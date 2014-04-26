package br.com.template.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.template.entity.Usuario;
import br.com.template.repository.IUsuarioRepository;

@Repository
public class UsuarioRepository implements IUsuarioRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Usuario findById(Long id) {
		return em.find(Usuario.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {
		return em.createQuery("SELECT u FROM Usuario u").getResultList();
	}

	@Override
	public void save(Usuario usuario) {
		em.persist(usuario);
	}

	@Override
	public void remove(Usuario usuario) {
		em.remove(usuario);
	}
}
