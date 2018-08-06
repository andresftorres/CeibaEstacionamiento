package parqueadero.servicios.unitaria;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import parqueadero.entidad.BitacoraSalidaEntity;
import parqueadero.entidad.TipoVehiculo;
import parqueadero.exception.ParqueaderoException;
import parqueadero.servicios.IngresoVehiculoServicio;
import parqueadero.servicios.SalidaVehiculoServicio;
import parqueadero.servicios.serviciosimpl.SalidaVehiculosImpl;

public class ValidacionesSalidaTest {

	private static final String PLACANOAUTORIADA = "ABC-123";
	private static final String PLACAAUTORIZADA = "BCD-123";
	private static final String TIPOVEHICULO = TipoVehiculo.AUTOMOVIL.getCodigo();
	private static final String TIPOVEHICULOBICICLETA = "B";
	private static final int CANTIDAD_MAXIMA_MOTOS = 10;
	private static final double CILINDRAJE = 600;
	private static final String FECHA_SOLICITUD = "2017-05-26";

	@Autowired
	@Qualifier("salidavehiculosservicios")
	SalidaVehiculoServicio salidaVehiculoServicio;
	
	@Test
	public void registrarSalidaDeAutomovil_VehiculoNoEstaEnParqueadero() {
						
		
		
	}
	
}
