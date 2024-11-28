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

import com.NoticiarioAPI.dao.UsuarioDAO;
import com.NoticiarioAPI.model.Usuario;
import com.NoticiarioAPI.service.UsuarioService;

@RequestMapping("/usuario")
@RestController
public class UsurioController {
	
	@Autowired
	private UsuarioService service;
	//ok
	@GetMapping(value = "/")
	public ResponseEntity<List<UsuarioDAO>> listarTodos(){
		List<UsuarioDAO> usuarios =  service.listAll();
		return new ResponseEntity<List<UsuarioDAO>>(usuarios, HttpStatus.OK);
	}
	//ok valida id que nao existe na base
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDAO> buscarPorId(@PathVariable(name = "id") Long id){
		UsuarioDAO usuario =  service.findById(id);
		return new ResponseEntity<UsuarioDAO>(usuario, HttpStatus.OK);
		
	}
	//ok falta verificar campos
	@PostMapping("/")
	public ResponseEntity<UsuarioDAO> inserir(@RequestBody Usuario usuario){
		UsuarioDAO usuario2 = service.inserir(usuario);
		return new ResponseEntity<UsuarioDAO>(usuario2, HttpStatus.OK);
	}
	//ok
	@DeleteMapping("/{id}")
	public ResponseEntity<UsuarioDAO> delete(@PathVariable(name = "id") Long id){
		service.delete(id);
		return new ResponseEntity<UsuarioDAO>(HttpStatus.NO_CONTENT);
	}

}
