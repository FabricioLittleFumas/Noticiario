package com.NoticiarioAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.NoticiarioAPI.dao.NoticiaDAO;
import com.NoticiarioAPI.model.Noticia;
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
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePorID(@PathVariable Long id){
		noticiaService.deletePorId(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> inserir(@RequestBody Noticia noticia){
		NoticiaDAO noticiaDAO = noticiaService.inserirNoticia(noticia);
		return new ResponseEntity<NoticiaDAO>(noticiaDAO, HttpStatus.CREATED);
	}
	
	 @GetMapping
	    public ResponseEntity<Page<Noticia>> paginacaoNoticias(
	            @RequestParam(defaultValue = "0") int pageNo,
	            @RequestParam(defaultValue = "10") int pageSize,
	            @RequestParam (defaultValue = "ASC") Direction direction,
	            @RequestParam (defaultValue = "id") String id) {
	        
	        Page<Noticia> products = noticiaService.getNoticiaspaginadas(pageNo, pageSize,direction, id);
	        return ResponseEntity.ok(products);
	    }

}
