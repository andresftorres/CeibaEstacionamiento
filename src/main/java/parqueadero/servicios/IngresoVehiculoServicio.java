package parqueadero.servicios;

import parqueadero.exception.ParqueaderoException;
import parqueadero.dominio.Vehiculo;
import parqueadero.dominio.ConfigTarifas;

public interface IngresoVehiculoServicio {
	
	public boolean ingresoVehiculo(Vehiculo vehiculo) throws ParqueaderoException;
	
	public boolean disponibilidadCupoIngreso(ConfigTarifas configTarifas) throws ParqueaderoException;
	
	public boolean autorizaPlacaDiaActual(String placaVehiculo) throws ParqueaderoException;
	
	public boolean vehiculoEnParqueadero(String placaVehiculo ) throws ParqueaderoException;

}
