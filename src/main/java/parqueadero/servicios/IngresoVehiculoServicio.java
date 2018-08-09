package parqueadero.servicios;

import parqueadero.exception.ParqueaderoException;

import java.util.Calendar;
import parqueadero.dominio.RespuestaPeticion;
import parqueadero.dominio.Vehiculo;
import parqueadero.entidad.BitacoraIngresoEntity;

public interface IngresoVehiculoServicio {
	
	public RespuestaPeticion registrarIngresoVehiculo(Vehiculo vehiculo, Calendar fechaIngreso) throws ParqueaderoException;
	
	public BitacoraIngresoEntity consultaIngresoActivo(String placa);
}
