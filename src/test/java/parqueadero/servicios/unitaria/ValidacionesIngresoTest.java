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
import parqueadero.dominio.Automovil;
import parqueadero.dominio.Motocicleta;
import parqueadero.dominio.ParametrosParqueadero;
import parqueadero.entidad.TipoVehiculo;
import parqueadero.repository.BitacoraIngresoRepository;

public class ValidacionesIngresoTest {

	private static final String PLACANOAUTORIADA = "ABC-123";
	private static final String PLACAAUTORIZADA = "BCD-123";
	private static final String TIPOVEHICULO = TipoVehiculo.AUTOMOVIL.getCodigo();
	private static final String TIPOVEHICULOBICICLETA = "B";
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
