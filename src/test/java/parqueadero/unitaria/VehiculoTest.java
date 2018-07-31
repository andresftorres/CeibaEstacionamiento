package parqueadero.unitaria;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import parqueadero.testDataBuilder.ConfigTarifaTestDataBuilder;
import parqueadero.testDataBuilder.VehiculoTestDataBuilder;
import parqueadero.dominio.ConfigTarifas;
import parqueadero.dominio.Vehiculo;

public class VehiculoTest {

	private static final String PLACA = "ABC123";
	private static final ConfigTarifas TARIFA = new ConfigTarifaTestDataBuilder().build();
	private static final double CILINDRAJE = 1000;	
	
	@Test
	public void IngresoVehiculoNoAutorizado() {
		
		//arrange		
		
		VehiculoTestDataBuilder VehiculoTestDataBuilder =
				new VehiculoTestDataBuilder().conPlaca(PLACA).conConfigTarifa(TARIFA)
				.conCilindraje(CILINDRAJE);	
		// act
		Vehiculo motoAltoCilindraje = VehiculoTestDataBuilder.build();	
		
		//assert
		assertEquals(PLACA, motoAltoCilindraje.getPlaca());		
		assertEquals(TARIFA, motoAltoCilindraje.getConfigTarifa());
		assertEquals(CILINDRAJE, motoAltoCilindraje.getCilindraje(), 0.0);
		
	}		

}
