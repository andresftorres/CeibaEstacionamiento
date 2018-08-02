package parqueadero.servicios;

import parqueadero.exception.ParqueaderoException;
import parqueadero.dominio.Vehiculo;

public interface IngresoVehiculoServicio {

	public void ingresoVehiculo(Vehiculo vehiculo) throws ParqueaderoException;

	public void disponibilidadCupoIngreso(String configTarifas) throws ParqueaderoException;

	public void autorizaPlacaDiaActual(String placaVehiculo) throws ParqueaderoException;

	public void vehiculoEnParqueadero(String placaVehiculo) throws ParqueaderoException;

}
