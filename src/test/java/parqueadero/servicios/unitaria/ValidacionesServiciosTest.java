package parqueadero.servicios.unitaria;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import parqueadero.builder.AutomovilBuilder;
import parqueadero.dominio.Automovil;
import parqueadero.repository.BitacoraIngresoRepository;
import parqueadero.repository.MotocicletaRepository;
import parqueadero.repository.TarifaRepository;
import parqueadero.entidad.AutomovilEntity;
import parqueadero.entidad.TipoVehiculo;
import parqueadero.servicios.serviciosimpl.ValidacionesServiciosImpl;
import parqueadero.testDataBuilder.AutomovilTestDataBuilder;

public class ValidacionesServiciosTest {

	public static final String PLACA_NO_AUTORIZADA = "ABC-123";
	public static final String PLACA_AUTORIZADA = "DFE-123";
	public static final String TIPO_VEHICULO_BICICLETA = "B";
	public static final String TIPO_VEHICULO_MOTOCICLETA = TipoVehiculo.MOTOCICLETA.getCodigo();
	public static final String TIPO_VEHICULO_AUTOMOVIL = TipoVehiculo.AUTOMOVIL.getCodigo();
	public static final int CANTIDAD_DIEZ = 10;
	public static final int CANTIDAD_NUEVE = 9;
	public static final double ALTO_CILINDRAJE = 600;
	public static final Long ID_VEHICULO = 1L;
	private static final String FECHA_PERMITIDA = "2018-08-3";
		
	@Autowired
	BitacoraIngresoRepository bitacoraIngresoRepo;
	
	@Autowired
	MotocicletaRepository mototcicletaRepo;
	
