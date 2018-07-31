package parqueadero.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import parqueadero.dominio.ConfigTarifas;
import parqueadero.servicios.IngresoVehiculoServicio;
import parqueadero.testDataBuilder.ConfigTarifaTestDataBuilder;
import parqueadero.testDataBuilder.VehiculoTestDataBuilder;
import parqueadero.dominio.Vehiculo;
import parqueadero.repository.BitacoraIngresoRepository;
public class ValidacionesIngreso {

	private static final int CANTIDAD_MAXIMA_MOTOS = 10;
	
	@Test
	public void ingresaMotoParqueaderoLleno() {
		// arrange	
		
		BitacoraIngresoRepository bitacoraIngreso = mock(BitacoraIngresoRepository.class);
		
		
		ConfigTarifas tarifaMoto = new ConfigTarifaTestDataBuilder()
				.conCapacidadMaxima(CANTIDAD_MAXIMA_MOTOS)
				.build();	
		
		Vehiculo moto = new VehiculoTestDataBuilder()
				.conConfigTarifa(tarifaMoto )
				.build();
		
		//ConfigTarifaRepository.save( tarifaMoto );
		
		IngresoVehiculoServicio ingresoVehiculo	= mock(IngresoVehiculoServicio.class);
		
		//when(bitacoraIngreso.cantidadVehiculosXTarifa(tarifaAplicada))
		
		//when(ingresoVehiculo.disponibilidadCupoIngreso(moto.getConfigTarifa())).thenReturn(true);
		
		// act			
		boolean cupoDisponible = ingresoVehiculo.disponibilidadCupoIngreso(moto.getConfigTarifa());
		
		//assert
		
				
		
	}
}
