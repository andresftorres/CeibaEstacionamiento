package parqueadero.dominio.unitaria;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import parqueadero.testDataBuilder.TarifaParqTestDataBuilder;
import parqueadero.dominio.TarifaParqueadero;
import parqueadero.entidad.TipoVehiculo;

public class TarifaParqueaderoTest {

	private static final double DIFERENCIA = 0;
	
	private static final String TIPOVEHICULO = TipoVehiculo.MOTOCICLETA.getCodigo();	
	private static final double VALORHORA = 500;
	private static final double VALORDIA = 4000;
	private static final int CAPACIDADMXIMA = 10;
	private static final boolean USACILINDRAJE = true;
	private static final double CILINDRAJEMAXIMO = 500;
	private static final double COBROEXTRAPORCILINDRAJE = 2000;
	

	
	@Test
	public void crearTarifaParqueaderoTest() {
		// arrange

		TarifaParqTestDataBuilder tarifaParqueaderoBuilder = new TarifaParqTestDataBuilder()
				.conTipoVehiculo(TIPOVEHICULO).conValorDia(VALORDIA).conValorHora(VALORHORA)
				.conCapacidadMaxima(CAPACIDADMXIMA).conUsaCilindraje(USACILINDRAJE)
				.conCilindrajeMaximo(CILINDRAJEMAXIMO).conCobroExtraCilindraje(COBROEXTRAPORCILINDRAJE);

		// act
		TarifaParqueadero tarifaMotocicletaPrueba = tarifaParqueaderoBuilder.build();

		// assert
		
		assertEquals(TIPOVEHICULO, tarifaMotocicletaPrueba.getTipoVehiculo());
		assertEquals(VALORHORA, tarifaMotocicletaPrueba.getValorHora(), DIFERENCIA);
		assertEquals(VALORDIA, tarifaMotocicletaPrueba.getValorDia(), DIFERENCIA);
		assertEquals(CAPACIDADMXIMA, tarifaMotocicletaPrueba.getCapacidadMaxima());
		assertEquals(USACILINDRAJE, tarifaMotocicletaPrueba.getTieneCilindraje());
		assertEquals(CILINDRAJEMAXIMO, tarifaMotocicletaPrueba.getCilindrajeMaximo(), DIFERENCIA);
		assertEquals(COBROEXTRAPORCILINDRAJE, tarifaMotocicletaPrueba.getCobroExtraCilindraje(), DIFERENCIA);
		

	}
	

}