	@Autowired
	TarifaRepository tarifaRepo;
	
	
	@Test
	public void validarTipoDeVehiculo_TipoVehiculoNoSoportado() {
		
		//Arrange
		ValidacionesServiciosImpl validaciones = new ValidacionesServiciosImpl();
		Automovil automovil = new Automovil(PLACA_NO_AUTORIZADA, TIPO_VEHICULO_BICICLETA);		
		
		//Act
		boolean tipoAutorizado = validaciones.validarTipoDeVehiculo(automovil.getTipoVehiculo());
		
		//Assert
		Assert.assertFalse(tipoAutorizado);
		
	};
	/*
	@Test
	public void disponibilidadMotocicleta_ParqueaderoLleno() {
		
		//Arrange
		ValidacionesServiciosImpl validaciones = new ValidacionesServiciosImpl();		
		
		bitacoraIngresoRepo = mock(BitacoraIngresoRepository.class);
		when(bitacoraIngresoRepo.cantidadMotocicletasEnParqueadero()).thenReturn((long) CANTIDAD_DIEZ);
		
		ReflectionTestUtils.setField(validaciones, "bitacoraIngresoRepo", bitacoraIngresoRepo);
		
		//Act
		boolean disponibilidad = validaciones.disponibilidadMotocicleta();			
				
		//Assert			
		Assert.assertFalse(disponibilidad);
			
	};
	
	@Test	
	public void disponibilidadAutomovil_ParqueaderoLleno() {
		//Arrange	
		ValidacionesServiciosImpl validaciones = new ValidacionesServiciosImpl();
		
		bitacoraIngresoRepo = mock (BitacoraIngresoRepository.class);
		when(bitacoraIngresoRepo.cantidadAutomovilesEnParqueadero()).thenReturn((long) CANTIDAD_DIEZ);
		
		tarifaRepo = mock(TarifaRepository.class);
		when(tarifaRepo.obtenerTarifaPorTipo(TIPO_VEHICULO_AUTOMOVIL).getCapacidadMaxima()).thenReturn(CANTIDAD_DIEZ);
		
		ReflectionTestUtils.setField(validaciones, "bitacoraIngresoRepo", bitacoraIngresoRepo);
		ReflectionTestUtils.setField(validaciones, "tarifaRepo", tarifaRepo);
		
		//Act		
		boolean disponibilidad = validaciones.disponibilidadAutomovil();
			
				
		//Assert
		Assert.assertFalse(disponibilidad);
			
	};
	
	@Test	
	public void disponibilidadAutomovil_ParqueaderoVacio() {
		//Arrange	
		ValidacionesServiciosImpl validaciones = new ValidacionesServiciosImpl();
		
		bitacoraIngresoRepo = mock (BitacoraIngresoRepository.class);
		when(bitacoraIngresoRepo.cantidadAutomovilesEnParqueadero()).thenReturn((long) CANTIDAD_NUEVE);
		
		tarifaRepo = mock(TarifaRepository.class);
		when(tarifaRepo.obtenerTarifaPorTipo(TIPO_VEHICULO_AUTOMOVIL).getCapacidadMaxima()).thenReturn(CANTIDAD_DIEZ);
		
		ReflectionTestUtils.setField(validaciones, "bitacoraIngresoRepo", bitacoraIngresoRepo);
		ReflectionTestUtils.setField(validaciones, "tarifaRepo", tarifaRepo);
		
		//Act		
		boolean disponible = validaciones.disponibilidadAutomovil();		
				
		//Assert
		Assert.assertTrue(disponible);
		
	};
	
	@Test	
	public void disponibilidadMotocicleta_ParqueaderoVacio() {
		//Arrange	
		ValidacionesServiciosImpl validaciones = new ValidacionesServiciosImpl();
		
		bitacoraIngresoRepo = mock (BitacoraIngresoRepository.class);
		when(bitacoraIngresoRepo.cantidadMotocicletasEnParqueadero()).thenReturn((long) CANTIDAD_NUEVE);
		
		tarifaRepo = mock(TarifaRepository.class);
		when(tarifaRepo.obtenerTarifaPorTipo(TIPO_VEHICULO_MOTOCICLETA).getCapacidadMaxima()).thenReturn(CANTIDAD_DIEZ);
		
		ReflectionTestUtils.setField(validaciones, "bitacoraIngresoRepo", bitacoraIngresoRepo);
		ReflectionTestUtils.setField(validaciones, "tarifaRepo", tarifaRepo);
		
		//Act		
		boolean disponible = validaciones.disponibilidadMotocicleta();		
				
		//Assert
		Assert.assertTrue(disponible);		
	};
*/
	@Test
	public void autorizaPlacaDiaActual_PlacaNoAutorizada() {
		//Arrange
		ValidacionesServiciosImpl validaciones = new ValidacionesServiciosImpl();
		
		Automovil automovil = new Automovil(PLACA_NO_AUTORIZADA, TIPO_VEHICULO_AUTOMOVIL);
		
		//Act
		//SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		//boolean placaAutorizada = validaciones.autorizaPlacaDiaActual(automovil.getPlaca(), formatDate.parse(FECHA_PERMITIDA));
		//Assert
		//Assert.assertFalse(placaAutorizada);
	}

	@Test
	public void vehiculoEnParqueadero_ExisteVehiculo() {
		//Arrange
		ValidacionesServiciosImpl validaciones = new ValidacionesServiciosImpl();
		
		Automovil automovil = new AutomovilTestDataBuilder()
				.conTipoVehiculo(TIPO_VEHICULO_AUTOMOVIL)
				.conPlaca(PLACA_AUTORIZADA)
				.build();
		
		AutomovilEntity automovilEntity = AutomovilBuilder.convertirAEntity(automovil);		
		bitacoraIngresoRepo = mock (BitacoraIngresoRepository.class);		
		when(bitacoraIngresoRepo.automovilEnParqueadero(automovilEntity.getPlaca())).thenReturn(automovilEntity);
		
		ReflectionTestUtils.setField(validaciones, "bitacoraIngresoRepo", bitacoraIngresoRepo);
		//Act		
		boolean existeVehiculo = validaciones.vehiculoEnParqueadero(automovilEntity.getPlaca());
		
		//Assert
		Assert.assertNotNull(existeVehiculo);
	}
}
