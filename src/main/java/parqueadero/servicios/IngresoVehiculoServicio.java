package parqueadero.servicios;

import parqueadero.exception.ParqueaderoException;

import java.util.Calendar;

import parqueadero.dominio.BitacoraIngreso;
import parqueadero.dominio.RespuestaPeticion;
import parqueadero.dominio.Vehiculo;

public interface IngresoVehiculoServicio {
	
	public RespuestaPeticion registrarIngresoVehiculo(Vehiculo vehiculo, Calendar fechaIngreso) throws ParqueaderoException;
	
	public BitacoraIngreso consultaIngresoActivo(String placa);
}
