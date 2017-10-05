package service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuarios")
public class UsuarioService {

	@Inject
	private UsuarioCache usuarioCache;

	public UsuarioService() {
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> listarUsuarios() {
		List<Usuario> lstUsuarios = usuarioCache.listar();
		return lstUsuarios;
	}

	@GET
	@Path("/{idUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerUsuario(@PathParam("idUsuario") Long idUsuario) {
		Response response = Response.serverError().entity(idUsuario).build();
		try {
			Usuario usuario = usuarioCache.obtener(idUsuario);
			if (usuario != null) {
				response = Response.ok(usuario, MediaType.APPLICATION_JSON).build();
			} else {
				response = Response.status(Response.Status.NOT_FOUND).entity(idUsuario).build();
			}
		} catch (Exception e) {
			response = Response.serverError().entity(idUsuario).build();
		}
		return response;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response crear(Usuario usuario) {
		Response response = Response.serverError().entity(usuario).build();
		try {
			if (usuario.getId() != null) {
				response = Response.serverError().entity(usuario).build();
			} else if (usuario.getId() == null) {
				usuario = usuarioCache.crear(usuario);
				response = Response.ok(usuario, MediaType.APPLICATION_JSON).build();
			}
		} catch (Exception e) {
			response = Response.serverError().entity(usuario).build();
		}
		return response;
	}

	@PUT
	@Path("/{idUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Usuario usuario, @PathParam("idUsuario") Long idUsuario) {
		Response response = Response.serverError().entity(usuario).build();
		try {
			if (idUsuario != null) {
				usuario = usuarioCache.actualizar(usuario);
				response = Response.ok(true, MediaType.APPLICATION_JSON).build();
			} else {
				response = Response.status(Response.Status.NOT_FOUND).entity(usuario).build();
			}
		} catch (Exception e) {
			response = Response.serverError().entity(usuario).build();
		}
		return response;
	}

	@DELETE
	@Path("/{idUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminar(@PathParam("idUsuario") Long idUsuario) {
		Response response = Response.serverError().entity(idUsuario).build();
		try {
			Boolean respuesta = usuarioCache.eliminar(idUsuario);
			if (respuesta) {
				response = Response.ok(respuesta, MediaType.APPLICATION_JSON).build();
			} else {
				response = Response.status(Response.Status.NOT_FOUND).entity(respuesta).build();
			}
		} catch (Exception e) {
			response = Response.serverError().entity(idUsuario).build();
		}
		return response;
	}

}
