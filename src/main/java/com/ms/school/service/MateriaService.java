package com.ms.school.service;

import java.util.List;

import com.ms.school.modals.entity.Materia;

public interface MateriaService {
	public List<Materia> obtenerMaterias();
	
	public Boolean validarSiExiste(Long id);
}
