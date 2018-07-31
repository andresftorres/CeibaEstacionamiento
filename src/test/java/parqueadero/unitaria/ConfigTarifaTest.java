package parqueadero.unitaria;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import parqueadero.testDataBuilder.ConfigTarifaTestDataBuilder;
import parqueadero.dominio.ConfigTarifas;
import parqueadero.dominio.Vehiculo;

public class ConfigTarifaTest {

	private static final String DESCRIPCION = "MOTO";
	private static final boolean USACILINDRAJE = true;	
	private static final double CILINDRAJEMAXIMO = 500;
	private static final double VALORHORA = 500;
	private static final double VALORDIA = 4000;
	private static final double ADICIONALCILINDRAJE = 2000;
	private static final int CAPACIDADMXIMA = 10;
	
	
	
	@Test
	public void crearConfigTarifa() {
		// arrange
		
		ConfigTarifaTestDataBuilder TipoVehiculoDataBuilder = 
				new ConfigTarifaTestDataBuilder().conDescripcion(DESCRIPCION).conUsaCilindraje(USACILINDRAJE)
				.conCilindrajeMaximo(CILINDRAJEMAXIMO).conValorHora(VALORHORA).conValorDia(VALORDIA)
				.conAdicionalCilindraje(ADICIONALCILINDRAJE).conCapacidadMaxima(CAPACIDADMXIMA);			
		
		// act
		ConfigTarifas TarifaParaMoto = TipoVehiculoDataBuilder.build();	
		
		// assert
		
		assertEquals(DESCRIPCION, TarifaParaMoto.getDescripcion());
		assertEquals(USACILINDRAJE, TarifaParaMoto.getUsaCilindraje());
		assertEquals(CILINDRAJEMAXIMO, TarifaParaMoto.getCilindrajeMaximo(), 0.0);
		assertEquals(VALORHORA, TarifaParaMoto.getValorHora(), 0.0);
		assertEquals(VALORDIA, TarifaParaMoto.getValorDia(), 0.0);
		assertEquals(ADICIONALCILINDRAJE, TarifaParaMoto.getAdicionalCilindraje(), 0.0);
		assertEquals(CAPACIDADMXIMA, TarifaParaMoto.getCapacidadMaxima());
		
		
	}

}
