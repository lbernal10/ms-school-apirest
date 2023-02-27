package com.ms.school.service;

import java.util.Map;
import com.ms.school.modals.entity.Calificacion;

public interface CalificacionService {
	
	public Map<String, Object> guardarCalificacion(Calificacion calificacion);
	
	public Map<String, Object> ObtenerCalificaciones(Long idUsuario);

	public Map<String, Object> actualizarCalificacion(Calificacion calificacion);
	
	public Map<String, Object> eliminarCalificacion(Long idCalificacion);

}
