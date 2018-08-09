package parqueadero.servicios.unitaria;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import parqueadero.entidad.TipoVehiculo;
import parqueadero.exception.ParqueaderoException;
import parqueadero.factorypattern.ConstantesTipoVehiculo;
import parqueadero.factorypattern.FactoryRestriccionesTarifas;
import parqueadero.servicios.serviciosimpl.SalidaVehiculosImpl;


public class ValidacionesCobroTest {

	
	@Test
	public void calcularValorAPagar_cobroMotocicleta25HorasAltoCilindraje() {
		//arrange
		
		Calendar calIngreso = Calendar.getInstance();	
		calIngreso.set(2018, 8, 7, 1, 0);
		
		Calendar calSalida = Calendar.getInstance();	
		calSalida.set(2018, 8, 8, 2, 0);
		
		ConstantesTipoVehiculo configuracion = null;
		
		try {
			configuracion = FactoryRestriccionesTarifas.obtenerDatosConfiguracion(TipoVehiculo.MOTOCICLETA);
		} catch (ParqueaderoException e) {
			e.printStackTrace();
		}		
		SalidaVehiculosImpl salidaVehiculoServicioimpl = new SalidaVehiculosImpl();
		//act		
		
		double valorACobrar = salidaVehiculoServicioimpl.calcularValorAPagar(calIngreso, calSalida, configuracion, 1000);
			
		//assert
		Assert.assertEquals(6500, valorACobrar, 0.0);		
	}
	
	@Test
	public void calcularValorAPagar_Automovil1Diay3Hoas() {
		//arrange
		
		Calendar calIngreso = Calendar.getInstance();
		
		calIngreso.set(2018, 8, 7, 1, 0);
		
		Calendar calSalida = Calendar.getInstance();
		
		calSalida.set(2018, 8, 8, 4, 0);
		
		ConstantesTipoVehiculo configuracion = null;
		
		try {
			configuracion = FactoryRestriccionesTarifas.obtenerDatosConfiguracion(TipoVehiculo.AUTOMOVIL);
		} catch (ParqueaderoException e) {
			e.printStackTrace();
		}		
		SalidaVehiculosImpl salidaVehiculoServicioimpl = new SalidaVehiculosImpl();
		//act		
		
		double valorACobrar = salidaVehiculoServicioimpl.calcularValorAPagar(calIngreso, calSalida, configuracion, 0);
			
		//assert
		Assert.assertEquals(11000, valorACobrar, 0.0);		
	}
}
