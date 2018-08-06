package parqueadero.integracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import parqueadero.controlador.BitacoraIngresoControlador;
import parqueadero.entidad.TipoVehiculo;


public class IngresoVehiculos {

	private static final String PLACAAUTORIADA = "BCD-123";
	private static final String TIPOVEHICULO = TipoVehiculo.AUTOMOVIL.getCodigo();
	
	//@Autowired
    //private TestRestTemplate restTemplate;
	
	@Autowired
	@Qualifier("bitacoraingresocontrolador")
	BitacoraIngresoControlador bitacoraIngresosController;	
	/*
	@Test
	public void registrarIngresoAutomovil_PlacaAutorizada() {

		// arrange
		Automovil automovil = new Automovil(PLACAAUTORIADA, TIPOVEHICULO);

		// acts
		
		ResponseEntity<BitacoraIngresoEntity> responseEntity =  bitacoraIngresosController.registrarIngresoVehiculo(automovil);
		//ResponseEntity<BitacoraIngresoEntity> responseEntity = restTemplate.postForEntity("/api//bitacoraIngreso", automovil, BitacoraIngresoEntity.class);
		BitacoraIngresoEntity bitacoraEntity = responseEntity.getBody();
		
		// assert
		Assert.assertNotEquals(HttpStatus.OK,responseEntity.getStatusCode());
		Assert.assertNotNull(bitacoraEntity.getId());
	}
	*/
}
