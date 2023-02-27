package com.ms.school.modals.dto;

import java.util.List;

public class CalificacionPromedioDTO {

	public List<CalificacionDTO> calificaciones;
	public Double promedio;
	
	public CalificacionPromedioDTO() {
	}
	
	public CalificacionPromedioDTO(List<CalificacionDTO> calificaciones, Double promedio) {
		this.calificaciones = calificaciones;
		this.promedio = promedio;
	}

	public List<CalificacionDTO> getCalificaciones() {
		return calificaciones;
	}
	public void setCalificaciones(List<CalificacionDTO> calificaciones) {
		this.calificaciones = calificaciones;
	}
	public Double getPromedio() {
		return promedio;
	}
	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}
	
	
}
