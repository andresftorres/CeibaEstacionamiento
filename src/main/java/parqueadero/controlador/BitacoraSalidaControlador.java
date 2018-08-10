package parqueadero.controlador;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import parqueadero.dominio.ParametrosParqueadero;
import parqueadero.dominio.RespuestaPeticion;
import parqueadero.exception.ParqueaderoException;
import parqueadero.servicios.SalidaVehiculoServicio;

@RestController
@RequestMapping( ParametrosParqueadero.API )
public class BitacoraSalidaControlador {

	
	private static final Log LOGGER = LogFactory.getLog(BitacoraSalidaControlador.class);
	
	@Autowired	
	private SalidaVehiculoServicio salidaVehiculoServicio;		

	@RequestMapping(value = ParametrosParqueadero.RUTA_SALIDA, method = RequestMethod.POST)
	public ResponseEntity<RespuestaPeticion> registraSalidaAutomovil(@PathVariable String placa) {		
		
		try {
			return new ResponseEntity<>(salidaVehiculoServicio.registrarSalidaDeVehiculo(placa) , HttpStatus.OK );
			
		} catch (ParqueaderoException e) {
			LOGGER.error("ParqueaderoException ", e);			
			return new ResponseEntity<>( new RespuestaPeticion(e.getMessage(), e.getDescripion()) ,HttpStatus.OK);
		}
		
	}
	
	
}

