package com.NoticiarioAPI.dao;

import com.NoticiarioAPI.model.Noticia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NoticiaDAO {
	
	private Long id;
	
	private String titulo;
	private String subtitulo;
	private String conteudo;
	private String data;
	
	public NoticiaDAO(Noticia noticia) {
		this.id = noticia.getId();
		this.titulo = noticia.getTitulo();
		this.subtitulo = noticia.getSubtitulo();
		this.conteudo = noticia.getConteudo();
		this.data = noticia.getData();
	}

}
