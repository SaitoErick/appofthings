package br.com.marcosvidolin.sgp.service;

import java.util.List;

import br.com.marcosvidolin.sgp.entity.Usuario;

public interface IUsuarioService {

	Usuario encryptPassword(Usuario usuario);

	Usuario findById(Long id);

	List<Usuario> findAll();

	void create(Usuario usuario);

	void update(Usuario usuario);

	void remove(Usuario usuario);

	void createAndEncryptPassword(Usuario usuario);

	void updateAndEncryptPassword(Usuario usuario);

}
