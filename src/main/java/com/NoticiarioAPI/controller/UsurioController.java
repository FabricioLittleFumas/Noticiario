package com.NoticiarioAPI.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.NoticiarioAPI.dao.UsuarioDAO;
import com.NoticiarioAPI.model.Usuario;
import com.NoticiarioAPI.service.UsuarioService;
import com.NoticiarioAPI.util.JWTUtil;
import com.NoticiarioAPI.util.UserRequest;
import com.NoticiarioAPI.util.UserResponse;

@RequestMapping("/usuario")
@RestController
public class UsurioController {
	
	@Autowired
	private JWTUtil util;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
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
	//ok valida id que nao existe na base
	@GetMapping("/name")
	public ResponseEntity<UsuarioDAO> buscarPorEmail(@RequestParam(name = "email") String email){
		UsuarioDAO usuario =  service.findByEmail(email);
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
	
	@PostMapping("/loginUser")
	public ResponseEntity<UserResponse> login(@RequestBody UserRequest request){
		System.out.println("a");
		System.out.println("a");
		System.out.println(request.getEmail());
		System.out.println(request.getSenha());
		System.out.println("a");
		//Validate username/password with DB(required in case of Stateless Authentication)
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				request.getEmail(), request.getSenha()));
		String token = util.generateToken(request.getEmail());
	
		return ResponseEntity.ok(new UserResponse(token,"Token generated successfully!"));
	}
//	
//	@PostMapping("/getData")
//	public ResponseEntity<String> testAfterLogin(Principal p){
//		return ResponseEntity.ok("You are accessing data after a valid Login. You are :" +p.getName());
//	}


}
