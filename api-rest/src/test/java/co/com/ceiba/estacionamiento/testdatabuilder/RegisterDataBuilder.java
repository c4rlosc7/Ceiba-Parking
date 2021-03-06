package co.com.ceiba.estacionamiento.testdatabuilder;

import java.time.LocalDateTime;
import java.util.Date;

import co.com.ceiba.estacionamiento.models.Register;

public class RegisterDataBuilder {
	
	private static final Long ID = (long) 1;
	private static final String PLACA = "XYZ-123";
	private static final short CILINDRAJE = 700;
	private static final int TIPO = 2;
	private static final LocalDateTime FECHA_ENTRADA = LocalDateTime.now();
	private static final LocalDateTime FECHA_SALIDA = LocalDateTime.now();
	private static final long COSTO = 8000;
	
	private Long id;
	private String placa;
	private short cilindraje;
	private int tipo;
	private LocalDateTime fechaEntrada;
	private LocalDateTime fechaSalida;
	private long costo;
	
	public RegisterDataBuilder() {
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

	public void setCilindraje(short cilindraje) {
		this.cilindraje = cilindraje;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void setFechaEntrada(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public void setCosto(long costo) {
		this.costo = costo;
	}
	
	
	public Register build() {
		return new Register(this.id, this.placa, this.cilindraje, this.tipo, this.fechaEntrada, this.fechaSalida, this.costo);
	}

}
