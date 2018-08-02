package parqueadero.dominio.unitaria;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

import parqueadero.dominio.BitacoraIngreso;
import parqueadero.testDataBuilder.BitacoraIngresoTestDataBuilder;


public class BitacoraIngresoTest {

	private static final Long ID = 1L;
	private static final Long IDVEHICULO = 2L;
	private static final Calendar FECHAINGRESO = Calendar.getInstance();
		
	@Test
	public void crearBitacoraIngresoTest() {

		// arrange

		BitacoraIngresoTestDataBuilder bitacoraIngresoTest = new BitacoraIngresoTestDataBuilder().conId(ID)
				.conIdVehiculo(IDVEHICULO).conFechaIngreso(FECHAINGRESO);
		// act
		BitacoraIngreso bitacoraIngresoPrueba = bitacoraIngresoTest.build();

		// assert		
		assertEquals(IDVEHICULO, bitacoraIngresoPrueba.getIdVehiculo());
		assertEquals(FECHAINGRESO, bitacoraIngresoPrueba.getFechaIngreso());

	}
	
}
