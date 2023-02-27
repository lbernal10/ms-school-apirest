package com.ms.school.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.ms.school.modals.entity.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Long>{

}
