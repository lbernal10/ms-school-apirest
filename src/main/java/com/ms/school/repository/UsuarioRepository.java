package com.ms.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ms.school.modals.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
 
	@Query(value = "SELECT * FROM t_usuarios where usuario = :usuario ", nativeQuery = true)
	Usuario findByUsu(@Param("usuario") String usuario);
}
