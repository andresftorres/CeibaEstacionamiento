package parqueadero.servicios.serviciosimpl;

import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import parqueadero.builder.AutomovilBuilder;
import parqueadero.builder.MotocicletaBuilder;
import parqueadero.dominio.Automovil;
import parqueadero.dominio.Motocicleta;
import parqueadero.dominio.ParametrosParqueadero;
import parqueadero.entidad.AutomovilEntity;
import parqueadero.entidad.BitacoraIngresoEntity;
import parqueadero.entidad.MotocicletaEntity;
import parqueadero.exception.ParqueaderoException;
import parqueadero.repository.AutomovilRepository;
import parqueadero.repository.BitacoraIngresoRepository;
import parqueadero.repository.MotocicletaRepository;
import parqueadero.servicios.IngresoVehiculoServicio;
import parqueadero.servicios.ValidacionesServicios;

@Service
public class IngresoVehiculosImpl implements IngresoVehiculoServicio {	

	private static final boolean ENPARQUEADERO = true;
	
	@Autowired
	BitacoraIngresoRepository bitacoraIngresoRepo;
	
	@Autowired	
	MotocicletaRepository mototcicletaRepo;
	
	@Autowired
	AutomovilRepository automovilRepo;
		
	@Autowired
	ValidacionesServicios validacionesServicios;
	
	@Override
	public BitacoraIngresoEntity registrarIngresoAutomovil(Automovil automovil, Calendar fechaingreso) throws ParqueaderoException {		
		
		if( !validacionesServicios.autorizaPlacaDiaActual(automovil.getPlaca(), fechaingreso)) {
			throw new ParqueaderoException(ParametrosParqueadero.VEHICULO_NO_AUTORIZADO);
		}
		
		if( !validacionesServicios.validarTipoDeVehiculo(automovil.getTipoVehiculo()) ) {
			throw new ParqueaderoException(ParametrosParqueadero.TIPO_DE_VEHICULO_NO_AUTORIADO);
		}
		
		if( validacionesServicios.automovilEnParqueadero(automovil.getPlaca()) )  {
			throw new ParqueaderoException(ParametrosParqueadero.EL_VEHICULO_YA_ESTA_EN_EL_PARQUEADERO);
		}
		
		if( !validacionesServicios.disponibilidadAutomovil() ) {
			throw new ParqueaderoException(ParametrosParqueadero.SIN_CUPO_PARA_AUTOMOVIL);
		}
		
		//Buscar automovil en repositorio por la placa		
		AutomovilEntity automovilEntity = automovilRepo.findByPlaca(automovil.getPlaca());
		
		AutomovilEntity automovilRegistrado;
		if( automovilEntity == null) {		
		
			automovilEntity = AutomovilBuilder.convertirAEntity(automovil);		
			automovilRegistrado = automovilRepo.save(automovilEntity);			
		} else {
			automovilRegistrado = automovilEntity;
		}
		
		BitacoraIngresoEntity bitacoraIngresoEntity = new BitacoraIngresoEntity(
				automovilRegistrado.getId(), 
				fechaingreso,
				ENPARQUEADERO
		);		
		
		return bitacoraIngresoRepo.save(bitacoraIngresoEntity);	
	}

	@Override
	public BitacoraIngresoEntity registrarIngresoMotocicleta(Motocicleta motocicleta, Calendar fechaIngreso) throws ParqueaderoException {
		
		if( !validacionesServicios.autorizaPlacaDiaActual(motocicleta.getPlaca(), fechaIngreso)) {
			throw new ParqueaderoException(ParametrosParqueadero.VEHICULO_NO_AUTORIZADO);
		}
		
		if( ! validacionesServicios.validarTipoDeVehiculo(motocicleta.getTipoVehiculo()) ) {
			throw new ParqueaderoException(ParametrosParqueadero.TIPO_DE_VEHICULO_NO_AUTORIADO);
		}
		
		if( validacionesServicios.motocicletaEnParqueadero(motocicleta.getPlaca()) )  {
			throw new ParqueaderoException(ParametrosParqueadero.EL_VEHICULO_YA_ESTA_EN_EL_PARQUEADERO);
		}
		
		if( !validacionesServicios.disponibilidadMotocicleta() ) {
			throw new ParqueaderoException(ParametrosParqueadero.SIN_CUPO_PARA_MOTOCICLETA);
		}
				
		MotocicletaEntity motocicltalEntity = mototcicletaRepo.findByPlaca(motocicleta.getPlaca());
		
		MotocicletaEntity motocicletaRegistrada;
		if( motocicltalEntity == null) {		
		
			motocicltalEntity = MotocicletaBuilder.convertirAEntity(motocicleta);		
			motocicletaRegistrada = mototcicletaRepo.save(motocicltalEntity);			
		} else {
			motocicletaRegistrada = motocicltalEntity;
		}
		
		
		BitacoraIngresoEntity bitacoraIngresoEntity = new BitacoraIngresoEntity(
				motocicletaRegistrada.getId(), 
				fechaIngreso,
				ENPARQUEADERO
		);		
		
		return bitacoraIngresoRepo.save(bitacoraIngresoEntity);		
	}

	@Override
	public BitacoraIngresoEntity consultaIngresoActivo(String placa) {

		BitacoraIngresoEntity ingresoParqueadero = bitacoraIngresoRepo.bitacoraIngresoAutoByPlaca(placa);
		
		if (ingresoParqueadero.isEnPaqueadero()) {
			return ingresoParqueadero;
		}
		return null;
	}	
}
