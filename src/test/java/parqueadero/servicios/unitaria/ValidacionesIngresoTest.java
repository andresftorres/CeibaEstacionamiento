package parqueadero.servicios.unitaria;

import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import parqueadero.servicios.IngresoVehiculoServicio;
import parqueadero.dominio.ParametrosParqueadero;
import parqueadero.dominio.Vehiculo;
import parqueadero.entidad.TipoVehiculo;
import parqueadero.repository.BitacoraIngresoRepository;

public class ValidacionesIngresoTest {

	private static final String PLACANOAUTORIADA = "ABC-123";
	private static final String PLACAAUTORIZADA = "BCD-123";
	private static final TipoVehiculo TIPOVEHICULO = TipoVehiculo.AUTOMOVIL;
	private static final TipoVehiculo TIPOVEHICULOBICICLETA = TipoVehiculo.MOTO_ELECTRICA;
	private static final double CILINDRAJE = 600;
	private static final String FECHA_SOLICITUD = "2017-05-26";
	private static final double SIN_CILINDRAJE = Double.NaN;

	@Autowired
	IngresoVehiculoServicio ingresoService;
	
	@Autowired
	BitacoraIngresoRepository bitacoraingresoRepo;

	@Test
	public void registrarIngresoAutomovil_PlacaNoAutorizada() {

		// arrange
		Vehiculo automovil = new Vehiculo(PLACANOAUTORIADA, TIPOVEHICULO, SIN_CILINDRAJE);
		
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();	
		
		try {
			cal.setTime( formatDate.parse(FECHA_SOLICITUD) );
		} catch (ParseException e) {
			System.out.println("Exception :"+e);  
		}
		
		// act
		try {
			ingresoService.registrarIngresoVehiculo(automovil, cal);
			fail();

		} catch (Throwable ex) {
			// assert
			Assert.assertNotEquals(ParametrosParqueadero.VEHICULO_NO_AUTORIZADO, ex.getMessage());
		}

	}
	
	@Test
	public void registrarIngresoMotocicleta_PlacaNoAutorizada() {

		// arrange
		Vehiculo motocicleta = new Vehiculo(PLACANOAUTORIADA, TIPOVEHICULO, CILINDRAJE);

		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Calendar cal = Calendar.getInstance();
		
		try {
			cal.setTime( formatter.parse(FECHA_SOLICITUD) );
		} catch (ParseException e) {			
			System.out.println("Exception :"+e);  
		}
				
		// act
		try {
			ingresoService.registrarIngresoVehiculo(motocicleta, cal);
			fail();

		} catch (Throwable ex) {
			// assert
			Assert.assertNotEquals(ParametrosParqueadero.VEHICULO_NO_AUTORIZADO, ex.getMessage());
		}

	}
	
	@Test
	public void registrarIngresoAutomovil_TipoVehiculoDiferente() {

		// arrange
		Vehiculo automovil = new Vehiculo(PLACAAUTORIZADA, TIPOVEHICULOBICICLETA, SIN_CILINDRAJE);

		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Calendar cal = Calendar.getInstance();
		
		try {
			cal.setTime( formatter.parse(FECHA_SOLICITUD) );
		} catch (ParseException e) {			
			System.out.println("Exception :"+e);  
		}
		
		// act
		try {
			ingresoService.registrarIngresoVehiculo(automovil, cal);
			fail();

		} catch (Throwable ex) {
			// assert
			Assert.assertNotEquals(ParametrosParqueadero.TIPO_DE_VEHICULO_NO_AUTORIZADO, ex.getMessage());
		}

	}
	
	@Test
	public void registrarIngresoAutomovil_CupoNoDisponible() {

		// arrange
		Vehiculo automovil = new Vehiculo(PLACAAUTORIZADA, TIPOVEHICULOBICICLETA, SIN_CILINDRAJE);

		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Calendar cal = Calendar.getInstance();
		
		try {
			cal.setTime( formatter.parse(FECHA_SOLICITUD) );
		} catch (ParseException e) {			
			System.out.println("Exception :"+e);  
		}
		
		// act
		try {
			ingresoService.registrarIngresoVehiculo(automovil, cal);
			fail();

		} catch (Throwable ex) {
			// assert
			Assert.assertNotEquals(ParametrosParqueadero.SIN_CUPO_PARA_VEHICULO, ex.getMessage());
		}

	}
	
	@Test
	public void registrarMotocicleta_CupoNoDisponible() {

		// arrange
		Vehiculo motocicleta = new Vehiculo(PLACAAUTORIZADA, TIPOVEHICULOBICICLETA, CILINDRAJE);

		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Calendar cal = Calendar.getInstance();
		
		try {
			cal.setTime( formatter.parse(FECHA_SOLICITUD) );
		} catch (ParseException e) {			
			System.out.println("Exception :"+e);  
		}
		
		// act
		try {
			ingresoService.registrarIngresoVehiculo(motocicleta, cal);
			fail();

		} catch (Throwable ex) {
			// assert
			Assert.assertNotEquals(ParametrosParqueadero.SIN_CUPO_PARA_VEHICULO, ex.getMessage());
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
