package parqueadero.servicios.serviciosimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parqueadero.exception.ParqueaderoException;
import parqueadero.repository.BitacoraSalidaRepository;
import parqueadero.servicios.SalidaVehiculoServicio;

@Service
public class SalidaVehiculosImpl implements SalidaVehiculoServicio {

	@Autowired
	BitacoraSalidaRepository salidaRepository;
	
	@Override
	public void registrarSalidaDeVehiculos(Long idVehiculo) throws ParqueaderoException {
		// TODO Auto-generated method stub
		
	}	

}
