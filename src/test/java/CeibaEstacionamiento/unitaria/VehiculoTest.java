package CeibaEstacionamiento.unitaria;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import CeibaEstacionamiento.testDataBuilder.TipoVehiculoTestDataBuilder;
import CeibaEstacionamiento.testDataBuilder.VehiculoTestDataBuilder;
import dominio.TipoVehiculo;
import dominio.Vehiculo;

public class VehiculoTest {

	private static final String PLACA = "ABC123";
	private static final TipoVehiculo TIPOVEHICULO = new TipoVehiculoTestDataBuilder().build();
	private static final double CILINDRAJE = 1000;	
	
	@Test
	public void IngresoVehiculoNoAutorizado() {
		
		//arrange		
		
		VehiculoTestDataBuilder VehiculoTestDataBuilder =
				new VehiculoTestDataBuilder().conPlaca(PLACA).conTipoVehiculo(TIPOVEHICULO)
				.conCilindraje(CILINDRAJE);	
		// act
		Vehiculo motoAltoCilindraje = VehiculoTestDataBuilder.build();	
		
		//assert
		assertEquals(PLACA, motoAltoCilindraje.getPlaca());		
		assertEquals(TIPOVEHICULO, motoAltoCilindraje.getTipoVehiculo());
		assertEquals(CILINDRAJE, motoAltoCilindraje.getCilindraje(), 0.0);
		
	}		

}
