package com.NoticiarioAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.NoticiarioAPI.dao.UsuarioDAO;
import com.NoticiarioAPI.excecao.Excecao;
import com.NoticiarioAPI.model.Usuario;
import com.NoticiarioAPI.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findUsuarioByEmails(username);
		System.out.println("oks");
		System.out.println(username);
		System.out.println(usuario);
		User user = new User(usuario.getEmail(), usuario.getSenha(), 
				usuario.getRoles().stream().map(
						us -> new SimpleGrantedAuthority(us.getNomeRole())).collect(Collectors.toList()));		
		return user;
	}
	
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

	public UsuarioDAO findByEmail(String email) {
		Optional<Usuario> usuario = Optional.of(usuarioRepository.findUsuarioByEmails(email));
		return new UsuarioDAO(usuario.orElseThrow(() -> new Excecao("usuario nao encontrado")));
	}

	public Page<Usuario> getNoticiaspaginadas(int pageNo, int pageSize, Direction direction, String id) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo, pageSize,direction, id);
        return usuarioRepository.findAll(pageable);
	}
	
	

}
