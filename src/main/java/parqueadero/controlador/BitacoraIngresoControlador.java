package parqueadero.controlador;

import java.util.Calendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import parqueadero.exception.ParqueaderoException;
import parqueadero.servicios.IngresoVehiculoServicio;
import parqueadero.dominio.ParametrosParqueadero;
import parqueadero.dominio.RespuestaPeticion;
import parqueadero.dominio.Vehiculo;

@RestController
@RequestMapping( ParametrosParqueadero.API )
public class BitacoraIngresoControlador {

	private static final Logger LOGGER = LoggerFactory.getLogger(BitacoraIngresoControlador.class);
	
	@Autowired
	private IngresoVehiculoServicio ingresoVehiculoServicio;


	@RequestMapping(value = ParametrosParqueadero.RUTA_INGRESO, method = RequestMethod.POST)
	public ResponseEntity<RespuestaPeticion> registrarIngresoVehiculo(@RequestBody(required = true) Vehiculo automovil) {		
		try {
			return new ResponseEntity<>(ingresoVehiculoServicio.registrarIngresoVehiculo(automovil, calculaFechaIngreso()), HttpStatus.OK );
		} catch (ParqueaderoException e) {			
			LOGGER.error("ParqueaderoException ", e);
			
			return new ResponseEntity<>( new RespuestaPeticion( e.getMessage(), e.getDescripion()), HttpStatus.OK);
			
		}
	}	
			
	private Calendar calculaFechaIngreso() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		return calendar;
	}
}
