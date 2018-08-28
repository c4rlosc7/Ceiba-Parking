package co.com.ceiba.estacionamiento.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculos")
public class RegisterEntity implements Serializable {
	
	public RegisterEntity() {
		
	}
	
	public RegisterEntity(long id, 
						  String placa, 
						  int cilindraje, 
						  int tipo, 
						  LocalDateTime fechaIngreso, 
						  LocalDateTime fechaSalida, 
						  long costo) {
		this.id = id;
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.tipo = tipo;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.costo = costo;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String placa;
	private int cilindraje;
	private int tipo;

	@Column(name = "fecha_ingreso")
	private LocalDateTime fechaIngreso;

	@Column(name = "fecha_salida", nullable = true)
	private LocalDateTime fechaSalida;

	//@Column(nullable = true)
	private long costo;

	@PrePersist
	private void onCreate() {
		fechaIngreso = LocalDateTime.now();
	}

	/* Getters and Setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public long getCosto() {
		return costo;
	}

	public void setCosto(long costo) {
		this.costo = costo;
	}

}
