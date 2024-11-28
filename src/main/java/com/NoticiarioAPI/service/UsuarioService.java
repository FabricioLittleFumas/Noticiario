package com.NoticiarioAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NoticiarioAPI.dao.UsuarioDAO;
import com.NoticiarioAPI.excecao.Excecao;
import com.NoticiarioAPI.model.Usuario;
import com.NoticiarioAPI.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<UsuarioDAO> listAll() {
		List<UsuarioDAO> usuarios =  new ArrayList<UsuarioDAO>();
		usuarioRepository.findAll().forEach(u -> usuarios.add(new UsuarioDAO(u)));;
		return usuarios;
	}


	public UsuarioDAO findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return new UsuarioDAO(usuario.orElseThrow(() -> new Excecao("usuario nao encontrado")));
	}


	public UsuarioDAO inserir(Usuario usuario) {
		// TODO Auto-generated method stub
		UsuarioDAO usuario2 =  new UsuarioDAO(usuarioRepository.save(usuario));
		return usuario2;
	}


	public void delete(Long id) {
		usuarioRepository.deleteById(id);
		return;
		
	}

}
