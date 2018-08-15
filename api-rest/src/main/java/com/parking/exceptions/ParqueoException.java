package com.parking.exceptions;

public class ParqueoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ParqueoException(String mensajeUsuario) {
		super(mensajeUsuario);
	}
}
