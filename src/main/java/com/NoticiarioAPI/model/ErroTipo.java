package com.NoticiarioAPI.model;

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
public class ErroTipo {
	
	private int status;
	private String error;
	private String message;
	private String path;
	
	

}
