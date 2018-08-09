package parqueadero.servicios.serviciosimpl;

import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parqueadero.builder.VehiculoBuilder;
import parqueadero.dominio.ParametrosParqueadero;
import parqueadero.dominio.RespuestaPeticion;
import parqueadero.dominio.Vehiculo;
import parqueadero.entidad.BitacoraIngresoEntity;
import parqueadero.entidad.VehiculoEntity;
import parqueadero.exception.ParqueaderoException;
import parqueadero.repository.BitacoraIngresoRepository;
import parqueadero.repository.VehiculoRepository;
import parqueadero.servicios.IngresoVehiculoServicio;
import parqueadero.servicios.ValidacionesServicios;

@Service
public class IngresoVehiculosImpl implements IngresoVehiculoServicio {	

	private static final boolean ENPARQUEADERO = true;
	
	@Autowired
	BitacoraIngresoRepository bitacoraIngresoRepo;
	
	@Autowired	
	VehiculoRepository vehiculoRepo;
		
	@Autowired
	ValidacionesServicios validacionesServicios;

	@Override
	public RespuestaPeticion registrarIngresoVehiculo(Vehiculo vehiculo, Calendar fechaIngreso) throws ParqueaderoException {
		
		if( !validacionesServicios.autorizaPlacaDiaActual(vehiculo.getPlaca(), fechaIngreso)) {
			throw new ParqueaderoException(ParametrosParqueadero.VEHICULO_NO_AUTORIZADO);
		}
		
		if( ! validacionesServicios.validarTipoDeVehiculo(vehiculo.getTipoVehiculo()) ) {
			throw new ParqueaderoException(ParametrosParqueadero.TIPO_DE_VEHICULO_NO_AUTORIZADO);
		}
		
		if( validacionesServicios.vehiculoEnParqueadero(vehiculo.getPlaca()) )  {
			throw new ParqueaderoException(ParametrosParqueadero.EL_VEHICULO_YA_ESTA_EN_EL_PARQUEADERO);
		}
		
		if( !validacionesServicios.disponibilidadVehiculo(vehiculo.getTipoVehiculo()) ) {
			throw new ParqueaderoException(ParametrosParqueadero.SIN_CUPO_PARA_VEHICULO);
		}
				
		VehiculoEntity vehiculoAIngresar = vehiculoRepo.findByPlaca(vehiculo.getPlaca());
		
		VehiculoEntity vehiculoRegistrado;
		if( vehiculoAIngresar == null) {		
		
			vehiculoAIngresar = VehiculoBuilder.convertirAEntity(vehiculo);		
			vehiculoRegistrado = vehiculoRepo.save( vehiculoAIngresar);			
		} else {
			vehiculoRegistrado = vehiculoAIngresar;
		}		
		
		BitacoraIngresoEntity bitacoraIngresoEntity = new BitacoraIngresoEntity(
				vehiculoRegistrado, 
				fechaIngreso,
				ENPARQUEADERO
		);
		bitacoraIngresoRepo.save( bitacoraIngresoEntity);
		return new RespuestaPeticion("", ParametrosParqueadero.REGISTRO_EXITOSO);
		
	}

	@Override
	public BitacoraIngresoEntity consultaIngresoActivo(String placa) {

		return bitacoraIngresoRepo.bitacoraIngresoByPlaca(placa);
		
	}

}
