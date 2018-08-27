package co.com.ceiba.estacionamiento.unitary;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import co.com.ceiba.estacionamiento.models.Register;
import co.com.ceiba.estacionamiento.testdatabuilder.RegisterDataBuilder;

public class RegisterTest {
	
	private static final String PLACA = "XYZ-123";
	private static final short CILINDRAJE = 600;
	private static final int TIPO = 2;
	private static final Date FECHA_ENTRADA = new Date();
	private static final Date FECHA_SALIDA = new Date();
	private static final long COSTO = 6000;

	@Test
	public void testCreateRegister() {
		
		RegisterDataBuilder vehicleDataBuilder = new RegisterDataBuilder();
		vehicleDataBuilder.setPlaca(PLACA);
		vehicleDataBuilder.setCilindraje(CILINDRAJE);
		vehicleDataBuilder.setTipo(TIPO);
		vehicleDataBuilder.setFechaEntrada(FECHA_ENTRADA);
		vehicleDataBuilder.setFechaSalida(FECHA_SALIDA);
		vehicleDataBuilder.setCosto(COSTO);
		
		Register vehicle = vehicleDataBuilder.build();
		
		assertEquals(PLACA, vehicle.getPlaca());
		
	}
	
	@Test
	public void test() {
		assertTrue(true);
	}

	
}

