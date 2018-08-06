package parqueadero.servicios.unitaria;

import static org.junit.Assert.fail;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import parqueadero.dominio.Automovil;
import parqueadero.dominio.BitacoraIngreso;
import parqueadero.dominio.ParametrosParqueadero;
import parqueadero.entidad.BitacoraIngresoEntity;
import parqueadero.entidad.TipoVehiculo;
import parqueadero.servicios.IngresoVehiculoServicio;

public class IngresoVehiculosTest {
	
	private static final String PLACANOAUTORIADA = "ABC-123";	
	private static final String TIPOVEHICULO = TipoVehiculo.AUTOMOVIL.getCodigo();
	
	@Autowired
	IngresoVehiculoServicio ingresoService;	

	@Test
	public void registrarIngresoAutomovil_PlacaNoAutorizada() {

		// arrange
		Automovil automovil = new Automovil(PLACANOAUTORIADA, TIPOVEHICULO);
		
		// act
		try {
			ingresoService.registrarIngresoAutomovil(automovil, Calendar.getInstance());
			fail();

		} catch (Throwable ex) {
			// assert
			Assert.assertNotEquals(ParametrosParqueadero.VEHICULO_NO_AUTORIZADO, ex.getMessage());
		}

	}

	
}
