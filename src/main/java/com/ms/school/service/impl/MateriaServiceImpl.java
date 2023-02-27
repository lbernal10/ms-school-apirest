package com.ms.school.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.school.modals.entity.Materia;
import com.ms.school.repository.MateriaRepository;
import com.ms.school.service.MateriaService;

@Service
public class MateriaServiceImpl implements MateriaService{

	@Autowired
	MateriaRepository materiaRepository;

	@Override
	public List<Materia> obtenerMaterias() {
		return (List<Materia>) materiaRepository.findAll();
	}

	@Override
	public Boolean validarSiExiste(Long id) {
		return materiaRepository.existsById(id);
	}
}
