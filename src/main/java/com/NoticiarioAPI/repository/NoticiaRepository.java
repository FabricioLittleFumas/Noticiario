package com.NoticiarioAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.NoticiarioAPI.model.Noticia;

@Repository
public interface NoticiaRepository extends CrudRepository<Noticia, Long>{

	
	
}
