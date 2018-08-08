package parqueadero.servicios;

import java.util.Calendar;

import parqueadero.entidad.TipoVehiculo;

public interface ValidacionesServicios {

	public boolean validarTipoDeVehiculo(TipoVehiculo tipoVehiculo);
	
	public boolean disponibilidadVehiculo(TipoVehiculo tipoVehiculo);	

	public boolean autorizaPlacaDiaActual(String placaVehiculo, Calendar fechaIngreso);
	
	public boolean vehiculoEnParqueadero(String placaVehiculo);
	
}
