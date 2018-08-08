package parqueadero.servicios;

import parqueadero.dominio.RespuestaPeticion;
import parqueadero.exception.ParqueaderoException;

public interface SalidaVehiculoServicio {

	
	public RespuestaPeticion registrarSalidaDeVehiculo(String placa) throws ParqueaderoException;

	

}
