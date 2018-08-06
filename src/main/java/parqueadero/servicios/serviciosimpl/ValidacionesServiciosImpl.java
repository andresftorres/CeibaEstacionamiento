package parqueadero.servicios.serviciosimpl;


import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import parqueadero.dominio.ParametrosParqueadero;
import parqueadero.entidad.TarifaParqueaderoEntity;
import parqueadero.entidad.TipoVehiculo;
import parqueadero.repository.BitacoraIngresoRepository;
import parqueadero.repository.TarifaRepository;
import parqueadero.servicios.ValidacionesServicios;

@Service("validacionesservicios")
public class ValidacionesServiciosImpl implements ValidacionesServicios{

	@Autowired
	@Qualifier("bitacoraingresorepositorio")
	BitacoraIngresoRepository bitacoraIngresoRepo;
	
	@Autowired
	@Qualifier("tarifarepositorio")
	TarifaRepository tarifaRepo;
	
	
	@Override
	public boolean validarTipoDeVehiculo(String tipoVehiculo) {		
		
		return ParametrosParqueadero.TIPOS_DE_VEHICULOS_PERMITIDOS.contains(tipoVehiculo);
	}

	@Override
	public boolean disponibilidadMotocicleta() {
		String tipoMotocileta = TipoVehiculo.MOTOCICLETA.getCodigo();
		
		Long motocicletasEnParqueadero = bitacoraIngresoRepo.cantidadMotocicletasEnParqueadero();
		
		TarifaParqueaderoEntity tarifaMotociletas = tarifaRepo.obtenerTarifaPorTipo(tipoMotocileta);
		
		return motocicletasEnParqueadero < tarifaMotociletas.getCapacidadMaxima();  
	}

	@Override
	public boolean disponibilidadAutomovil() {
		String tipoAutomovil = TipoVehiculo.AUTOMOVIL.getCodigo();
		
		Long automovilesEnParqueadero = bitacoraIngresoRepo.cantidadAutomovilesEnParqueadero();
		
		TarifaParqueaderoEntity tarifaAutomoviles = tarifaRepo.obtenerTarifaPorTipo(tipoAutomovil);
		
		return automovilesEnParqueadero < tarifaAutomoviles.getCapacidadMaxima(); 
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
	public boolean automovilEnParqueadero(String placaVehiculo) {	
		
		return !bitacoraIngresoRepo.automovilEnParqueadero(placaVehiculo).getPlaca().isEmpty(); 
	}
	
	@Override
	public boolean motocicletaEnParqueadero(String placaVehiculo) {	
		
		return !bitacoraIngresoRepo.motocicletaEnParqueadero(placaVehiculo).getPlaca().isEmpty(); 
	}


	
}
