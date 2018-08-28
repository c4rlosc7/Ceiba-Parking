package co.com.ceiba.estacionamiento.unitary;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.estacionamiento.controllers.VehicleRegisterController;
import co.com.ceiba.estacionamiento.converter.ConvertMTE;
import co.com.ceiba.estacionamiento.entity.RegisterEntity;
import co.com.ceiba.estacionamiento.models.Register;
import co.com.ceiba.estacionamiento.repositories.IRegisterRepository;
import co.com.ceiba.estacionamiento.testdatabuilder.RegisterDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterTest {
	
	@Autowired
	VehicleRegisterController controller;

	private IRegisterRepository vehicleRepository;	
	
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
		
	}
	
	@Test
	public void testGetList() {		
		controller.getRegisterList();
		int resultadoEsperado = 26;
		int resultado = controller.getRegisterList().size();
		System.out.println(resultado);
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
		controller.saveRegister(ConvertMTE.convertModelToEntity(vehicle));
		assertNotNull(controller.saveRegister(ConvertMTE.convertModelToEntity(vehicle)));
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
		controller.saveRegister(ConvertMTE.convertModelToEntity(vehicleUpdate));
		
		vehicleUpdate.setCosto(10000);
		
		ConvertMTE.convertEntityToModel(controller.updateRegister(ConvertMTE.convertModelToEntity(vehicleUpdate), (long) 1));
		int resultadoEsperado = 10000;
		assertTrue(resultadoEsperado == vehicleUpdate.getCosto());
	}
	
	@Test
	public void testCalculateFee() {
		long id = 1;
		System.out.println(controller.calculateFee(id));
		Register vehicle = ConvertMTE.convertEntityToModel(controller.calculateFee(id));
		assertNotNull(vehicle.getCosto());
	}
	
	@Test 
	public void convertEntityToModelList() {
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
		List<RegisterEntity> listEntity = new ArrayList<>();
		listEntity = ConvertMTE.convertModelToEntityList(list);
		assertNotNull( ConvertMTE.convertEntityToModelList(listEntity) );
	}
	
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
		assertNotNull( ConvertMTE.convertModelToEntityList(list) );
	}
	
}

