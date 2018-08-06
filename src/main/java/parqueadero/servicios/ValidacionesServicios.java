package parqueadero.servicios;

import java.util.Calendar;

public interface ValidacionesServicios {

	public boolean validarTipoDeVehiculo(String tipoVehiculo);
	
	public boolean disponibilidadMotocicleta();
	
	public boolean disponibilidadAutomovil();

	public boolean autorizaPlacaDiaActual(String placaVehiculo, Calendar fechaIngreso);

	public boolean automovilEnParqueadero(String placaVehiculo);
	
	public boolean motocicletaEnParqueadero(String placaVehiculo);
	
}
