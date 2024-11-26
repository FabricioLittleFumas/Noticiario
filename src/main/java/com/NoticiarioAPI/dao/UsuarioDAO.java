package com.NoticiarioAPI.dao;

import java.io.Serializable;

import com.NoticiarioAPI.model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDAO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String email;
	private String idade;
	
	public UsuarioDAO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.idade = usuario.getIdade();
		this.email = usuario.getEmail();
	}
}