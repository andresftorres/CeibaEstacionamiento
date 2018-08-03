package parqueadero.servicios;

import parqueadero.exception.ParqueaderoException;

public interface SalidaVehiculoServicio {

	public void registrarSalidaDeVehiculos(Long idVehiculo) throws ParqueaderoException;	


}
