package com.ms.school.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ms.school.modals.entity.Materia;

@Repository
public interface MateriaRepository extends CrudRepository<Materia, Long>{

}
