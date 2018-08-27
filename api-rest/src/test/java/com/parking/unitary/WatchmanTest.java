package com.parking.unitary;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.parking.controllers.VehicleRegisterController;
import com.parking.repositories.IRegisterRepository;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WatchmanTest {
	
	@Autowired
	VehicleRegisterController controller;

	private IRegisterRepository vehicleRepository;

	@Before
	public void initTest() {
		vehicleRepository = mock(IRegisterRepository.class);		
	}
	
	@Test
	public void testGetList() {		
		controller.getRegisterList();
		//System.out.println(controller.getRegisterList().size());
		int resultadoEsperado = 23;
		int resultado = controller.getRegisterList().size();
		assertEquals(resultadoEsperado, resultado);
	}

	@Test
	public void test() {
		assertTrue(true);
	}

}
