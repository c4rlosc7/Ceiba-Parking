package co.com.ceiba.estacionamiento.unitary;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import co.com.ceiba.estacionamiento.controllers.VehicleRegisterController;
import co.com.ceiba.estacionamiento.domain.RulesParking;
import co.com.ceiba.estacionamiento.domain.Watchman;
import co.com.ceiba.estacionamiento.models.Register;
import co.com.ceiba.estacionamiento.repositories.IRegisterRepository;
import co.com.ceiba.estacionamiento.testdatabuilder.RegisterDataBuilder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WatchmanTest {
	
	@Autowired
	VehicleRegisterController controller;

	private IRegisterRepository vehicleRepository;
	private Watchman watch = new Watchman(vehicleRepository);
	
	public static final int CARRO = 1;
	public static final int MOTO = 2;
	
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
	public void testAuthorizedPlate() {
		String placa = "AAA";
		boolean resultado = RulesParking.authorizedPlate(placa);
		boolean resultadoEsperado = true;
		assertTrue( resultado == resultadoEsperado);
	}
	
	@Test
	public void testAuthorizedDay() {
		try {
			int dia = 3;
			RulesParking.authorizedDay(dia);
		} catch (Exception e) {
			assertEquals("No esta autorizado para ingresar", e.getMessage());
		}
	}
	
	@Test
	public void testTodayIs() {
		int resultadoEsperado = 4;
		int resultado = RulesParking.todayIs();
		assertTrue(resultado == resultadoEsperado);
	}
	
	@Test
	public void testGetDaysBetweenTwoDays() {
		LocalDateTime myTime1 = LocalDateTime.now();
		LocalDateTime myTime2 = LocalDateTime.now();
		myTime2 = myTime2.plusDays(1);
		long resultadoEsperado = 1;
		long resultado = RulesParking.getDaysBetweenTwoDays(myTime1, myTime2);		
		assertEquals(resultadoEsperado, resultado);
	}
	
	@Test
	public void testGetHoursBetweenTwoDays() {
		LocalDateTime myTime1 = LocalDateTime.now();
		LocalDateTime myTime2 = LocalDateTime.now();
		myTime2 = myTime2.plusDays(1);
		long resultadoEsperado = 24;
		long resultado = RulesParking.getHoursBetweenTwoDays(myTime1, myTime2);
		System.out.println(resultado);
		assertEquals(resultadoEsperado, resultado);
	}
	
	@Test
	public void testCalculoMotoHoras() {
		RegisterDataBuilder registerDataBuilder = new RegisterDataBuilder();
		short CIL = 800;
		LocalDateTime FECHA_IN = LocalDateTime.of(2018, 8, 29, 7, 0);
		LocalDateTime FECHA_OUT = LocalDateTime.of(2018, 8, 29, 10, 0);
		registerDataBuilder.setPlaca("ABC-01");
		registerDataBuilder.setCilindraje(CIL);				
		registerDataBuilder.setTipo(2);
		registerDataBuilder.setFechaEntrada(FECHA_IN);
		registerDataBuilder.setFechaSalida(FECHA_OUT);
		Register reg = registerDataBuilder.build();
		System.out.println("*******************************");
		System.out.println(reg.getPlaca());
		System.out.println(reg.getCilindraje());
		System.out.println(reg.getTipo());
		System.out.println(reg.getFechaIngreso());
		System.out.println(reg.getFechaSalida());
		watch.calculo(reg);
		System.out.println(reg.getCosto());
		int resultadoEsperado = 3500;
		assertEquals(resultadoEsperado, reg.getCosto());
	}
	
	@Test
	public void testCalculoMotoDias() {
		RegisterDataBuilder registerDataBuilder = new RegisterDataBuilder();
		short CIL = 800;
		LocalDateTime FECHA_IN = LocalDateTime.of(2018, 8, 29, 10, 0);
		LocalDateTime FECHA_OUT = LocalDateTime.of(2018, 8, 30, 10, 0);
		registerDataBuilder.setPlaca("ABC-01");
		registerDataBuilder.setCilindraje(CIL);				
		registerDataBuilder.setTipo(2);
		registerDataBuilder.setFechaEntrada(FECHA_IN);
		registerDataBuilder.setFechaSalida(FECHA_OUT);
		Register reg = registerDataBuilder.build();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(reg.getPlaca());
		System.out.println(reg.getCilindraje());
		System.out.println(reg.getTipo());
		System.out.println(reg.getFechaIngreso());
		System.out.println(reg.getFechaSalida());
		watch.calculo(reg);
		System.out.println(reg.getCosto());
		int resultadoEsperado = 4000;
		assertEquals(resultadoEsperado, reg.getCosto());
	}
	
	/*@Test
	public void testAvailableSpaceCarro(){
		try {
			watch.availableSpace(CARRO);
		} catch (Exception e) {
			assertEquals("No hay espacio para mas carros en el parqueadero", e.getMessage());
		}
	}*/
	
	/*@Test
	public void testAvailableSpaceMoto() {
		try {
			watch.availableSpace(MOTO);
		} catch (Exception e) {
			assertEquals("No hay mas espacio para mas motos en el parqueadero", e.getMessage());
		}
	}*/
	
}
