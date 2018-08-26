package com.parking.testdatabuilder;

import java.util.Date;

import com.parking.models.Register;

public class VehicleRegisterDataBuilder {
	
	private static final Long ID = (long) 1;
	private static final String PLACA = "XYZ-123";
	private static final String CILINDRAJE = "700";
	private static final int TIPO = 2;
	private static final Date FECHA_ENTRADA = new Date("2018-08-22 00:00:00.01");
	private static final Date FECHA_SALIDA = new Date("2018-08-22 00:00:00.01");
	private static final long COSTO = 8000;
	
	private Long id;
	private String placa;
	private String cilindraje;
	private int tipo;
	private Date fechaEntrada;
	private Date fechaSalida;
	private long costo;
	
	public VehicleRegisterDataBuilder() {
		this.id = ID;
		this.placa = PLACA;
		this.cilindraje = CILINDRAJE;
		this.tipo = TIPO;
		this.fechaEntrada = FECHA_ENTRADA;
		this.fechaSalida = FECHA_SALIDA;
		this.costo = COSTO;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public void setCosto(long costo) {
		this.costo = costo;
	}
	
	
	public Register build() {
		return new Register(this.id, this.placa, this.cilindraje, this.tipo, this.fechaEntrada, this.fechaSalida, this.costo);
	}

}
