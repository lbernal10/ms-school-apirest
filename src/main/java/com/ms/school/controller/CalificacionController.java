package com.ms.school.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.school.modals.entity.Calificacion;
import com.ms.school.service.CalificacionService;

@RestController
@RequestMapping(value = "/calificacion")
public class CalificacionController {

	@Autowired
	CalificacionService calificacionService;
	
	/**
	 * Generar una nueva calificacion para los alumnos
	 * 
	 * @param calificacion
	 * @return Map<String, Object>
	 */
	@PostMapping("/")
	public Map<String, Object> guardarCalificacion(@RequestBody Calificacion calificacion) {
		return calificacionService.guardarCalificacion(calificacion);
	}
	
	/**
	 * Obtener las calificaciones con Promedio del Alumno
	 * 
	 * @return Map<String, Object>
	 */
	@GetMapping(value = "/{idUsuario}")
	public Map<String, Object> ObtenerCalificaciones(@PathVariable Long idUsuario) {
		return calificacionService.ObtenerCalificaciones(idUsuario);
	}
	
	/**
	 * Actualizar la calificacion del Alumno
	 * 
	 * @param calificacion
	 * @return Map<String, Object>
	 */
	@PutMapping("/")
	public Map<String, Object> actualizarCalificacion(@RequestBody Calificacion calificacion) {
		return calificacionService.actualizarCalificacion(calificacion);
	}
	
	/**
	 * Eliminar una calificacion
	 * 
	 * @param idCalificacion
	 * @return Map<String, Object>
	 */
	@DeleteMapping("/{idCalificacion}")
	public Map<String, Object> eliminarCalificacion(@PathVariable Long idCalificacion) {
		return calificacionService.eliminarCalificacion(idCalificacion);
	}
}
