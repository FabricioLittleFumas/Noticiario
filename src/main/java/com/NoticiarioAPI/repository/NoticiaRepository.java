package com.NoticiarioAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NoticiarioAPI.model.Noticia;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long>{

	
	
}
