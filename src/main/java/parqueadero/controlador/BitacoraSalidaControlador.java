package parqueadero.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import parqueadero.dominio.ParametrosParqueadero;
import parqueadero.entidad.BitacoraSalidaEntity;
import parqueadero.repository.AutomovilRepository;
import parqueadero.servicios.serviciosimpl.SalidaVehiculosImpl;

@RestController("bitacorasalidacontrolador")
@RequestMapping( ParametrosParqueadero.API )
public class BitacoraSalidaControlador {

	@Autowired
	@Qualifier("ingresovehiculosservicios")
	private SalidaVehiculosImpl salidaVehiculoServicio;

	@Autowired
	@Qualifier("automovilrepositorio")
	private AutomovilRepository automovilRepository;

	@RequestMapping(value = ParametrosParqueadero.RUTA_SALIDA_AUTOMOVIL, method = RequestMethod.POST)
	public ResponseEntity<BitacoraSalidaEntity> registraSalidaAutomovil(@PathVariable String placa) {		
		
		BitacoraSalidaEntity bitacoraSalidaEntity = salidaVehiculoServicio.registrarSalidaDeAutomovil(placa);

		if (bitacoraSalidaEntity == null) {
			return ResponseEntity.badRequest().header("Error", "10").body(bitacoraSalidaEntity);
		} else {
			return ResponseEntity.ok().body(bitacoraSalidaEntity);
		}

	}

	
	
}

