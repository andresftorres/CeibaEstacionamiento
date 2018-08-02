package parqueadero.dominio.unitaria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import parqueadero.testDataBuilder.AutomovilTestDataBuilder;
import parqueadero.dominio.Automovil;
import parqueadero.entidad.TipoVehiculo;

public class AutomovilTest {

	private static final String PLACA = "ABC12F";
	private static final String TIPOVEHICULO = TipoVehiculo.AUTOMOVIL.getCodigo();

	@Test
	public void crearVehiculoTest() {

		// arrange
		AutomovilTestDataBuilder automovilDatBuilder = new AutomovilTestDataBuilder().conPlaca(PLACA)
				.conTipoVehiculo(TIPOVEHICULO);
		// act
		Automovil automovilPrueba = automovilDatBuilder.build();

		// assert
		assertEquals(PLACA, automovilPrueba.getPlaca());		
		assertEquals(TIPOVEHICULO, automovilPrueba.getTipoVehiculo());

	}

}
