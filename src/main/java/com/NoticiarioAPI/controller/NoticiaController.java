package com.NoticiarioAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NoticiarioAPI.dao.NoticiaDAO;
import com.NoticiarioAPI.service.NoticiaService;

@RestController
@RequestMapping(value = "/noticia")
public class NoticiaController {
	
	@Autowired
	private NoticiaService noticiaService;
	
	@GetMapping("/")
	public ResponseEntity<List<NoticiaDAO>> listarTodo(){
		List<NoticiaDAO> noticias = noticiaService.buscarTodos();
		return new ResponseEntity<List<NoticiaDAO>>(noticias, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<NoticiaDAO> listarPorId(@PathVariable Long id){
		NoticiaDAO noticiaDAO =  noticiaService.buscarPorId(id);
		return new ResponseEntity<NoticiaDAO>(noticiaDAO, HttpStatus.OK);
	}

}
