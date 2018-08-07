package parqueadero.servicios;

import java.util.List;

import parqueadero.dominio.RespuestaConsulta;
import parqueadero.exception.ParqueaderoException;

public interface ConsultaServicios {
	
	public RespuestaConsulta consultaVehiculo(String placa) throws ParqueaderoException;
	
	//public Aparcamiento obtenerEntity (String placa, String ticket) throws BusinessException;
	
	//public ConsultaResp entityConverter(Aparcamiento entity);
	
	//public List<ConsultaResp> obtenerTodos();
	 
}
