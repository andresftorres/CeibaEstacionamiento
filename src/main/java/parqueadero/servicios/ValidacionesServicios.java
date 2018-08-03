package parqueadero.servicios;

import parqueadero.exception.ParqueaderoException;

public interface ValidacionesServicios {

	public void validarTipoDeVehiculo(String tipoVehiculo) throws ParqueaderoException;
	
	public void disponibilidadMotocicleta(Long idMotocicleta) throws ParqueaderoException;
	
	public void disponibilidadAutomovil(Long idAutomovil) throws ParqueaderoException;

	public void autorizaPlacaDiaActual(String placaVehiculo) throws ParqueaderoException;

	public void vehiculoEnParqueadero(String placaVehiculo) throws ParqueaderoException;
	
}
