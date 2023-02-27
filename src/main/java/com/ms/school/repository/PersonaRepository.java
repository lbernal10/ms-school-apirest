package com.ms.school.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ms.school.modals.entity.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long>{

}
