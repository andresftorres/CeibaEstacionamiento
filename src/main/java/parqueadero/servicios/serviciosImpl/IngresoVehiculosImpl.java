package parqueadero.servicios.serviciosimpl;

import org.springframework.beans.factory.annotation.Autowired;

import parqueadero.dominio.Vehiculo;
import parqueadero.exception.ParqueaderoException;
import parqueadero.repository.BitacoraIngresoRepository;
import parqueadero.servicios.IngresoVehiculoServicio;

public class IngresoVehiculosImpl implements IngresoVehiculoServicio {

	@Autowired
	BitacoraIngresoRepository repository;

	@Override
	public void ingresoVehiculo(Vehiculo vehiculo) throws ParqueaderoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disponibilidadCupoIngreso(String configTarifas) throws ParqueaderoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void autorizaPlacaDiaActual(String placaVehiculo) throws ParqueaderoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vehiculoEnParqueadero(String placaVehiculo) throws ParqueaderoException {
		// TODO Auto-generated method stub
		
	}

}
