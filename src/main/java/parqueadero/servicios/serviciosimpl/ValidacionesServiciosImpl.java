package parqueadero.servicios.serviciosimpl;


import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parqueadero.dominio.ParametrosParqueadero;
import parqueadero.entidad.TipoVehiculo;

import parqueadero.factorypattern.ConstantesTipoVehiculo;
import parqueadero.factorypattern.FactoryRestriccionesTarifas;
import parqueadero.repository.BitacoraIngresoRepository;
import parqueadero.servicios.ValidacionesServicios;

@Service
public class ValidacionesServiciosImpl implements ValidacionesServicios{

	
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidacionesServiciosImpl.class);	
	
	@Autowired
	BitacoraIngresoRepository bitacoraIngresoRepo;	
	
	
	@Override
	public boolean validarTipoDeVehiculo(TipoVehiculo tipoVehiculo) {		
		
		return ParametrosParqueadero.TIPOS_DE_VEHICULOS_PERMITIDOS.contains(tipoVehiculo.getDescripcion());
	}

	@Override
	public boolean disponibilidadVehiculo(TipoVehiculo tipoVehiculo) {
		String tipoVehiculoABuscar = tipoVehiculo.getDescripcion();
		
		Long motocicletasEnParqueadero = bitacoraIngresoRepo.cantidadVehiculosporTipo(tipoVehiculoABuscar);
		
		ConstantesTipoVehiculo configuracionVehiculo;
		try {
			configuracionVehiculo = FactoryRestriccionesTarifas.obtenerDatosConfiguracion(tipoVehiculo);
			return motocicletasEnParqueadero < configuracionVehiculo.capacidadMaxima();			
		} catch (Exception e) {	
			LOGGER.info("ParqueaderoException",e);
			return false;
		}	  
	}
	
	@Override
	public boolean autorizaPlacaDiaActual(String placaVehiculo, Calendar fechaIngreso) {		
		String letraValidar = ParametrosParqueadero.LETRA_PARA_VALIDAR_PLACAS;
		
		if( letraValidar.equals(placaVehiculo.charAt(0)+"") ){			
			Calendar fechaCalendar = Calendar.getInstance();
			
			fechaCalendar.setTime(fechaIngreso.getTime());
			
			int day = fechaCalendar.get(Calendar.DAY_OF_WEEK);			
			
			return day == Calendar.SUNDAY || day == Calendar.MONDAY;	
		}else {
			return true;
		}						
	}

	@Override
	public boolean vehiculoEnParqueadero(String placaVehiculo) {	
		
		return bitacoraIngresoRepo.vehiculoEnParqueadero(placaVehiculo) != null; 
	}


	
}
