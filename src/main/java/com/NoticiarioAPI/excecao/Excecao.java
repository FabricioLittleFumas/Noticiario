package com.NoticiarioAPI.excecao;

public class Excecao extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Excecao(String excecaoMessage) {
		super(excecaoMessage);
	}
	
	public Excecao() {
		super();
	}

	
}
