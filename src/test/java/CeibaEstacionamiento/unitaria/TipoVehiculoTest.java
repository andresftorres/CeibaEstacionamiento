package CeibaEstacionamiento.unitaria;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import CeibaEstacionamiento.testDataBuilder.TipoVehiculoTestDataBuilder;
import CeibaEstacionamiento.testDataBuilder.VehiculoTestDataBuilder;
import dominio.TipoVehiculo;
import dominio.Vehiculo;

public class TipoVehiculoTest {

	private static final String DESCRIPCION = "MOTO";
	private static final boolean USACILINDRAJE = true;	
	private static final double CILINDRAJEMAXIMO = 500;
	private static final double VALORHORA = 500;
	private static final double VALORDIA = 4000;
	private static final double ADICIONALCILINDRAJE = 2000;
	private static final int CAPACIDADMXIMA = 10;
	
	
	
	@Test
	public void crearTipoVehiculo() {
		// arrange
		
		TipoVehiculoTestDataBuilder TipoVehiculoDataBuilder = 
				new TipoVehiculoTestDataBuilder().conDescripcion(DESCRIPCION).conUsaCilindraje(USACILINDRAJE)
				.conCilindrajeMaximo(CILINDRAJEMAXIMO).conValorHora(VALORHORA).conValorDia(VALORDIA)
				.conAdicionalCilindraje(ADICIONALCILINDRAJE).conCapacidadMaxima(CAPACIDADMXIMA);			
		
		// act
		TipoVehiculo tipoMoto = TipoVehiculoDataBuilder.build();	
		
		// assert
		
		assertEquals(DESCRIPCION, tipoMoto.getDescripcion());
		assertEquals(USACILINDRAJE, tipoMoto.getUsaCilindraje());
		assertEquals(CILINDRAJEMAXIMO, tipoMoto.getCilindrajeMaximo(), 0.0);
		assertEquals(VALORHORA, tipoMoto.getValorHora(), 0.0);
		assertEquals(VALORDIA, tipoMoto.getValorDia(), 0.0);
		assertEquals(ADICIONALCILINDRAJE, tipoMoto.getAdicionalCilindraje(), 0.0);
		assertEquals(CAPACIDADMXIMA, tipoMoto.getCapacidadMaxima());
		
		
	}

}
