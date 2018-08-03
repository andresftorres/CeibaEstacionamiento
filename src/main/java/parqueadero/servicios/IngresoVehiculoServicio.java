package parqueadero.servicios;

import parqueadero.exception.ParqueaderoException;
import parqueadero.dominio.Automovil;
import parqueadero.dominio.Motocicleta;
import parqueadero.entidad.AutomovilEntity;

public interface IngresoVehiculoServicio {

	public AutomovilEntity registrarIngresoAutomovil(Automovil automovil) throws ParqueaderoException;
	
	public void registrarIngresoMotocicleta(Motocicleta motocicleta) throws ParqueaderoException;

}
