package parqueadero.servicios.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jca.cci.connection.TransactionAwareConnectionFactoryProxy;

import parqueadero.servicios.IngresoVehiculoServicio;
import parqueadero.testDataBuilder.TarifaParqTestDataBuilder;
import parqueadero.dominio.Vehiculo;
import parqueadero.entidad.TarifaParqueaderoEntity;
import parqueadero.repository.BitacoraIngresoRepository;
import parqueadero.repository.TarifaRepository;

public class ValidacionesIngreso {

	private static final int CANTIDAD_MAXIMA_MOTOS = 10;
/*
	@Test
	public void ingresaMotoParqueaderoLleno() {
		// arrange

		BitacoraIngresoRepository bitacoraIngreso = mock(BitacoraIngresoRepository.class);
		TarifaRepository tarifaMoto = mock( TarifaRepository.class);

		//String tarifaMoto = new TarifaParqTestDataBuilder().conCapacidadMaxima(CANTIDAD_MAXIMA_MOTOS).build();
		

		Vehiculo moto = new VehiculoTestDataBuilder().conConfigTarifa(tarifaMoto).build();

		// ConfigTarifaRepository.save( tarifaMoto );

		IngresoVehiculoServicio ingresoVehiculo = mock(IngresoVehiculoServicio.class);

		// when(bitacoraIngreso.cantidadVehiculosXTarifa(tarifaAplicada))

		// when(ingresoVehiculo.disponibilidadCupoIngreso(moto.getConfigTarifa())).thenReturn(true);

		// act
		boolean cupoDisponible = ingresoVehiculo.disponibilidadCupoIngreso(moto.getConfigTarifa());

		// assert

	}
	*/
}
