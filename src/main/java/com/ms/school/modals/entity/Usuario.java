package com.ms.school.modals.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.ForeignKey;
@Entity
@Table(name = "t_usuarios")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -6884605569137847617L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_t_usuarios")
	private Long id;
	
	@Column(name = "usuario", length = 80)
	private String usuario;
	
	@Column(name = "clv_usuario", length = 80)
	private String clvUsuario;
	
	//@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "id_t_roles" )
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	//private Rol rol;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_t_roles", nullable = false, foreignKey = @ForeignKey(name = "t_usuarios_id_t_roles_fkey"))
	private Rol rol;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_t_persona", nullable = false, foreignKey = @ForeignKey(name = "t_usuarios_id_t_persona_fkey"))
	private Persona persona;
	    

	//@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "id_t_persona" )
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	//private Persona persona;
	
	public Usuario() {
	}

	public Usuario(Long id, String usuario, String clvUsuario, Rol rol, Persona persona) {
		this.id = id;
		this.usuario = usuario;
		this.clvUsuario = clvUsuario;
		this.rol = rol;
		this.persona = persona;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClvUsuario() {
		return clvUsuario;
	}

	public void setClvUsuario(String clvUsuario) {
		this.clvUsuario = clvUsuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
