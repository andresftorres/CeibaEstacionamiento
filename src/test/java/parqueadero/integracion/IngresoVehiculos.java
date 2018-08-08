package parqueadero.integracion;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IngresoVehiculos {

	private static final String PLACA_AUTORIZADA = "BCD-123";
	private static final String TIPO_VEHICULO_BICICLETA = "B";
	private static final String TIPO_VEHICULO_AUTOMOVIL = "A";
	private static final boolean NO_USA_CILINDRAJE = false;
	private static final Date MARTES_HABIL = new GregorianCalendar(2018, Calendar.JULY, 31).getTime();
	
	
    //private TestRestTemplate restTemplate;
	
//	@Autowired	
//	BitacoraIngresoControlador bitacoraIngresosController;	
//	
//	@Autowired
//	TarifaRepository tarifaRepo;
//	
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
