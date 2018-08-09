package parqueadero.integracion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import parqueadero.dominio.ParametrosParqueadero;
import parqueadero.dominio.RespuestaPeticion;
import parqueadero.dominio.Vehiculo;
import parqueadero.entidad.TipoVehiculo;
import parqueadero.repository.VehiculoRepository;
import parqueadero.testDataBuilder.VehiculoTestDataBuilder;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SalidaVehiculosIntegracion {	
	
	private static String PLACA_AUTORIZADA = "DBC-234";
	private static TipoVehiculo TIPO_VEHICULO_BICICLETA = TipoVehiculo.BICICLETA;
	
	@Autowired
	VehiculoRepository vehiculoRepo;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@SqlGroup(@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:eliminarDatos.sql"))
	public void registrarIngresoAutomovil_TipoVehiculoNoPermitido() {

		// arrange
		Vehiculo automovil = new VehiculoTestDataBuilder().conPlaca(PLACA_AUTORIZADA)
				.conTipoVehiculo(TIPO_VEHICULO_BICICLETA).build();					
		
		ResponseEntity<RespuestaPeticion> respuestaPeticion = null;	
		
		// acts
		respuestaPeticion = restTemplate.postForEntity("/api/ingresovehiculo", automovil, RespuestaPeticion.class);
		RespuestaPeticion respuestaBody = respuestaPeticion.getBody();
		// assert

		assertEquals(HttpStatus.OK, respuestaPeticion.getStatusCode());
		assertEquals(ParametrosParqueadero.TIPO_DE_VEHICULO_NO_AUTORIZADO,respuestaBody.getMensaje() );
		
	}
	
}
