package parqueadero.servicios.serviciosImpl;

import org.springframework.beans.factory.annotation.Autowired;

import parqueadero.dominio.ConfigTarifas;
import parqueadero.dominio.Vehiculo;
import parqueadero.exception.ParqueaderoException;
import parqueadero.repository.BitacoraIngresoRepository;
import parqueadero.servicios.IngresoVehiculoServicio; 

public class IngresoVehiculosImpl implements IngresoVehiculoServicio{

	@Autowired
	BitacoraIngresoRepository repository;

	@Override
	public boolean ingresoVehiculo(Vehiculo vehiculo) throws ParqueaderoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean disponibilidadCupoIngreso(ConfigTarifas configTarifas) throws ParqueaderoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean autorizaPlacaDiaActual(String placaVehiculo) throws ParqueaderoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean vehiculoEnParqueadero(String placaVehiculo) throws ParqueaderoException {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
