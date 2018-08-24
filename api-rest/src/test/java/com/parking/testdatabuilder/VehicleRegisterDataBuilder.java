package com.parking.testdatabuilder;

import java.util.Date;

import com.parking.domain.VehicleRegister;

public class VehicleRegisterDataBuilder {
	
	private static final String PLACA = "XYZ-123";
	private static final String CILINDRAJE = "700";
	private static final int TIPO = 2;
	private static final Date FECHA_ENTRADA = new Date("2018-08-22 00:00:00.01");
	private static final Date FECHA_SALIDA = new Date("2018-08-22 00:00:00.01");
	private static final long COSTO = 8000;
	
	
	private String placa;
	private String cilindraje;
	private int tipo;
	private Date fechaEntrada;
	private Date fechaSalida;
	private long costo;
	
	public VehicleRegisterDataBuilder() {
		this.placa = PLACA;
		this.cilindraje = CILINDRAJE;
		this.tipo = TIPO;
		this.fechaEntrada = FECHA_ENTRADA;
		this.fechaSalida = FECHA_SALIDA;
		this.costo = COSTO;
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
	
	
	public VehicleRegister build() {
		return new VehicleRegister(this.placa, this.cilindraje, this.tipo, this.fechaEntrada, this.fechaSalida, this.costo);
	}

}
