package com.ms.school.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.school.modals.entity.Rol;
import com.ms.school.repository.RolRepository;
import com.ms.school.service.RolService;

@Service
public class RolServiceImpl implements RolService{

	@Autowired
	RolRepository rolRepository;

	@Override
	public List<Rol> obtenerRoles() {
		// TODO Auto-generated method stub
		return (List<Rol>) rolRepository.findAll();
	}
}
