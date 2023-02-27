package com.ms.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ms.school.modals.dto.CalificacionDTO;
import com.ms.school.modals.entity.Calificacion;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion, Long>{

	@Query(value = "SELECT "
			+ "u.id_t_usuarios AS idUsuario, "
			+ "p.nombre AS nombre, "
			+ "p.ap_paterno AS apellido, "
			+ "m.nombre AS materia, "
			+ "c.id_t_calificaciones AS idCalificacion, "
			+ "c.calificacion AS calificacion, "
			+ "c.fecha_registro AS fechaRegistro"
			+ " FROM t_calificaciones  c "
			+ "INNER JOIN t_usuarios  u ON u.id_t_usuarios = c.id_t_usuarios "
			+ "INNER JOIN t_personas  p ON p.id_t_persona = u.id_t_usuarios "
			+ "INNER JOIN t_materias  m ON m.id_t_materias = c.id_t_materias  "
			+ "WHERE u.id_t_usuarios = ?1 ", nativeQuery = true )
    List<CalificacionDTO> findCalificaciones(Long idUsuario);
	
	@Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM t_calificaciones WHERE id_t_materias = ?1 AND id_t_usuarios = ?2", nativeQuery = true)
	boolean existsByIdTmateriasAndIdTusuarios(Long idTmaterias, Long idTusuarios);
}
