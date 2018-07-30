package CeibaEstacionamiento.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

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
	
	private static final String PLACA = "ABC123";
	private static final TipoVehiculo TIPOVEHICULO = new TipoVehiculoTestDataBuilder().build();
	private static final double CILINDRAJE = 1000;	
	
	
	public void crearTipoVehiculo() {
		// arrange
		TipoVehiculoTestDataBuilder TipoVehiculoDataBuilder = 
				new TipoVehiculoTestDataBuilder().conDescripcion(DESCRIPCION).conUsaCilindraje(USACILINDRAJE)
				.conCilindrajeMaximo(CILINDRAJEMAXIMO).conValorHora(VALORHORA).conValorDia(VALORDIA)
				.conAdicionalCilindraje(ADICIONALCILINDRAJE).conCapacidadMaxima(CAPACIDADMXIMA);	
		//OJO usar mock asqui
		VehiculoTestDataBuilder VehiculoTestDataBuilder =
				new VehiculoTestDataBuilder().conPlaca(PLACA).conTipoVehiculo(TIPOVEHICULO)
				.conCilindraje(CILINDRAJE);
		
		// act
		TipoVehiculo tipoMoto = TipoVehiculoDataBuilder.build();
		//OJO usar mock asqui
		VehiculoTestDataBuilder.conTipoVehiculo(tipoMoto);
		//OJO usar mock asqui
		Vehiculo motoAltoCilindraje = VehiculoTestDataBuilder.build();
		
		// assert
		assertEquals(DESCRIPCION, motoAltoCilindraje.getTipoVehiculo().getDescripcion());
		assertEquals(USACILINDRAJE, motoAltoCilindraje.getTipoVehiculo().getUsaCilindraje());
		assertSame(CILINDRAJEMAXIMO, motoAltoCilindraje.getTipoVehiculo().getCilindrajeMaximo());
		assertSame(VALORHORA, motoAltoCilindraje.getTipoVehiculo().getValorHora());
		assertSame(VALORDIA, motoAltoCilindraje.getTipoVehiculo().getValorDia());
		assertSame(ADICIONALCILINDRAJE, motoAltoCilindraje.getTipoVehiculo().getAdicionalCilindraje());
		assertEquals(CAPACIDADMXIMA, motoAltoCilindraje.getTipoVehiculo().getCapacidadMaxima());

		assertEquals(PLACA, motoAltoCilindraje.getPlaca());
		assertSame(TIPOVEHICULO, motoAltoCilindraje.getTipoVehiculo());
		assertSame(CILINDRAJE, motoAltoCilindraje.getCilindraje());
		
		
	}

}
