package parqueadero.servicios.unitaria;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import junit.framework.Assert;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;

import parqueadero.builder.BitacoraIngresoBuilder;
import parqueadero.builder.VehiculoBuilder;
import parqueadero.dominio.BitacoraIngreso;
import parqueadero.dominio.ParametrosParqueadero;
import parqueadero.dominio.RespuestaPeticion;
import parqueadero.dominio.Vehiculo;
import parqueadero.entidad.BitacoraIngresoEntity;
import parqueadero.entidad.TipoVehiculo;
import parqueadero.entidad.VehiculoEntity;
import parqueadero.exception.ParqueaderoException;
import parqueadero.factorypattern.ConstantesTipoVehiculo;
import parqueadero.factorypattern.FactoryRestriccionesTarifas;
import parqueadero.repository.BitacoraIngresoRepository;
import parqueadero.repository.BitacoraSalidaRepository;
import parqueadero.repository.VehiculoRepository;
import parqueadero.servicios.IngresoVehiculoServicio;
import parqueadero.servicios.SalidaVehiculoServicio;
import parqueadero.servicios.ValidacionesServicios;
import parqueadero.servicios.serviciosimpl.SalidaVehiculosImpl;
import parqueadero.testDataBuilder.BitacoraIngresoTestDataBuilder;
import parqueadero.testDataBuilder.VehiculoTestDataBuilder;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ValidacionesSalidaTest {

	private static final String PLACANOAUTORIADA = "ABC-123";
	private static final String PLACAAUTORIZADA = "BCD-123";
	private static final String TIPOVEHICULO = TipoVehiculo.AUTOMOVIL.getCodigo();
	private static final String TIPOVEHICULOBICICLETA = "B";
	private static final int CANTIDAD_MAXIMA_MOTOS = 10;
	private static final double CILINDRAJE = 600;
	private static final String FECHA_SOLICITUD = "2017-05-26";
	private static final String FECHA_MIERCOLES_8 = "2018-08-08";

	@Mock
	BitacoraSalidaRepository bitacoraSalidaRepo;

	@Mock
	BitacoraIngresoRepository bitacoraIngresoRepo;
	
	@Mock
	VehiculoRepository vehiculoRepo;
		
	@Mock
	ValidacionesServicios validacionesServicios;
	
	@Mock
	IngresoVehiculoServicio ingresoVehiculoServicio;
	
	@Mock
	SalidaVehiculoServicio salidaVehiculoServicio;

	@Test
	public void registrarSalidaSatisfactoriaTest() {

		// Arrange
		
		SalidaVehiculosImpl salidaServicio = new SalidaVehiculosImpl();	
		
		Vehiculo nuevo =  new VehiculoTestDataBuilder()
				.conTipoVehiculo(TipoVehiculo.AUTOMOVIL)
				.conPlaca("BCD-123")
				.build();
		VehiculoEntity vehiculoEntity = VehiculoBuilder.convertirAEntity(nuevo);
		
		vehiculoRepo = mock(VehiculoRepository.class);
		when(vehiculoRepo.findByPlaca(any())).thenReturn(vehiculoEntity);
		
		bitacoraIngresoRepo = mock(BitacoraIngresoRepository.class);
		when(bitacoraIngresoRepo.vehiculoEnParqueadero(any())).thenReturn(vehiculoEntity);
		
		BitacoraIngreso nuevaBitacorangreso = new BitacoraIngresoTestDataBuilder().conVehiculo(nuevo)
				.conEnPaqueadero(true)
				.conFechaIngreso(Calendar.getInstance())
				.build();
		BitacoraIngresoEntity nuvaBitacoraEntity = BitacoraIngresoBuilder.convertirAEntity(nuevaBitacorangreso);
		
		
		ingresoVehiculoServicio = mock(IngresoVehiculoServicio.class);
		when(ingresoVehiculoServicio.consultaIngresoActivo(nuevo.getPlaca())).thenReturn(nuvaBitacoraEntity );
		
		validacionesServicios = mock( ValidacionesServicios.class);
		when( validacionesServicios.vehiculoEnParqueadero(nuevo.getPlaca()) ).thenReturn(true);
		
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 8, 8, 1, 0);
		
		nuvaBitacoraEntity.setFechaIngreso(cal);
		when(bitacoraIngresoRepo.save(any())).thenReturn(nuvaBitacoraEntity);
		//when(bitacoraIngresoRepo.save(any())).thenReturn(bitacoraIngresoRepo);
		
		ReflectionTestUtils.setField(salidaServicio, "vehiculoRepo", vehiculoRepo);
		ReflectionTestUtils.setField(salidaServicio, "bitacoraIngresoRepo", bitacoraIngresoRepo);
		ReflectionTestUtils.setField(salidaServicio, "ingresoVehiculoServicio", ingresoVehiculoServicio);
		ReflectionTestUtils.setField(salidaServicio, "validacionesServicios", validacionesServicios);
		ReflectionTestUtils.setField(salidaServicio, "bitacoraSalidaRepo", bitacoraSalidaRepo);
		
		RespuestaPeticion respuesta;
		try {
			// Act
			respuesta = salidaServicio.registrarSalidaDeVehiculo("BCD-123");	
			
			// Assert
			assertEquals(ParametrosParqueadero.SALIDA_REGISTRADA_EXITOSAMENTE, respuesta.getMensaje());
		} catch (ParqueaderoException e) {
			fail();
		}
	}
	
	@Test
	public void registrarSalida_VehiculoNoExiste() {

		// Arrange
		
		SalidaVehiculosImpl salidaServicio = new SalidaVehiculosImpl();	
		
		Vehiculo motocicleta = new VehiculoTestDataBuilder()
				.conTipoVehiculo(TipoVehiculo.MOTOCICLETA)
				.conPlaca("BCD-12D")
				.build();
		
		VehiculoEntity motoEntity = VehiculoBuilder.convertirAEntity(motocicleta);
		
		vehiculoRepo = mock(VehiculoRepository.class);
		when(vehiculoRepo.findByPlaca(any())).thenReturn(motoEntity);
		
		bitacoraIngresoRepo = mock(BitacoraIngresoRepository.class);
		when(bitacoraIngresoRepo.vehiculoEnParqueadero(any())).thenReturn(null);		
		
		ReflectionTestUtils.setField(salidaServicio, "vehiculoRepo", vehiculoRepo);
		ReflectionTestUtils.setField(salidaServicio, "bitacoraIngresoRepo", bitacoraIngresoRepo);
		ReflectionTestUtils.setField(salidaServicio, "ingresoVehiculoServicio", ingresoVehiculoServicio);
		ReflectionTestUtils.setField(salidaServicio, "validacionesServicios", validacionesServicios);
		ReflectionTestUtils.setField(salidaServicio, "bitacoraSalidaRepo", bitacoraSalidaRepo);
		
		RespuestaPeticion respuesta;
		try {
			// Act
			respuesta = salidaServicio.registrarSalidaDeVehiculo("BCD-123");	
			fail();			
		} catch (ParqueaderoException e) {
			// Assert
			assertEquals(ParametrosParqueadero.EL_VEHICULO_NO_ESTA_EN_EL_PARQUEADERO, e.getDescripion());
			
		}
	}
	
	@Test
	public void registrarSalidaSatisfactoriaTest_MotocicletaAltoCilindraje17Horas() {

		// Arrange
		
		SalidaVehiculosImpl salidaServicio = new SalidaVehiculosImpl();	
		
		Vehiculo nuevo = new VehiculoTestDataBuilder()
				.conTipoVehiculo(TipoVehiculo.MOTOCICLETA)
				.conPlaca("BCD-123")
				.conCilindraje(1000)
				.build();
		
		VehiculoEntity vehiculoEntity = VehiculoBuilder.convertirAEntity(nuevo);
		
		vehiculoRepo = mock(VehiculoRepository.class);
		when(vehiculoRepo.findByPlaca(any())).thenReturn(vehiculoEntity);
		
		bitacoraIngresoRepo = mock(BitacoraIngresoRepository.class);
		when(bitacoraIngresoRepo.vehiculoEnParqueadero(any())).thenReturn(vehiculoEntity);
		
		Calendar ingreso = Calendar.getInstance();
		ingreso.set(2018, 8, 7, 0, 0);
		
		BitacoraIngreso nuevaBitacorangreso = new BitacoraIngresoTestDataBuilder().conVehiculo(nuevo)
				.conEnPaqueadero(true)
				.conFechaIngreso(ingreso)
				.build();
		BitacoraIngresoEntity nuvaBitacoraEntity = BitacoraIngresoBuilder.convertirAEntity(nuevaBitacorangreso);
		
		
		ingresoVehiculoServicio = mock(IngresoVehiculoServicio.class);
		when(ingresoVehiculoServicio.consultaIngresoActivo(nuevo.getPlaca())).thenReturn(nuvaBitacoraEntity );
		
		validacionesServicios = mock( ValidacionesServicios.class);
		when( validacionesServicios.vehiculoEnParqueadero(nuevo.getPlaca()) ).thenReturn(true);
		
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 8, 8, 5, 0);
		
		nuvaBitacoraEntity.setFechaIngreso(cal);
		when(bitacoraIngresoRepo.save(any())).thenReturn(nuvaBitacoraEntity);
		//when(bitacoraIngresoRepo.save(any())).thenReturn(bitacoraIngresoRepo);
		
		ReflectionTestUtils.setField(salidaServicio, "vehiculoRepo", vehiculoRepo);
		ReflectionTestUtils.setField(salidaServicio, "bitacoraIngresoRepo", bitacoraIngresoRepo);
		ReflectionTestUtils.setField(salidaServicio, "ingresoVehiculoServicio", ingresoVehiculoServicio);
		ReflectionTestUtils.setField(salidaServicio, "validacionesServicios", validacionesServicios);
		ReflectionTestUtils.setField(salidaServicio, "bitacoraSalidaRepo", bitacoraSalidaRepo);
		
		RespuestaPeticion respuesta;
		try {
			// Act
			respuesta = salidaServicio.registrarSalidaDeVehiculo("BCD-123");	
			
			// Assert
			assertEquals(ParametrosParqueadero.SALIDA_REGISTRADA_EXITOSAMENTE, respuesta.getMensaje());
			
		} catch (ParqueaderoException e) {
			fail();
		}
	}

}
