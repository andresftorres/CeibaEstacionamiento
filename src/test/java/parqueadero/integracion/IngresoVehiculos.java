package parqueadero.integracion;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;
import parqueadero.builder.TarifaParqueaderoBuilder;
import parqueadero.controlador.BitacoraIngresoControlador;
import parqueadero.dominio.Automovil;
import parqueadero.dominio.TarifaParqueadero;
import parqueadero.entidad.BitacoraIngresoEntity;
import parqueadero.entidad.TarifaParqueaderoEntity;
import parqueadero.repository.TarifaRepository;
import parqueadero.testDataBuilder.AutomovilTestDataBuilder;
import parqueadero.testDataBuilder.TarifaParqTestDataBuilder;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IngresoVehiculos {

	private static final String PLACA_AUTORIZADA = "BCD-123";
	private static final String TIPO_VEHICULO_BICICLETA = "B";
	private static final String TIPO_VEHICULO_AUTOMOVIL = "A";
	private static final boolean NO_USA_CILINDRAJE = false;
	private static final Date MARTES_HABIL = new GregorianCalendar(2018, Calendar.JULY, 31).getTime();
	
	
    private TestRestTemplate restTemplate;
	
	@Autowired	
	BitacoraIngresoControlador bitacoraIngresosController;	
	
	@Autowired
	TarifaRepository tarifaRepo;
	
//	
//	@Test
//	public void registrarIngresoAutomovil_TipoVehiculoNoAutorizado() {
//
//		// arrange
//		Automovil automovil = new AutomovilTestDataBuilder()
//				.conPlaca(PLACA_AUTORIZADA)
//				.conTipoVehiculo(TIPO_VEHICULO_BICICLETA)
//				.build();		
//		
//		TarifaParqueadero tarifaparqueadero = new TarifaParqTestDataBuilder()
//				.conTipoVehiculo(TIPO_VEHICULO_AUTOMOVIL)
//				.conValorHora(1000)
//				.conValorDia(8000)
//				.conCapacidadMaxima(10)
//				.conUsaCilindraje(NO_USA_CILINDRAJE)
//				.conCilindrajeMaximo(0)
//				.conCobroExtraCilindraje(0)
//				.build();
//				
//		TarifaParqueaderoEntity tarifaParqueaderoEntity = TarifaParqueaderoBuilder.convertirAEntity(tarifaparqueadero);
//		tarifaRepo.save(tarifaParqueaderoEntity);
//		
//		// acts		
//		ResponseEntity<BitacoraIngresoEntity> bitacoraIngresoResp = restTemplate.postForEntity("/api/ingresoautomovil", automovil, BitacoraIngresoEntity.class);
//		BitacoraIngresoEntity bitacoraIngresoEntity = bitacoraIngresoResp.getBody();       
//		
//		// assert
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, bitacoraIngresoResp.getStatusCode());     
//        assertEquals(bitacoraIngresoEntity.getFechaIngreso(), null);
//        
//	}
	
}
