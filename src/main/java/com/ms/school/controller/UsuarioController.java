package com.ms.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.school.modals.entity.Usuario;
import com.ms.school.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping(value = "/")
	public List<Usuario> obtenerUsuarios() {
		return usuarioService.obtenerUsuarios();
	}
	
	@GetMapping(value = "/usu/{usuario}")
	public Usuario obtenerUsuario(@PathVariable String usuario) {
		return usuarioService.obtenerUsuario(usuario);
	}
}
