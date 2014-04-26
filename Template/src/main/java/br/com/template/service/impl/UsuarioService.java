package br.com.template.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.template.entity.Usuario;
import br.com.template.repository.IUsuarioRepository;
import br.com.template.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuarioRepository repository;

	@Override
	public Usuario findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Usuario> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {
		repository.save(usuario);
	}

	@Override
	@Transactional
	public void remove(Usuario usuario) {
		repository.remove(usuario);
	}

}
