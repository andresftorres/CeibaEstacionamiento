package parqueadero.dominio.unitaria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import parqueadero.dominio.Vehiculo;
import parqueadero.entidad.TipoVehiculo;
import parqueadero.testDataBuilder.VehiculoTestDataBuilder;

public class VehiculoTest {
	
	private static final double DIFERENCIA =  0.0; 
	
	private static final String PLACA = "ABC12F";
	private static final TipoVehiculo TIPOVEHICULO = TipoVehiculo.MOTOCICLETA;
	private static final double CILINDRAJE = 1000;
	
	@Test
	public void crearMotocicletaTest() {

		// arrange

		VehiculoTestDataBuilder motociciletaDatBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA)
				.conTipoVehiculo(TIPOVEHICULO).conCilindraje(CILINDRAJE);
		// act
		Vehiculo vehiculoPrueba = motociciletaDatBuilder.build();

		// assert
		assertEquals(PLACA, vehiculoPrueba.getPlaca());		
		assertEquals(TIPOVEHICULO, vehiculoPrueba.getTipoVehiculo());
		assertEquals(CILINDRAJE, vehiculoPrueba.getCilindraje(), DIFERENCIA);

	}
}
