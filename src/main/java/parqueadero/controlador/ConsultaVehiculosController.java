package parqueadero.controlador;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import parqueadero.dominio.ParametrosParqueadero;
import parqueadero.dominio.RespuestaConsulta;
import parqueadero.exception.ParqueaderoException;
import parqueadero.repository.BitacoraIngresoRepository;
import parqueadero.servicios.ConsultaServicios;

@RestController
@RequestMapping( ParametrosParqueadero.API )
public class ConsultaVehiculosController {

	@Autowired
	ConsultaServicios consultaServicios;

	@Autowired
	BitacoraIngresoRepository bitacoraIngresoRepo;

	private static final Log LOGGER = LogFactory.getLog(ConsultaVehiculosController.class);

	@RequestMapping(value = ParametrosParqueadero.RUTA_TODOS_LOS_VEHICULOS, method = RequestMethod.GET)
	public List<RespuestaConsulta> consultarVehiculos() {
		List<RespuestaConsulta> listaTodosVehiclos = null;
		try {
			listaTodosVehiclos = consultaServicios.obtenerTodosVehiculos();
		} catch (ParqueaderoException e) {
			LOGGER.error("ParqueaderoException ", e);
		}
		return listaTodosVehiclos;
	}
	
	@RequestMapping(value = ParametrosParqueadero.RUTA_CONSULTA, method = RequestMethod.GET)
	public RespuestaConsulta consultarVehiculo(@PathVariable("placa") String placa) {
		RespuestaConsulta respuestaConsulta = new RespuestaConsulta();
		try {
			respuestaConsulta = consultaServicios.consultaVehiculo(placa);
		} catch (ParqueaderoException e) {
			LOGGER.error("ParqueaderoException ", e);
		}
		return respuestaConsulta;
	}

}
