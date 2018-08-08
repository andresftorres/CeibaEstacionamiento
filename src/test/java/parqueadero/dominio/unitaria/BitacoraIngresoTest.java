package parqueadero.dominio.unitaria;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

import parqueadero.dominio.BitacoraIngreso;
import parqueadero.dominio.Vehiculo;
import parqueadero.testDataBuilder.BitacoraIngresoTestDataBuilder;
import parqueadero.testDataBuilder.VehiculoTestDataBuilder;


public class BitacoraIngresoTest {

	private static final Long ID = 1L;
	private static final Vehiculo VEHICULO_TEST = new VehiculoTestDataBuilder().build();
	private static final Calendar FECHAINGRESO = Calendar.getInstance();
		
	@Test
	public void crearBitacoraIngresoTest() {

		// arrange

		BitacoraIngresoTestDataBuilder bitacoraIngresoTest = new BitacoraIngresoTestDataBuilder().conId(ID)
				.conVehiculo(VEHICULO_TEST).conFechaIngreso(FECHAINGRESO);
		// act
		BitacoraIngreso bitacoraIngresoPrueba = bitacoraIngresoTest.build();

		// assert		
		assertEquals(VEHICULO_TEST, bitacoraIngresoPrueba.getVehiculo());
		assertEquals(FECHAINGRESO, bitacoraIngresoPrueba.getFechaIngreso());

	}
	
}
