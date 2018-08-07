package parqueadero.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import parqueadero.dominio.ParametrosParqueadero;
import parqueadero.entidad.BitacoraSalidaEntity;
import parqueadero.exception.ParqueaderoException;
import parqueadero.repository.AutomovilRepository;
import parqueadero.servicios.SalidaVehiculoServicio;
import parqueadero.servicios.serviciosimpl.SalidaVehiculosImpl;

@RestController
@RequestMapping( ParametrosParqueadero.API )
public class BitacoraSalidaControlador {

	private static final Logger LOGGER = LoggerFactory.getLogger(BitacoraIngresoControlador.class);
	
	@Autowired	
	private SalidaVehiculoServicio salidaVehiculoServicio;

	@Autowired
	private AutomovilRepository automovilRepository;	

	@RequestMapping(value = ParametrosParqueadero.RUTA_SALIDA_AUTOMOVIL, method = RequestMethod.POST)
	public BitacoraSalidaEntity registraSalidaAutomovil(@PathVariable String placa) {		
		
		BitacoraSalidaEntity bitacoraSalidaEntity = new BitacoraSalidaEntity();
		try {
			bitacoraSalidaEntity = salidaVehiculoServicio.registrarSalidaDeAutomovil(placa);
		} catch (ParqueaderoException e) {
			LOGGER.info("ParqueaderoException ", e);		
		}
		return bitacoraSalidaEntity;
	}
	
	
}

