package com.ms.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.school.modals.entity.Rol;
import com.ms.school.service.RolService;

@RestController
@RequestMapping(value = "/rol")
public class RolController {

	@Autowired
	RolService rolService;
	
	@GetMapping(value = "/")
	public List<Rol> obtenerRoles() {
		return rolService.obtenerRoles();
	}
}
