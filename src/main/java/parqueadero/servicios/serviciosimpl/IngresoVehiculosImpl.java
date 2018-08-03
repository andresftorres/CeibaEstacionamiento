package parqueadero.servicios.serviciosimpl;

import org.springframework.beans.factory.annotation.Autowired;

import parqueadero.dominio.Automovil;
import parqueadero.dominio.Motocicleta;
import parqueadero.exception.ParqueaderoException;
import parqueadero.repository.BitacoraIngresoRepository;
import parqueadero.servicios.IngresoVehiculoServicio;

public class IngresoVehiculosImpl implements IngresoVehiculoServicio {

	@Autowired
	BitacoraIngresoRepository repository;

	@Override
	public void registrarIngresoAutomovil(Automovil automovil) throws ParqueaderoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarIngresoMotocicleta(Motocicleta motocicleta) throws ParqueaderoException {
		// TODO Auto-generated method stub
		
	}

}
