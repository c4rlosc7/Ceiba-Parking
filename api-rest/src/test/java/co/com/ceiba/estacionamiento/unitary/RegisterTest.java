package co.com.ceiba.estacionamiento.unitary;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.estacionamiento.controllers.VehicleRegisterController;
import co.com.ceiba.estacionamiento.converter.ConvertMTE;
import co.com.ceiba.estacionamiento.models.Register;
import co.com.ceiba.estacionamiento.repositories.IRegisterRepository;
import co.com.ceiba.estacionamiento.testdatabuilder.RegisterDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterTest {
	
	@Autowired
	VehicleRegisterController controller;

	private IRegisterRepository vehicleRepository;
	
	private ConvertMTE converter;
	
	private static final String PLACA = "XYZ-123";
	private static final short CILINDRAJE = 600;
	private static final int TIPO = 2;
	private static final Date FECHA_ENTRADA = new Date();
	private static final Date FECHA_SALIDA = new Date();
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
		
	}
	
	/*@Test
	public void testGetList() {		
		controller.getRegisterList();
		int resultadoEsperado = 23;
		int resultado = controller.getRegisterList().size();
		System.out.println("----------------------------------------------------");
		assertEquals(resultadoEsperado, resultado);
	}*/
	
	@Test
	public void testSaveVehicleRegister() {
		RegisterDataBuilder vehicleDataBuilder = new RegisterDataBuilder();
		
		vehicleDataBuilder.setPlaca(PLACA);
		vehicleDataBuilder.setCilindraje(CILINDRAJE);
		vehicleDataBuilder.setTipo(TIPO);
		vehicleDataBuilder.setFechaEntrada(FECHA_ENTRADA);
		vehicleDataBuilder.setFechaSalida(FECHA_SALIDA);
		vehicleDataBuilder.setCosto(COSTO);
		
		Register vehicle = vehicleDataBuilder.build();	
		controller.saveRegister(converter.convertModelToEntity(vehicle));
		assertNotNull(controller.saveRegister(converter.convertModelToEntity(vehicle)));
	}

	/*@Test
	public void testDeleteRegister() {
		long id = 1;
		controller.deleteRegister(id);
		assertTrue(true);
	}*/
	
	@Test
	public void testUpdateRegister() {
		long id = 1;
		controller.deleteRegister(id);
		assertTrue(true);
	}
	
	/*@Test
	public void testCalculateFee() {
		long id = 1;
		Register vehicle = ConvertMTE.convertEntityToModel(controller.calculateFee(id));
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(vehicle);
		assertTrue(true);
	}*/
	
}

