package com.ms.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.school.modals.entity.Materia;
import com.ms.school.service.MateriaService;

@RestController
@RequestMapping(value = "/materia")
public class MateriaController {

	@Autowired
	MateriaService materiaService;
	
	@GetMapping(value = "/")
	public List<Materia> obtenerMaterias() {
		return materiaService.obtenerMaterias();
	}
}
