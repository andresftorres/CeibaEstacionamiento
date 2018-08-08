package parqueadero.servicios;

import java.util.List;

import parqueadero.dominio.BitacoraIngreso;
import parqueadero.dominio.RespuestaConsulta;
import parqueadero.dominio.Vehiculo;


import parqueadero.exception.ParqueaderoException;


public interface ConsultaServicios {
	
	public RespuestaConsulta consultaVehiculo(String placa) throws ParqueaderoException;
			
	public RespuestaConsulta crearRespuesta(BitacoraIngreso biacoraActiva, Vehiculo vehiculoenParqueadero);
	
	public List<RespuestaConsulta> obtenerTodosVehiculos() throws ParqueaderoException;
	 
}
