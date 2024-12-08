package com.NoticiarioAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
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

	public void deletePorId(Long id) {
		// TODO Auto-generated method stub
		buscarPorId(id);
		noticiaRepository.deleteById(id);
		return;
	}

	public NoticiaDAO inserirNoticia(Noticia noticia) {
		// TODO Auto-generated method stub
		Noticia noticiaInsert = noticiaRepository.save(noticia);
		return new NoticiaDAO(noticiaInsert);
	}

	public Page<Noticia> getNoticiaspaginadas(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo, pageSize);
        return noticiaRepository.findAll(pageable);
	}

	public Page<Noticia> getNoticiaspaginadas(int pageNo, int pageSize, Direction direction, String id) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo, pageSize,direction, id);
        return noticiaRepository.findAll(pageable);
	}
	

}
