package parqueadero.servicios.serviciosimpl;

import org.springframework.stereotype.Service;

import parqueadero.dominio.RespuestaConsulta;
import parqueadero.exception.ParqueaderoException;
import parqueadero.servicios.ConsultaServicios;

@Service
public class ConsultasServiciosImpl implements ConsultaServicios{

	@Override
	public RespuestaConsulta consultaVehiculo(String placa) throws ParqueaderoException {
		// TODO Auto-generated method stub
		return null;
	}

}
