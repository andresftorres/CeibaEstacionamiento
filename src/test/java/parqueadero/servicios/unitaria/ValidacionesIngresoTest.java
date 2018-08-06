package parqueadero.servicios.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import parqueadero.entidad.BitacoraIngresoEntity;
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
	private static final String FECHA_SOLICITUD = "2017-05-26";

	@Autowired
	@Qualifier("ingresovehiculosservicios")
	IngresoVehiculoServicio ingresoService;
	
	@Autowired
	@Qualifier("bitacoraingresorepositorio")
	BitacoraIngresoRepository bitacoraingresoRepo;

	@Test
	public void registrarIngresoAutomovil_PlacaNoAutorizada() {

		// arrange
		Automovil automovil = new Automovil(PLACANOAUTORIADA, TIPOVEHICULO);
		
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();	
		
		try {
			cal.setTime( formatDate.parse(FECHA_SOLICITUD) );
		} catch (ParseException e) {
			System.out.println("Exception :"+e);  
		}
		
		// act
		try {
			ingresoService.registrarIngresoAutomovil(automovil, cal);
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

		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Calendar cal = Calendar.getInstance();
		
		try {
			cal.setTime( formatter.parse(FECHA_SOLICITUD) );
		} catch (ParseException e) {			
			System.out.println("Exception :"+e);  
		}
				
		// act
		try {
			ingresoService.registrarIngresoMotocicleta(motocicleta, cal);
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

		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Calendar cal = Calendar.getInstance();
		
		try {
			cal.setTime( formatter.parse(FECHA_SOLICITUD) );
		} catch (ParseException e) {			
			System.out.println("Exception :"+e);  
		}
		
		// act
		try {
			ingresoService.registrarIngresoAutomovil(automovil, cal);
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

		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Calendar cal = Calendar.getInstance();
		
		try {
			cal.setTime( formatter.parse(FECHA_SOLICITUD) );
		} catch (ParseException e) {			
			System.out.println("Exception :"+e);  
		}
		
		// act
		try {
			ingresoService.registrarIngresoAutomovil(automovil, cal);
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

		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Calendar cal = Calendar.getInstance();
		
		try {
			cal.setTime( formatter.parse(FECHA_SOLICITUD) );
		} catch (ParseException e) {			
			System.out.println("Exception :"+e);  
		}
		
		// act
		try {
			ingresoService.registrarIngresoMotocicleta(motocicleta, cal);
			fail();

		} catch (Throwable ex) {
			// assert
			Assert.assertNotEquals(ParametrosParqueadero.SIN_CUPO_PARA_MOTOCICLETA, ex.getMessage());
		}
	}
	/*
	@Test
	public void consultaIngresoActivo_VehiculoNoActivoEnParqueadero(String placa) {			
		//Arrange
		
		//BitacoraIngresoEntity bitacoraIngresoEntity;
		//when(bitacoraingresoRepo.bitacoraIngresoAutoByPlaca(placa)).thenReturn(bitacoraIngresoEntity);
		
		//Act
		//boolean esActivoEnParqueadero = ingresoService.consultaIngresoActivo(PLACAAUTORIZADA);
		//Assert
		//Assert.assertNotNull();
				
	}	
*/
}
