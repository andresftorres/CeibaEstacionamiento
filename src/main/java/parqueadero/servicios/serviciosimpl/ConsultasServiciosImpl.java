package parqueadero.servicios.serviciosimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parqueadero.builder.BitacoraIngresoBuilder;
import parqueadero.builder.VehiculoBuilder;
import parqueadero.dominio.BitacoraIngreso;
import parqueadero.dominio.ParametrosParqueadero;
import parqueadero.dominio.RespuestaConsulta;
import parqueadero.dominio.Vehiculo;
import parqueadero.entidad.BitacoraIngresoEntity;
import parqueadero.entidad.VehiculoEntity;
import parqueadero.exception.ParqueaderoException;
import parqueadero.repository.BitacoraIngresoRepository;
import parqueadero.repository.VehiculoRepository;
import parqueadero.servicios.ConsultaServicios;

@Service
public class ConsultasServiciosImpl implements ConsultaServicios {

	@Autowired
	BitacoraIngresoRepository bitacoraingresos;

	@Autowired
	VehiculoRepository vehiculoRepo;

	@Autowired
	ConsultaServicios consultaServicios;

	@Override
	public RespuestaConsulta consultaVehiculo(String placa) throws ParqueaderoException {

		BitacoraIngreso bitacoraActiva = bitacoraingresos.bitacoraIngresoByPlaca(placa);		
		String placaVehiculo = bitacoraActiva.getVehiculo().getPlaca();		
		Vehiculo vehiculoEnParquadero = vehiculoRepo.findByPlaca(placaVehiculo);
		
		Vehiculo vehiculoRespuesta;
		if( vehiculoEnParquadero != null ) {
			vehiculoRespuesta = vehiculoEnParquadero;
			
			return crearRespuesta(bitacoraActiva, vehiculoRespuesta);
		} else {
			throw new ParqueaderoException(ParametrosParqueadero.EL_VEHICULO_NO_ESTA_EN_PARQUEADERO);
		}			
	}

	@Override
	public List<RespuestaConsulta> obtenerTodosVehiculos() throws ParqueaderoException {

		List<BitacoraIngresoEntity> bitacorasActivas = bitacoraingresos.findAllBitacorasActivas();

		if (bitacorasActivas.isEmpty()) {
			throw new ParqueaderoException(ParametrosParqueadero.NO_VEHICULOS_ESTACIONADOS);
		} else {

			List<RespuestaConsulta> objetosRespuestaConslta = new ArrayList<>();

			for (BitacoraIngresoEntity bitacoraActual : bitacorasActivas) {
				Long idVehiculo = bitacoraActual.getVehiculo().getId();
				Optional<VehiculoEntity> vehiculoRespuesta = vehiculoRepo.findById(idVehiculo);
				VehiculoEntity vehiculoEntity;

				if (vehiculoRespuesta.isPresent()) {
					vehiculoEntity = vehiculoRespuesta.get();

					objetosRespuestaConslta.add(
							crearRespuesta(
									BitacoraIngresoBuilder.convertirADominio(bitacoraActual), 
									VehiculoBuilder.convertirADominio(vehiculoEntity)
							)
					);
				}
			}
			return objetosRespuestaConslta;
		}
	}

	@Override
	public RespuestaConsulta crearRespuesta(BitacoraIngreso biacoraActiva, Vehiculo vehiculoenParqueadero) {
		return new RespuestaConsulta(vehiculoenParqueadero.getPlaca(),
				vehiculoenParqueadero.getTipoVehiculo().getDescripcion(), biacoraActiva.getFechaIngreso(), null, null);
	}

    
}
