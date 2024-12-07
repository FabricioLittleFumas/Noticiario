package com.NoticiarioAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.NoticiarioAPI.model.Usuario;

import jakarta.transaction.Transactional;


@Transactional
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query(name = "buscar_email", value = "select u from Usuario u where u.email = :username")
	Usuario findUsuarioByEmails(String username);

}
