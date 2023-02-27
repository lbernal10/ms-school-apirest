package com.ms.school.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.school.modals.entity.Persona;
import com.ms.school.repository.PersonaRepository;
import com.ms.school.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService{

	@Autowired
	PersonaRepository personaRepository;

	@Override
	public List<Persona> obtenerPersonas() {
		return (List<Persona>) personaRepository.findAll();
	}
}
