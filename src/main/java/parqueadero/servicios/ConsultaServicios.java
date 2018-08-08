package parqueadero.servicios;

import java.util.List;


import parqueadero.dominio.RespuestaConsulta;
import parqueadero.entidad.BitacoraIngresoEntity;
import parqueadero.entidad.VehiculoEntity;
import parqueadero.exception.ParqueaderoException;


public interface ConsultaServicios {
	
	public RespuestaConsulta consultaVehiculo(String placa) throws ParqueaderoException;
			
	public RespuestaConsulta crearRespuesta(BitacoraIngresoEntity biacoraActiva, VehiculoEntity vehiculoenParqueadero);
	
	public List<RespuestaConsulta> obtenerTodosVehiculos() throws ParqueaderoException;
	 
}
