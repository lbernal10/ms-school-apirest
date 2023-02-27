package com.ms.school.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ms.school.modals.entity.Usuario;
import com.ms.school.repository.UsuarioRepository;
import com.ms.school.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UsuarioRepository usuarioRepository;
 
	@Override
	public List<Usuario> obtenerUsuarios() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioRepository.findAll();
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Usuario usuario = usuarioRepository.findByUsu(username);
    	
    	if(usuario == null) {
			log.error("Error en el login");
			throw new UsernameNotFoundException("Error en el login");
		}
    	
    	System.out.println(usuario.getRol().getNombre());
    	
    	List<GrantedAuthority> authorities = new ArrayList<>();
    	
		authorities.add(new SimpleGrantedAuthority(usuario.getRol().getNombre()));
		
    	return new User(usuario.getUsuario(), usuario.getClvUsuario(), usuario.getPersona().getActivo(), true, true, true, authorities);
    }

	@Override
	public Usuario obtenerUsuario(String username) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByUsu(username);
	}

}
