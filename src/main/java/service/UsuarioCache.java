package service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;


@Named
public class UsuarioCache implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Map<Long, Usuario> usuarios = new HashMap<Long, Usuario>();

	public UsuarioCache() {
		System.out.println("Creando UsuarioCache");
	}

	public Usuario obtener(Long idUsuario) {
		return usuarios.get(idUsuario);
	};

	public List<Usuario> listar() {
		return new ArrayList<Usuario>(usuarios.values());
	};

	public Usuario crear(Usuario usuario) {
		usuario.setId(Long.valueOf(new Date().getTime()));
		usuarios.put(usuario.getId(), usuario);
		return usuario;
	}

	public Usuario actualizar(Usuario usuario) {
		usuarios.put(usuario.getId(), usuario);
		return usuario;
	}

	public Boolean eliminar(long id) {
		usuarios.remove(id);
		return true;
	}

}
