package parqueadero.servicios;

import parqueadero.exception.ParqueaderoException;

import java.util.Calendar;

import parqueadero.dominio.Automovil;
import parqueadero.dominio.Motocicleta;
import parqueadero.entidad.BitacoraIngresoEntity;

public interface IngresoVehiculoServicio {

	public BitacoraIngresoEntity registrarIngresoAutomovil(Automovil automovil, Calendar fechaIngreso) throws ParqueaderoException;
	
	public BitacoraIngresoEntity registrarIngresoMotocicleta(Motocicleta motocicleta, Calendar fechaIngreso) throws ParqueaderoException;

	public BitacoraIngresoEntity consultaIngresoActivo( String placa) throws ParqueaderoException; 
}
