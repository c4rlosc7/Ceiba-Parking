package co.com.ceiba.estacionamiento.unitary;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.estacionamiento.controllers.VehicleRegisterController;
import co.com.ceiba.estacionamiento.converter.ConvertMTE;
import co.com.ceiba.estacionamiento.domain.RulesParking;
import co.com.ceiba.estacionamiento.domain.Watchman;
import co.com.ceiba.estacionamiento.exceptions.ParkingException;
import co.com.ceiba.estacionamiento.models.Register;
import co.com.ceiba.estacionamiento.repositories.IRegisterRepository;
import co.com.ceiba.estacionamiento.testdatabuilder.RegisterDataBuilder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WatchmanTest {
	
	@Autowired
	VehicleRegisterController controller;

	private IRegisterRepository vehicleRepository;
	private ConvertMTE converter;
	private Watchman watchman = new Watchman();
	private RulesParking rules;
	
	private static final String PLACA = "XYZ-123";
	private static final short CILINDRAJE = 600;
	private static final int TIPO = 2;
	private static final LocalDateTime FECHA_ENTRADA = LocalDateTime.now();
	private static final LocalDateTime FECHA_SALIDA = LocalDateTime.now();
	private static final long COSTO = 6000;

	@Before
	public void initTest() {
		vehicleRepository = mock(IRegisterRepository.class);		
	}
	
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
		assertEquals(CILINDRAJE, vehicle.getCilindraje());
		assertEquals(TIPO, vehicle.getTipo());
		assertEquals(COSTO, vehicle.getCosto());
	}
	
	@Test
	public void testCylinderGreaterThan500() {
		boolean respuestaEsperada = true;
		boolean respuesta = RulesParking.cylinderGreaterThan500(600);
		System.out.println(RulesParking.cylinderGreaterThan500(600));
		assertTrue(respuesta == respuestaEsperada);
		
	}
	
	@Test
	public void testauthorizedPlate() {
		String placa = "AAA";
		boolean resultado = RulesParking.authorizedPlate(placa);
		boolean resultadoEsperado = true;
		assertTrue( resultado == resultadoEsperado);
	}
	
	@Test(expected = ParkingException.class)
	public void testauthorizedDay() throws ParkingException {
		int dia = 3;
		RulesParking.authorizedDay(dia);
	}
	
	@Test
	public void testTodayIs() {
		int resultadoEsperado = 2;
		int resultado = RulesParking.todayIs();
		assertTrue(resultado == resultadoEsperado);
	}
	
}
