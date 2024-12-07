package com.NoticiarioAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NoticiarioAPI.dao.NoticiaDAO;
import com.NoticiarioAPI.excecao.Excecao;
import com.NoticiarioAPI.model.Noticia;
import com.NoticiarioAPI.repository.NoticiaRepository;

@Service
public class NoticiaService {
	
	@Autowired
	private NoticiaRepository noticiaRepository;

	public List<NoticiaDAO> buscarTodos() {
		List<NoticiaDAO> noticiaDAOs = new ArrayList<>();
		noticiaRepository.findAll().forEach(ntc -> noticiaDAOs.add(new NoticiaDAO(ntc)));;
		return noticiaDAOs;
	}

	public NoticiaDAO buscarPorId(Long id) {
		Optional<Noticia> noticia = noticiaRepository.findById(id);
		if (noticia.isPresent()) {
			return new NoticiaDAO(noticia.get());
		}
		throw new Excecao("Noticia não encontrada");
	}
	

}
