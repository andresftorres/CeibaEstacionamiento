package parqueadero.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import parqueadero.dominio.RespuestaConsulta;
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
