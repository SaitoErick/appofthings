package br.com.template.repository;

import java.util.List;

import br.com.template.entity.Usuario;

public interface IUsuarioRepository {

	Usuario findById(Long id);

	List<Usuario> findAll();

	void save(Usuario usuario);

	void remove(Usuario usuario);

}
