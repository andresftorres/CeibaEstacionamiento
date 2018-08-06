package parqueadero.servicios;

import parqueadero.entidad.BitacoraSalidaEntity;
import parqueadero.exception.ParqueaderoException;

public interface SalidaVehiculoServicio {

	public BitacoraSalidaEntity registrarSalidaDeAutomovil(String placa) throws ParqueaderoException;
	
	public BitacoraSalidaEntity registrarSalidaDeMotocicleta(String placa) throws ParqueaderoException;

}
