package parqueadero.servicios.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.jca.cci.connection.TransactionAwareConnectionFactoryProxy;

import parqueadero.servicios.IngresoVehiculoServicio;
import parqueadero.testDataBuilder.TarifaParqTestDataBuilder;
import parqueadero.dominio.Automovil;
import parqueadero.dominio.Motocicleta;
import parqueadero.dominio.ParametrosParqueadero;
import parqueadero.dominio.Vehiculo;
import parqueadero.entidad.TarifaParqueaderoEntity;
import parqueadero.entidad.TipoVehiculo;
import parqueadero.exception.ParqueaderoException;
import parqueadero.repository.BitacoraIngresoRepository;
import parqueadero.repository.TarifaRepository;

public class ValidacionesIngresoTest {

	private static final String PLACANOAUTORIADA = "ABC-123";
	private static final String PLACAAUTORIZADA = "BCD-123";
	private static final String TIPOVEHICULO = TipoVehiculo.AUTOMOVIL.getCodigo();
	private static final String TIPOVEHICULOBICICLETA = "B";
	private static final int CANTIDAD_MAXIMA_MOTOS = 10;
	private static final double CILINDRAJE = 600;

	@Autowired
	IngresoVehiculoServicio ingresoService;	

	@Test
	public void registrarIngresoAutomovil_PlacaNoAutorizada() {

		// arrange
		Automovil automovil = new Automovil(PLACANOAUTORIADA, TIPOVEHICULO);

		// act
		try {
			ingresoService.registrarIngresoAutomovil(automovil);
			fail();

		} catch (Throwable ex) {
			// assert
			Assert.assertNotEquals(ParametrosParqueadero.VEHICULO_NO_AUTORIZADO, ex.getMessage());
		}

	}
	
	@Test
	public void registrarIngresoMotocicleta_PlacaNoAutorizada() {

		// arrange
		Motocicleta motocicleta = new Motocicleta(PLACANOAUTORIADA, TIPOVEHICULO, CILINDRAJE);

		// act
		try {
			ingresoService.registrarIngresoMotocicleta(motocicleta);
			fail();

		} catch (Throwable ex) {
			// assert
			Assert.assertNotEquals(ParametrosParqueadero.VEHICULO_NO_AUTORIZADO, ex.getMessage());
		}

	}
	
	@Test
	public void registrarIngresoAutomovil_TipoVehiculoDiferente() {

		// arrange
		Automovil automovil = new Automovil(PLACAAUTORIZADA, TIPOVEHICULOBICICLETA);

		// act
		try {
			ingresoService.registrarIngresoAutomovil(automovil);
			fail();

		} catch (Throwable ex) {
			// assert
			Assert.assertNotEquals(ParametrosParqueadero.TIPO_DE_VEHICULO_NO_AUTORIADO, ex.getMessage());
		}

	}
	
	@Test
	public void registrarIngresoAutomovil_CupoNoDisponible() {

		// arrange
		Automovil automovil = new Automovil(PLACAAUTORIZADA, TIPOVEHICULOBICICLETA);

		// act
		try {
			ingresoService.registrarIngresoAutomovil(automovil);
			fail();

		} catch (Throwable ex) {
			// assert
			Assert.assertNotEquals(ParametrosParqueadero.SIN_CUPO_PARA_AUTOMOVIL, ex.getMessage());
		}

	}
	
	@Test
	public void registrarMotocicleta_CupoNoDisponible() {

		// arrange
		Motocicleta motocicleta = new Motocicleta(PLACAAUTORIZADA, TIPOVEHICULOBICICLETA, CILINDRAJE);

		// act
		try {
			ingresoService.registrarIngresoMotocicleta(motocicleta);
			fail();

		} catch (Throwable ex) {
			// assert
			Assert.assertNotEquals(ParametrosParqueadero.SIN_CUPO_PARA_MOTOCICLETA, ex.getMessage());
		}
	}
	

}
