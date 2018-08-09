package parqueadero.servicios.unitaria;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
import org.springframework.test.util.ReflectionTestUtils;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import parqueadero.builder.VehiculoBuilder;
import parqueadero.dominio.Vehiculo;
import parqueadero.repository.BitacoraIngresoRepository;
import parqueadero.repository.VehiculoRepository;
import parqueadero.entidad.TipoVehiculo;
import parqueadero.entidad.VehiculoEntity;
import parqueadero.servicios.serviciosimpl.ValidacionesServiciosImpl;
import parqueadero.testDataBuilder.VehiculoTestDataBuilder;

public class ValidacionesServiciosTest {

	public static final String PLACA_NO_AUTORIZADA = "ABC-123";
	public static final String PLACA_AUTORIZADA = "DFE-123";
	public static final TipoVehiculo TIPO_VEHICULO_BICICLETA = TipoVehiculo.BICICLETA;
	public static final TipoVehiculo TIPO_VEHICULO_MOTOCICLETA = TipoVehiculo.MOTOCICLETA;
	public static final TipoVehiculo TIPO_VEHICULO_AUTOMOVIL = TipoVehiculo.AUTOMOVIL;
	public static final int CANTIDAD_DIEZ = 10;
	public static final int CANTIDAD_UNO = 1;
	public static final int CANTIDAD_VEINTE = 20;
	public static final double ALTO_CILINDRAJE = 600;
	public static final Long ID_VEHICULO = 1L;
	private static final String FECHA_PERMITIDA = "2018-08-3";
	private static final double SIN_CILINDRAJE = Double.NaN;

	@Mock
	BitacoraIngresoRepository bitacoraIngresoRepo;

	@Mock
	VehiculoRepository vehiculoRepo;	

	@Test
	public void validarTipoDeVehiculo_TipoVehiculoNoSoportado() {

		// Arrange
		ValidacionesServiciosImpl validaciones = new ValidacionesServiciosImpl();
		Vehiculo automovil = new Vehiculo(PLACA_NO_AUTORIZADA, TIPO_VEHICULO_BICICLETA, SIN_CILINDRAJE);

		// Act
		boolean tipoAutorizado = validaciones.validarTipoDeVehiculo(automovil.getTipoVehiculo());

		// Assert
		Assert.assertFalse(tipoAutorizado);

	};

	@Test
	public void disponibilidadMotocicleta_ParqueaderoLleno() {

		// Arrange
		ValidacionesServiciosImpl validaciones = new ValidacionesServiciosImpl();
		
		bitacoraIngresoRepo = mock( BitacoraIngresoRepository.class);
		when(bitacoraIngresoRepo.cantidadVehiculosporTipo(TIPO_VEHICULO_MOTOCICLETA.getDescripcion())).thenReturn((long) CANTIDAD_DIEZ);
		
		ReflectionTestUtils.setField(validaciones, "bitacoraIngresoRepo", bitacoraIngresoRepo);

		// Act
		boolean disponibilidad = validaciones.disponibilidadVehiculo(TIPO_VEHICULO_MOTOCICLETA);

		// Assert
		Assert.assertFalse(disponibilidad);
	};

	@Test
	public void disponibilidadAutomovil_ParqueaderoLleno() {

		// Arrange
		ValidacionesServiciosImpl validaciones = new ValidacionesServiciosImpl();

		bitacoraIngresoRepo = mock(BitacoraIngresoRepository.class);
		when(bitacoraIngresoRepo.cantidadVehiculosporTipo(TIPO_VEHICULO_AUTOMOVIL.getDescripcion())).thenReturn((long) CANTIDAD_VEINTE);
		

		ReflectionTestUtils.setField(validaciones, "bitacoraIngresoRepo", bitacoraIngresoRepo);

		// Act
		boolean disponibilidad = validaciones.disponibilidadVehiculo(TIPO_VEHICULO_AUTOMOVIL);

		// Assert
		Assert.assertFalse(disponibilidad);
	};

	@Test
	public void disponibilidadAutomovil_ParqueaderoConDisponibilidad() { // Arrange
		ValidacionesServiciosImpl validaciones = new ValidacionesServiciosImpl();

		bitacoraIngresoRepo = mock(BitacoraIngresoRepository.class);
		when(bitacoraIngresoRepo.cantidadVehiculosporTipo(TIPO_VEHICULO_AUTOMOVIL.getDescripcion())).thenReturn((long) CANTIDAD_UNO);

		ReflectionTestUtils.setField(validaciones, "bitacoraIngresoRepo", bitacoraIngresoRepo);

		// Act
		boolean disponible = validaciones.disponibilidadVehiculo(TIPO_VEHICULO_AUTOMOVIL);

		// Assert
		Assert.assertTrue(disponible);

	};

	@Test
	public void disponibilidadMotocicleta_ParqueaderoConDisponibilidad() {
		// Arrange
		ValidacionesServiciosImpl validaciones = new ValidacionesServiciosImpl();

		bitacoraIngresoRepo = mock(BitacoraIngresoRepository.class);
		when(bitacoraIngresoRepo.cantidadVehiculosporTipo(TIPO_VEHICULO_MOTOCICLETA.getDescripcion())).thenReturn((long) CANTIDAD_UNO);
		

		ReflectionTestUtils.setField(validaciones, "bitacoraIngresoRepo", bitacoraIngresoRepo);		

		// Act
		boolean disponible = validaciones.disponibilidadVehiculo(TIPO_VEHICULO_MOTOCICLETA);

		// Assert
		Assert.assertTrue(disponible);
	};

	@Test
	public void autorizaPlacaDiaActual_PlacaNoAutorizada() {
		// Arrange
		ValidacionesServiciosImpl validaciones = new ValidacionesServiciosImpl();
		Vehiculo automovil = new Vehiculo(PLACA_NO_AUTORIZADA, TIPO_VEHICULO_AUTOMOVIL, SIN_CILINDRAJE);

		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();

		try {
			cal.setTime(formatDate.parse(FECHA_PERMITIDA));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Act

		boolean placaAutorizada = validaciones.autorizaPlacaDiaActual(automovil.getPlaca(), cal);
		// Assert
		Assert.assertFalse(placaAutorizada);
	}

	@Test
	public void vehiculoEnParqueadero_ExisteVehiculo() {
		// Arrange
		ValidacionesServiciosImpl validaciones = new ValidacionesServiciosImpl();

		Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_AUTOMOVIL)
				.conPlaca(PLACA_AUTORIZADA).build();

		VehiculoEntity vehiculoEntity = VehiculoBuilder.convertirAEntity(vehiculo);
		bitacoraIngresoRepo = mock(BitacoraIngresoRepository.class);
		when(bitacoraIngresoRepo.vehiculoEnParqueadero(any())).thenReturn(vehiculoEntity);

		ReflectionTestUtils.setField(validaciones, "bitacoraIngresoRepo", bitacoraIngresoRepo);
		
		// Act
		boolean existeVehiculo = validaciones.vehiculoEnParqueadero(vehiculo.getPlaca());

		// Assert
		Assert.assertTrue(existeVehiculo);
	}

}
