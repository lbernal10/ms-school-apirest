package com.ms.school.service;

import java.util.List;
import com.ms.school.modals.entity.Usuario;

public interface UsuarioService {
	public List<Usuario> obtenerUsuarios();
	public Usuario obtenerUsuario(String username);
}
