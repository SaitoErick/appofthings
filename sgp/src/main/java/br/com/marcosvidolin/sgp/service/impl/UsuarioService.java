package br.com.marcosvidolin.sgp.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.marcosvidolin.sgp.entity.Usuario;
import br.com.marcosvidolin.sgp.repository.IUsuarioRepository;
import br.com.marcosvidolin.sgp.service.IUsuarioService;
import br.com.marcosvidolin.sgp.util.MD5Util;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuarioRepository repository;

	@Override
	public Usuario encryptPassword(Usuario usuario) {
		usuario.setPassword(MD5Util.toMD5(usuario.getPassword()));
		return usuario;
	}

	@Override
	public Usuario findById(Long id) throws EntityNotFoundException {
		return this.encryptPassword(repository.findById(id));
	}

	@Override
	public List<Usuario> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void create(Usuario usuario) {
		repository.save(usuario);
	}

	@Override
	@Transactional
	public void update(Usuario usuario) {
		repository.update(usuario);
	}

	@Override
	@Transactional
	public void remove(Usuario usuario) {
		repository.remove(usuario);
	}

	@Override
	@Transactional
	public void createAndEncryptPassword(Usuario usuario) {
		this.create(this.encryptPassword(usuario));
	}

	@Override
	@Transactional
	public void updateAndEncryptPassword(Usuario usuario) {
		this.update(this.encryptPassword(usuario));
	}

}
