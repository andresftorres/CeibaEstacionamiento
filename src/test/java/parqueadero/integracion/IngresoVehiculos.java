package parqueadero.integracion;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import parqueadero.builder.VehiculoBuilder;
import parqueadero.controlador.BitacoraIngresoControlador;
import parqueadero.dominio.ParametrosParqueadero;
import parqueadero.dominio.RespuestaPeticion;
import parqueadero.dominio.Vehiculo;
import parqueadero.entidad.TipoVehiculo;
import parqueadero.repository.VehiculoRepository;
import parqueadero.testDataBuilder.VehiculoTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IngresoVehiculos {

	private static final String PLACA_AUTORIZADA = "BCD-123";
	private static final TipoVehiculo TIPO_VEHICULO_BICICLETA = TipoVehiculo.BICICLETA;
	private static final String TIPO_VEHICULO_AUTOMOVIL = TipoVehiculo.AUTOMOVIL.getDescripcion();
	private static final boolean NO_USA_CILINDRAJE = false;
	private static final Long IDTARIFA = 1L;

	@Mock
	private TestRestTemplate restTemplate;

	@Mock
	BitacoraIngresoControlador bitacoraIngresosController;

	@Mock
	VehiculoRepository vehiculoRepo;
/*
	@Test
	public void registrarIngresoAutomovil_VehiculoYaExiste() {

		// arrange
		Vehiculo automovil = new VehiculoTestDataBuilder().conPlaca(PLACA_AUTORIZADA)
				.conTipoVehiculo(TIPO_VEHICULO_BICICLETA).build();					
		
		ResponseEntity<RespuestaPeticion> respuestaPeticion = null;
		
		restTemplate.postForEntity("/api/ingresovehiculo", automovil, RespuestaPeticion.class);
		
		
		try {
			// acts
			respuestaPeticion = restTemplate.postForEntity("/api/ingresoautomovil",
					automovil, RespuestaPeticion.class);			
			fail();
		} catch (Exception ex) {
			// assert
			
			assertEquals(HttpStatus.OK, respuestaPeticion.getStatusCode());
			assertEquals(ParametrosParqueadero.TIPO_DE_VEHICULO_NO_AUTORIZADO, ex.getMessage());
		}
	}

	@Test
	public void registrarIngresoAutomovil_Autorizado() {

		// arrange
		Vehiculo automovil = new VehiculoTestDataBuilder().conPlaca(PLACA_AUTORIZADA)
				.conTipoVehiculo(TIPO_VEHICULO_BICICLETA).build();		
		// acts
		ResponseEntity<RespuestaPeticion> respuestaPeticion = restTemplate.postForEntity("/api/ingresoautomovil",
				automovil, RespuestaPeticion.class);
		RespuestaPeticion respuestaDominio = respuestaPeticion.getBody();

		// assert
		assertEquals(HttpStatus.OK, respuestaPeticion.getStatusCode());
		assertEquals(ParametrosParqueadero.TIPO_DE_VEHICULO_NO_AUTORIZADO, respuestaDominio.getMensaje());

	}
*/
}
