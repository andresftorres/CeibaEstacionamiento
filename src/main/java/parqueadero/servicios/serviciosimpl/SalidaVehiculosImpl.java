package parqueadero.servicios.serviciosimpl;


import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parqueadero.builder.BitacoraIngresoBuilder;
import parqueadero.builder.VehiculoBuilder;
import parqueadero.dominio.BitacoraIngreso;
import parqueadero.dominio.ParametrosParqueadero;
import parqueadero.dominio.RespuestaPeticion;
import parqueadero.dominio.Vehiculo;
import parqueadero.entidad.BitacoraIngresoEntity;
import parqueadero.entidad.BitacoraSalidaEntity;
import parqueadero.exception.ParqueaderoException;
import parqueadero.factorypattern.ConstantesTipoVehiculo;
import parqueadero.factorypattern.FactoryRestriccionesTarifas;
import parqueadero.repository.BitacoraIngresoRepository;
import parqueadero.repository.BitacoraSalidaRepository;
import parqueadero.repository.VehiculoRepository;
import parqueadero.servicios.IngresoVehiculoServicio;
import parqueadero.servicios.SalidaVehiculoServicio;
import parqueadero.servicios.ValidacionesServicios;

@Service
public class SalidaVehiculosImpl implements SalidaVehiculoServicio {

	public static final double HORA_EN_MILISEGUNDOS = (1000 * 60 * 60);
	public static final double NO_USA_CILINDRAJE = 0;
	public static final Long IDLONG = 1L;
	public static final boolean NO_ESTA_EN_PARQUEADERO = false;
	
	@Autowired
	BitacoraSalidaRepository bitacoraSalidaRepo;

	@Autowired
	BitacoraIngresoRepository bitacoraIngresoRepo;
	
	@Autowired
	VehiculoRepository vehiculoRepo;
		
	@Autowired
	ValidacionesServicios validacionesServicios;
	
	@Autowired
	IngresoVehiculoServicio ingresoVehiculoServicio;
		
	@Override
	public RespuestaPeticion registrarSalidaDeVehiculo(String placa) throws ParqueaderoException {
		
		Vehiculo vehiculo = vehiculoRepo.findByPlaca(placa);		
		
		if( !validacionesServicios.vehiculoEnParqueadero(vehiculo.getPlaca()) )  {
			throw new ParqueaderoException(ParametrosParqueadero.EL_VEHICULO_NO_ESTA_EN_EL_PARQUEADERO);
		}					
		
		BitacoraIngreso bitacoraIngreso = ingresoVehiculoServicio.consultaIngresoActivo(vehiculo.getPlaca());	
		bitacoraIngreso.setEnPaqueadero(NO_ESTA_EN_PARQUEADERO);		
		
		BitacoraIngresoEntity biacoraIngresoEntity = bitacoraIngresoRepo.save(BitacoraIngresoBuilder.convertirAEntity(bitacoraIngreso));
		
		Calendar fechaSalida = Calendar.getInstance();		
		
	    ConstantesTipoVehiculo configuracionVehiculo = FactoryRestriccionesTarifas.obtenerDatosConfiguracion( vehiculo.getTipoVehiculo());    
		    
		double valorTotal = calcularValorAPagar( 
				biacoraIngresoEntity, 
				fechaSalida, 
				configuracionVehiculo,
				vehiculo.getCilindraje()
		);		
		
		BitacoraSalidaEntity bitacoraSalidaEntity = new BitacoraSalidaEntity(
				VehiculoBuilder.convertirAEntity(vehiculo), 
				bitacoraIngreso.getFechaIngreso(), 
				fechaSalida, 
				valorTotal);	
		 
		return new RespuestaPeticion(bitacoraSalidaRepo.save(bitacoraSalidaEntity).getId().toString(), ParametrosParqueadero.SALIDA_REGISTRADA_EXITOSAMENTE);
	}	
	
	private double calcularValorAPagar(BitacoraIngresoEntity bitacoraIngresoEntity, Calendar fechaSalida, ConstantesTipoVehiculo constantesVehiculo, double cilindraje){
		
		double valor;
		double totalHorasEnParqueadero;
		
		totalHorasEnParqueadero = horasEnParqueadero(bitacoraIngresoEntity.getFechaIngreso(), fechaSalida );		
		
		valor = valorXCobrar(totalHorasEnParqueadero, constantesVehiculo.obtenerValorHora(), constantesVehiculo.obtenerValorDia());
		
		if ( constantesVehiculo.cilidrageMaximo() > 0 && cilindraje > constantesVehiculo.cilidrageMaximo()) {
			valor = valor + constantesVehiculo.cobroPorCilindraje();
		}		
		return valor;
		
	}
	
	private double horasEnParqueadero(Calendar fechaingreso, Calendar fechaSalida) {
		
		return (fechaSalida.getTimeInMillis() - fechaingreso.getTimeInMillis()) / HORA_EN_MILISEGUNDOS;
		
	}
	
	private double valorXCobrar (double horas,double valorHora,  double valorDia) {		
		
		double dias = horas / ParametrosParqueadero.HORAS_INICIO_DIA;
		
		double valor = Math.floor(dias) * valorDia;
		
		//horas
		horas = horas % ParametrosParqueadero.TOTAL_HORAS_DIA;
		
		//Horas y la fraccion		
		double fraccion = Math.floor(horas) + Math.ceil(horas % 1);
		
		if (fraccion >= ParametrosParqueadero.HORAS_INICIO_DIA) {
			valor += valorDia;
			return valor;
		} else {
			valor += (horas * valorHora);
			return valor;
		}
		
	}
	
	
	
	
	
	

}
