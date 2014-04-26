package br.com.projecttemplate.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.projecttemplate.dao.UsuarioDao;
import br.com.projecttemplate.entity.Usuario;

@Stateless
public class UsuarioService {

	@Inject
	private UsuarioDao dao;

	public void save(Usuario usuario) {
		dao.save(usuario);
	}

	public void remove(Usuario usuario) {
		dao.remove(usuario);
	}

}
