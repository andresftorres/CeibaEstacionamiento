package parqueadero.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import parqueadero.dominio.Automovil;
import parqueadero.entidad.AutomovilEntity;
import parqueadero.servicios.IngresoVehiculoServicio;



@RestController
public class BitacoraIngresoControaldor {

	@Autowired
	private IngresoVehiculoServicio ingresoVehiculoServicio;
	
	
	public ResponseEntity<Object> registrarIngresoVehiculo(@RequestBody Automovil automovil) {
		
		AutomovilEntity automovilEntity = ingresoVehiculoServicio.registrarIngresoAutomovil(automovil);		
		
		if (automovilEntity == null) {
			return ResponseEntity.badRequest().header("Error", "10").body(automovilEntity);
		} else {
			return ResponseEntity.ok().body(automovilEntity);
		}
		
	}
}
