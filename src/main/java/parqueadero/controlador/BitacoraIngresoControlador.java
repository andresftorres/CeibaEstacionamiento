package parqueadero.controlador;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import parqueadero.builder.AutomovilBuilder;
import parqueadero.dominio.Automovil;
import parqueadero.dominio.Motocicleta;
import parqueadero.entidad.AutomovilEntity;
import parqueadero.entidad.BitacoraIngresoEntity;
import parqueadero.exception.ParqueaderoException;
import parqueadero.repository.AutomovilRepository;
import parqueadero.servicios.IngresoVehiculoServicio;
import parqueadero.dominio.ParametrosParqueadero;

@RestController
@RequestMapping( ParametrosParqueadero.API )
public class BitacoraIngresoControlador {

	private static final Logger LOGGER = LoggerFactory.getLogger(BitacoraIngresoControlador.class);
	
	@Autowired
	private IngresoVehiculoServicio ingresoVehiculoServicio;

	@Autowired
	private AutomovilRepository automovilRepository;	

	@RequestMapping(value = ParametrosParqueadero.RUTA_INGRESO_AUTOMOVIL, method = RequestMethod.POST)
	public BitacoraIngresoEntity registrarIngresoVehiculo(@RequestBody Automovil automovil) {		
		
		BitacoraIngresoEntity bitacoraIngresoEntity = new BitacoraIngresoEntity();
		try {
			bitacoraIngresoEntity = ingresoVehiculoServicio.registrarIngresoAutomovil(automovil, calculaFechaIngreso() );
		} catch (ParqueaderoException e) {			
			LOGGER.info("ParqueaderoException ", e);			
		}
		return bitacoraIngresoEntity;
	}
	
	@RequestMapping(value = ParametrosParqueadero.RUTA_INGRESO_MOTOCICLETA, method = RequestMethod.POST)
	public ResponseEntity<BitacoraIngresoEntity> registraringresoMotocicleta(@RequestBody Motocicleta motocicleta) {

		BitacoraIngresoEntity bitacoraIngresoEntity  = new BitacoraIngresoEntity();
		try {
			bitacoraIngresoEntity = ingresoVehiculoServicio.registrarIngresoMotocicleta(motocicleta, calculaFechaIngreso());
		} catch (ParqueaderoException e) {
			LOGGER.info("ParqueaderoException", e);	
		}

		if (bitacoraIngresoEntity == null) {
			return ResponseEntity.badRequest().header("Error", "10").body(bitacoraIngresoEntity);
		} else {
			return ResponseEntity.ok().body(bitacoraIngresoEntity);
		}

	}
			
	private Calendar calculaFechaIngreso() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		return calendar;
	}
}
