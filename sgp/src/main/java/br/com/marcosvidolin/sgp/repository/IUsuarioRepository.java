package br.com.marcosvidolin.sgp.repository;

import java.util.List;

import br.com.marcosvidolin.sgp.entity.Usuario;

public interface IUsuarioRepository {

	Usuario findById(Long id);

	List<Usuario> findAll();

	void save(Usuario usuario);

	void update(Usuario usuario);

	void remove(Usuario usuario);

}
