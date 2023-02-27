package com.ms.school.modals.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"idUsuario", "nombre", "apellido", "materia", "idCalificacion", "calificacion", "fechaRegistro"})
public interface CalificacionDTO {
	
	Long getIdUsuario();
	
    String getNombre();
    
    String getApellido();
    
    String getMateria();
    
    Long getIdCalificacion();
    
    Double getCalificacion();
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    Date getFechaRegistro();
}
