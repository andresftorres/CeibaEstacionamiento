package parqueadero.servicios.serviciosimpl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parqueadero.dominio.Automovil;
import parqueadero.dominio.Motocicleta;
import parqueadero.dominio.ParametrosParqueadero;
import parqueadero.entidad.AutomovilEntity;
import parqueadero.exception.ParqueaderoException;
import parqueadero.repository.BitacoraIngresoRepository;
import parqueadero.repository.MotocicletaRepository;
import parqueadero.repository.TarifaRepository;
import parqueadero.servicios.IngresoVehiculoServicio;
import parqueadero.servicios.ValidacionesServicios;

@Service
public class IngresoVehiculosImpl implements IngresoVehiculoServicio {	

	@Autowired
	BitacoraIngresoRepository bitacoraIngresoRepo;
	
	@Autowired
	MotocicletaRepository mototcicletaRepo;
	
	@Autowired
	TarifaRepository tarifaRepo;
	
	@Autowired
	ValidacionesServicios validacionesServicios;
	
	@Override
	public AutomovilEntity registrarIngresoAutomovil(Automovil automovil) throws ParqueaderoException {		
		
		if( ! validacionesServicios.autorizaPlacaDiaActual(automovil.getPlaca(), Calendar.getInstance())) {
			throw new ParqueaderoException(ParametrosParqueadero.VEHICULO_NO_AUTORIZADO);
		}
		
		if( ! validacionesServicios.validarTipoDeVehiculo(automovil.getTipoVehiculo()) ) {
			throw new ParqueaderoException(ParametrosParqueadero.TIPO_DE_VEHICULO_NO_AUTORIADO);
		}
		
		if( !validacionesServicios.vehiculoEnParqueadero(automovil.getPlaca()) )  {
			throw new ParqueaderoException(ParametrosParqueadero.EL_VEHICULO_NO_ESTA_EN_EL_PARQUEADERO);
		}
		
		if( ! validacionesServicios.disponibilidadAutomovil() ) {
			throw new ParqueaderoException(ParametrosParqueadero.SIN_CUPO_PARA_AUTOMOVIL);
		}
		
		//...
		return null;
			


		
	}

	@Override
	public void registrarIngresoMotocicleta(Motocicleta motocicleta) throws ParqueaderoException {
		// TODO Auto-generated method stub
		
	}

}
