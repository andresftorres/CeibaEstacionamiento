package parqueadero.dominio.unitaria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import parqueadero.dominio.Motocicleta;
import parqueadero.entidad.TipoVehiculo;
import parqueadero.testDataBuilder.MotocicletaTestDataBuilder;

public class MotocicletaTest {
	
	private static final double DIFERENCIA =  0.0; 
	
	private static final String PLACA = "ABC12F";
	private static final String TIPOVEHICULO = TipoVehiculo.MOTOCICLETA.getCodigo();
	private static final double CILINDRAJE = 1000;
	
	@Test
	public void crearMotocicletaTest() {

		// arrange

		MotocicletaTestDataBuilder motociciletaDatBuilder = new MotocicletaTestDataBuilder().conPlaca(PLACA)
				.conTipoVehiculo(TIPOVEHICULO).conCilindraje(CILINDRAJE);
		// act
		Motocicleta motocicletaPrueba = motociciletaDatBuilder.build();

		// assert
		assertEquals(PLACA, motocicletaPrueba.getPlaca());		
		assertEquals(TIPOVEHICULO, motocicletaPrueba.getTipoVehiculo());
		assertEquals(CILINDRAJE, motocicletaPrueba.getCilindraje(), DIFERENCIA);

	}
}
