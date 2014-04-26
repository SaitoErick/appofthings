package br.com.projecttemplate.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.projecttemplate.entity.Usuario;

@Stateless
public class UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(Usuario usuario) {
		entityManager.persist(usuario);
	}

	public void remove(Usuario usuario) {
		entityManager.remove(usuario);
	}

}
