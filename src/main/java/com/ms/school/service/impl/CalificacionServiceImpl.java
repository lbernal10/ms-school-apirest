package com.ms.school.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.school.modals.dto.CalificacionDTO;
import com.ms.school.modals.entity.Calificacion;
import com.ms.school.repository.CalificacionRepository;
import com.ms.school.service.CalificacionService;
import com.ms.school.service.MateriaService;

@Service
public class CalificacionServiceImpl implements CalificacionService{

	@Autowired
	CalificacionRepository calificacionRepository;
	
	@Autowired
	MateriaService materiaService;

	/**
	 * Generar una nueva calificacion para los alumnos
	 */
	@Override
	public Map<String, Object> guardarCalificacion(Calificacion calificacion) {
		Map<String, Object> response = new HashMap<>();
		
		// Validar que no exista un registro con materia y usuario previamente
		if (validarExistenciaMatYUsu(calificacion.getMateria().getId(), calificacion.getUsuario().getId())) {
			response.put("success", "error");
			response.put("msg", "Lo sentimos, no se pudo guardar el registro, ya que existe un previo registro con la materia y el alumno.");
			
			return response;
		}
		
		try {
			calificacion.setId(0L);
			calificacion.setFechaRegistro(new Date());
			
			calificacionRepository.save(calificacion);
			
			response.put("success", "ok");
			response.put("msg", "Calificacion registrada.");
		} catch (Exception e) {
			response.put("success", "error");
			response.put("msg", "Lo sentimos, no se pudo guardar el registro.");
		}
		return response;
	}


	/**
	 * Obtener las calificaciones con Promedio del Alumno
	 */
	@Override
	public Map<String, Object> ObtenerCalificaciones(Long idUsuario) {
		List<CalificacionDTO> calificaciones = new ArrayList<>();
		int sumaNotas = 0;
		Map<String, Object> response = new HashMap<>();
		DecimalFormat df = new DecimalFormat("0.0");
		
		// Obtener las calificaciones por usuario
		calificaciones =  calificacionRepository.findCalificaciones(idUsuario);
		
		// Ciclo para obtener el total de las notas
		for (CalificacionDTO calificacion : calificaciones) {
            sumaNotas += calificacion.getCalificacion();
        }
			
		// Obtener el promedio de las calificaciones
		String promedio = df.format((double) sumaNotas / calificaciones.size());
				
		// Response para salida de las calificaciones
		response.put("calificaciones", calificaciones);
		response.put("promedio", Double.parseDouble((String) promedio));
		
		return response;
	}


	/**
	 *  Actualizar la calificacion del Alumno
	 */
	@Override
	public Map<String, Object> actualizarCalificacion(Calificacion calificacion) {
		Map<String, Object> response = new HashMap<>();
		Calificacion cali = new Calificacion();
		
		//Validar que exista la calificacion
		if(!validarExistenciaCalificacion(calificacion.getId())) {
			response.put("success", "error");
			response.put("msg", "Lo sentimos, no se encontro el registro de la calificacion.");
			return response;
		}
		
		//Valida que no sea menor a cero la calificacion
		if(validarMenorQueCero(calificacion.getCalificacion())) {
			response.put("success", "error");
			response.put("msg", "Lo sentimos, la calificacion no puede ser menor a cero.");
			return response;
		}
		
		try {
			//Obtener el registro para actualizar la calificacion
			cali = obtenerCalificacionPorID(calificacion.getId());
			//Actualiza con la nueva calificacion
			cali.setCalificacion(calificacion.getCalificacion());			
			calificacionRepository.save(cali);
			// Regresa el mensajede OK
			response.put("success", "ok");
			response.put("msg", "Calificacion actualizada");
		} catch (Exception e) {
			response.put("success", "error");
			response.put("msg", "Lo sentimos, no se pudo actualizar el registro");
		}
		
		return response;
	}
	
	/**
	 * Obtener los datos de la calificacion por ID
	 * 
	 * @param idCalificacion
	 * @return Calificacion
	 */
	@SuppressWarnings("deprecation")
	private Calificacion obtenerCalificacionPorID(Long idCalificacion) {
		return calificacionRepository.getById(idCalificacion);
	}
	
	/**
	 * Validar que exista la calificacion
	 * 
	 * @param idCalificacion
	 * @return boolean
	 */
	private boolean validarExistenciaCalificacion(Long idCalificacion) {
		return calificacionRepository.existsById(idCalificacion);
	}
	
	/**
	 * Validar que no sea menor a cero la calificacion
	 * 
	 * @param num
	 * @return boolean
	 */
	private boolean validarMenorQueCero(Double num) {
	    return num < 0;
	}
	
	/**
	 * 
	 * Validacion para verificar que no exista una calificacion
	 * con un usuario(Alumno) y Materia previamente registrada.
	 * 
	 */
	private boolean validarExistenciaMatYUsu(Long idMateria, Long idUsuario) {
		return calificacionRepository.existsByIdTmateriasAndIdTusuarios(idMateria, idUsuario);
	}

	/**
	 * 
	 */
	@Override
	public Map<String, Object> eliminarCalificacion(Long idCalificacion) {
		Map<String, Object> response = new HashMap<>();
		Calificacion cali = new Calificacion();
		
		//Validar que exista la calificacion
		if(!validarExistenciaCalificacion(idCalificacion)) {
			response.put("success", "error");
			response.put("msg", "Lo sentimos, no se encontro el registro de la calificacion.");
			return response;
		}
		
		try {
			//Obtener el registro para actualizar la calificacion
			cali = obtenerCalificacionPorID(idCalificacion);
		
			calificacionRepository.delete(cali);
			// Regresa el mensajede OK
			response.put("success", "ok");
			response.put("msg", "Calificacion eliminada");
		} catch (Exception e) {
			response.put("success", "error");
			response.put("msg", "Lo sentimos, no se pudo eliminada el registro");
		}
		
		return response;
	}
}
