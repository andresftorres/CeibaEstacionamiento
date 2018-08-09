package parqueadero.servicios.serviciosimpl;


import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parqueadero.dominio.ParametrosParqueadero;
import parqueadero.dominio.RespuestaPeticion;
import parqueadero.entidad.BitacoraIngresoEntity;
import parqueadero.entidad.BitacoraSalidaEntity;
import parqueadero.entidad.VehiculoEntity;
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
		
		VehiculoEntity vehiculo = vehiculoRepo.findByPlaca(placa);		
		
		if( !validacionesServicios.vehiculoEnParqueadero(vehiculo.getPlaca()) )  {
			throw new ParqueaderoException(ParametrosParqueadero.EL_VEHICULO_NO_ESTA_EN_EL_PARQUEADERO);
		}					
		
		BitacoraIngresoEntity bitacoraIngreso = ingresoVehiculoServicio.consultaIngresoActivo(vehiculo.getPlaca());	
		bitacoraIngreso.setEnPaqueadero(NO_ESTA_EN_PARQUEADERO);
		
		BitacoraIngresoEntity biacoraIngresoEntity = bitacoraIngresoRepo.save(bitacoraIngreso);
		
		Calendar fechaSalida = Calendar.getInstance();		
		
	    ConstantesTipoVehiculo configuracionVehiculo = FactoryRestriccionesTarifas.obtenerDatosConfiguracion( vehiculo.getTipoVehiculo());    
		    
		double valorTotal = calcularValorAPagar( 
				biacoraIngresoEntity.getFechaIngreso(), 
				fechaSalida, 
				configuracionVehiculo,
				vehiculo.getCilindraje()
		);		
		
		BitacoraSalidaEntity bitacoraSalidaEntity = new BitacoraSalidaEntity(
				vehiculo, 
				bitacoraIngreso.getFechaIngreso(), 
				fechaSalida, 
				valorTotal);	
		 
		bitacoraSalidaRepo.save(bitacoraSalidaEntity);
		return new RespuestaPeticion("", ParametrosParqueadero.SALIDA_REGISTRADA_EXITOSAMENTE);
	}	
	
	public double calcularValorAPagar(Calendar fechaIngreso, Calendar fechaSalida, ConstantesTipoVehiculo constantesVehiculo, double cilindraje){
		
		double valor;
		double totalHorasEnParqueadero;
		
		totalHorasEnParqueadero = horasEnParqueadero(fechaIngreso.getTime(), fechaSalida.getTime() );		
		
		valor = valorXCobrar(totalHorasEnParqueadero, constantesVehiculo.obtenerValorHora(), constantesVehiculo.obtenerValorDia());
		
		if ( constantesVehiculo.cilidrageMaximo() > 0 && cilindraje > constantesVehiculo.cilidrageMaximo()) {
			valor = valor + constantesVehiculo.cobroPorCilindraje();
		}		
		return valor;
		
	}
	
	private double horasEnParqueadero(Date fechaingreso, Date fechaSalida) {
		
		return TimeUnit.HOURS.convert(Math.abs(fechaSalida.getTime() - fechaingreso.getTime()), TimeUnit.MILLISECONDS) ;
		
	}
	
	private double valorXCobrar (double horas,double valorHora,  double valorDia) {		
		
		double dias = horas / ParametrosParqueadero.TOTAL_HORAS_DIA;
		
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
