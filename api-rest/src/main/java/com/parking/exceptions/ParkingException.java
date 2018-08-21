package com.parking.exceptions;

public class ParkingException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ParkingException(String mensajeUsuario) {
		super(mensajeUsuario);
	}
}
