package com.NoticiarioAPI.excecaoGeral;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.NoticiarioAPI.excecao.Excecao;
import com.NoticiarioAPI.model.ErroTipo;

@RestControllerAdvice
public class ErroGenerico {
	
	private ErroTipo erroTipo;
	
	@ExceptionHandler(Excecao.class)
	public ResponseEntity<ErroTipo> erroNaoEncontrado(Excecao ex){
		erroTipo = new ErroTipo();
		erroTipo.setMessage(ex.getMessage());
		erroTipo.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErroTipo>(erroTipo, HttpStatus.NOT_FOUND);
	}

}
