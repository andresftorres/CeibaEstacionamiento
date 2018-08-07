package parqueadero.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import parqueadero.dominio.RespuestaConsulta;
import parqueadero.entidad.BitacoraIngresoEntity;
import parqueadero.servicios.ConsultaServicios;

@RestController
public class ConsultaVehiculosController {

	@Autowired
	ConsultaServicios consultaServicios;
	
	
	
	public RespuestaConsulta consultarVehiculos( String placa ) {
		
		return null;
	}
	
//	
//	BitacoraIngresoEntity ingresoParqueadero = bitacoraIngresoRepo.bitacoraIngresoAutoByPlaca(placa);
//	
//	if (ingresoParqueadero.isEnPaqueadero()) {
//		return ingresoParqueadero;
//	}
//	return null;		
}
