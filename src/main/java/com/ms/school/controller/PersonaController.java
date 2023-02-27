package com.ms.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.school.modals.entity.Persona;
import com.ms.school.service.PersonaService;

@RestController
@RequestMapping(value = "/persona")
public class PersonaController {

	@Autowired
	PersonaService personaService;
	
	@GetMapping(value = "/")
	public List<Persona> obtenerPersonas() {
		return personaService.obtenerPersonas();
	}
}
