package parqueadero.controlador;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
import parqueadero.repository.AutomovilRepository;
import parqueadero.servicios.IngresoVehiculoServicio;
import parqueadero.dominio.ParametrosParqueadero;

@RestController("bitacoraingresocontrolador")
@RequestMapping( ParametrosParqueadero.API )
public class BitacoraIngresoControlador {

	@Autowired
	@Qualifier("ingresovehiculosservicios")
	private IngresoVehiculoServicio ingresoVehiculoServicio;

	@Autowired
	@Qualifier("automovilrepositorio")
	private AutomovilRepository automovilRepository;	

	@RequestMapping(value = ParametrosParqueadero.RUTA_INGRESO_AUTOMOVIL, method = RequestMethod.POST)
	public ResponseEntity<BitacoraIngresoEntity> registrarIngresoVehiculo(@RequestBody Automovil automovil) {		
		
		BitacoraIngresoEntity bitacoraIngresoEntity = ingresoVehiculoServicio.registrarIngresoAutomovil(automovil, calculaFechaIngreso() );

		if (bitacoraIngresoEntity == null) {
			return ResponseEntity.badRequest().header("Error", "10").body(bitacoraIngresoEntity);
		} else {
			return ResponseEntity.ok().body(bitacoraIngresoEntity);
		}

	}
	
	@RequestMapping(value = ParametrosParqueadero.RUTA_INGRESO_MOTOCICLETA, method = RequestMethod.POST)
	public ResponseEntity<BitacoraIngresoEntity> registraringresoMotocicleta(@RequestBody Motocicleta motocicleta) {

		BitacoraIngresoEntity bitacoraIngresoEntity = ingresoVehiculoServicio.registrarIngresoMotocicleta(motocicleta, calculaFechaIngreso());

		if (bitacoraIngresoEntity == null) {
			return ResponseEntity.badRequest().header("Error", "10").body(bitacoraIngresoEntity);
		} else {
			return ResponseEntity.ok().body(bitacoraIngresoEntity);
		}

	}

	@RequestMapping(value = "/ingreso")
	public boolean registrarIngresoVeh(@RequestBody Automovil automovil) {

		AutomovilEntity automovilEntity = AutomovilBuilder.convertirAEntity(automovil);
		try{
			automovilRepository.save(automovilEntity);
			return true;
		}catch(Exception e) {
			return false;
		}
	}	
	@GetMapping("/greeting")
    public Automovil greeting(@RequestParam(required=false) Automovil automovil) {
        System.out.println("==== in greeting ====");
        return new Automovil(automovil.getPlaca(), automovil.getTipoVehiculo());
    }
	
	
	private Calendar calculaFechaIngreso() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		return calendar;
	}
}
