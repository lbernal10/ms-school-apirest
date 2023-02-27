package com.ms.school.modals.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "t_calificaciones")
public class Calificacion implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_t_calificaciones")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_t_materias", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Materia materia;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_t_usuarios", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario usuario;
	
	@Column(name = "calificacion")
	private Double calificacion;
	
	@Column(name = "fecha_registro")
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	
	public Calificacion() {
	}

	public Calificacion(Long id, Materia materia, Usuario usuario, Double calificacion, Date fechaRegistro) {
		this.id = id;
		this.materia = materia;
		this.usuario = usuario;
		this.calificacion = calificacion;
		this.fechaRegistro = fechaRegistro;
	}

	// getters y setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Double calificacion) {
		this.calificacion = calificacion;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	// Sobreescribir el método getFechaNacimiento() para devolver la fecha formateada
    public String getFechaRegistro() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(fechaRegistro);
    }
}
