package br.com.template.service;

import java.util.List;

import br.com.template.entity.Usuario;

public interface IUsuarioService {

	Usuario findById(Long id);

	List<Usuario> findAll();

	void save(Usuario usuario);

	void remove(Usuario usuario);

}
