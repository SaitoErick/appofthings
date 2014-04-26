package br.com.projecttemplate.webservice.rest.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.projecttemplate.entity.Usuario;
import br.com.projecttemplate.service.UsuarioService;

@Path("/usuario")
@Produces("application/json")
public class UsuarioResource {

	@Inject
	private UsuarioService service;

	@GET
	@Path("/get")
	public Usuario test() {
		Usuario usuario = new Usuario("Marcos Vidolin 2", "mvidolin 2", "123456");
		service.save(usuario);
		return usuario;
	}

}
