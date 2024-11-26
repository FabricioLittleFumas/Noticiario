package com.NoticiarioAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NoticiarioAPI.model.Usuario;
import com.NoticiarioAPI.service.UsuarioService;

@RequestMapping("/usuario")
@RestController
public class UsurioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping(value = "/")
	public ResponseEntity<List<Usuario>> listarTodos(){
		List<Usuario> usuarios =  service.listAll();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable(name = "id") Long id){
		Usuario usuario =  service.findById(id);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		
	}
	
	@PostMapping("/")
	public ResponseEntity<?> inserir(@RequestBody Usuario usuario){
		Usuario usuario2 = service.inserir(usuario);
		return new ResponseEntity<Usuario>(usuario2, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
		service.delete(id);
		return new ResponseEntity<Usuario>(HttpStatus.ACCEPTED);
	}

}
