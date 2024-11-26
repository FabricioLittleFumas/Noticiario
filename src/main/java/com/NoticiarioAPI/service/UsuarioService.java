package com.NoticiarioAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NoticiarioAPI.model.Usuario;
import com.NoticiarioAPI.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> listAll() {
		List<Usuario> usuarios =  usuarioRepository.findAll();
		return usuarios;
	}


	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.get();
	}


	public Usuario inserir(Usuario usuario) {
		// TODO Auto-generated method stub
		Usuario usuario2 =  usuarioRepository.save(usuario);
		return usuario2;
	}


	public void delete(Long id) {
		usuarioRepository.deleteById(id);
		return;
		
	}

}
