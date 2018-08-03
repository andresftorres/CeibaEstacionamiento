package parqueadero.servicios;

import parqueadero.exception.ParqueaderoException;
import parqueadero.dominio.Automovil;
import parqueadero.dominio.Motocicleta;

public interface IngresoVehiculoServicio {

	public void registrarIngresoAutomovil(Automovil automovil) throws ParqueaderoException;
	
	public void registrarIngresoMotocicleta(Motocicleta motocicleta) throws ParqueaderoException;

}
