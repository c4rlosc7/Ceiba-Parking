package co.com.ceiba.estacionamiento.unitary;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	@Test
	public void testGetList() {		
		controller.getRegisterList();
		int resultadoEsperado = 23;
		System.out.println("GETTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
		System.out.println(controller.getRegisterList().size());
		int resultado = controller.getRegisterList().size();
		assertEquals(resultadoEsperado, resultado);
	}
	
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
	
	@Test
	public void testUpdateRegister() {
		long id = 1;
		
		RegisterDataBuilder registerDataBuilder = new RegisterDataBuilder();
		
		registerDataBuilder.setPlaca(PLACA);
		registerDataBuilder.setCilindraje(CILINDRAJE);
		registerDataBuilder.setTipo(TIPO);
		registerDataBuilder.setFechaEntrada(FECHA_ENTRADA);
		registerDataBuilder.setFechaSalida(FECHA_SALIDA);
		registerDataBuilder.setCosto(COSTO);
		
		Register vehicleUpdate = registerDataBuilder.build();	
		controller.saveRegister(converter.convertModelToEntity(vehicleUpdate));
		
		vehicleUpdate.setCosto(10000);
		
		ConvertMTE.convertEntityToModel(controller.updateRegister(converter.convertModelToEntity(vehicleUpdate), (long) 1));
		int resultadoEsperado = 10000;
		System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
		System.out.println(vehicleUpdate.getCosto());
		assertTrue(resultadoEsperado == vehicleUpdate.getCosto());
	}
	
	@Test
	public void testCalculateFee() {
		long id = 1;
		System.out.println(controller.calculateFee(id));
		Register vehicle = ConvertMTE.convertEntityToModel(controller.calculateFee(id));
		System.out.println("---------------------------------------------------------");
		System.out.println(vehicle);
		assertNotNull(vehicle.getCosto());
	}
	
	/*@Test
	public void testConvertEntityToModelList() {
		
	}*/
	
	@Test 
	public void testConvertModelToEntityList() {
		RegisterDataBuilder registerDataBuilder = new RegisterDataBuilder();
		
		registerDataBuilder.setPlaca(PLACA);
		registerDataBuilder.setCilindraje(CILINDRAJE);
		registerDataBuilder.setTipo(TIPO);
		registerDataBuilder.setFechaEntrada(FECHA_ENTRADA);
		registerDataBuilder.setFechaSalida(FECHA_SALIDA);
		registerDataBuilder.setCosto(COSTO);
		
		Register vehicle = registerDataBuilder.build();
		
		List<Register> list = new ArrayList<>();
		list.add(vehicle);
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAA");
		for(Register r: list) {
			System.out.println( r.getCilindraje() );
		}
		assertNull( ConvertMTE.convertModelToEntityList(list) );
	}
	
}

