package parqueadero.servicios.serviciosimpl;


import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import parqueadero.dominio.ParametrosParqueadero;
import parqueadero.entidad.AutomovilEntity;
import parqueadero.entidad.BitacoraIngresoEntity;
import parqueadero.entidad.BitacoraSalidaEntity;
import parqueadero.entidad.MotocicletaEntity;
import parqueadero.entidad.TarifaParqueaderoEntity;
import parqueadero.exception.ParqueaderoException;
import parqueadero.repository.AutomovilRepository;
import parqueadero.repository.BitacoraIngresoRepository;
import parqueadero.repository.BitacoraSalidaRepository;
import parqueadero.repository.MotocicletaRepository;
import parqueadero.repository.TarifaRepository;
import parqueadero.servicios.IngresoVehiculoServicio;
import parqueadero.servicios.SalidaVehiculoServicio;
import parqueadero.servicios.ValidacionesServicios;

@Service
public class SalidaVehiculosImpl implements SalidaVehiculoServicio {

	public static final double HORA_EN_MILISEGUNDOS = (1000 * 60 * 60);
	public static final double NO_USA_CILINDRAJE = 0;
	public static final boolean NO_ESTA_EN_PARQUEADERO = false;
	
	@Autowired
	BitacoraSalidaRepository bitacoraSalidaRepo;

	@Autowired
	BitacoraIngresoRepository bitacoraIngresoRepo;
	
	@Autowired
	MotocicletaRepository mototcicletaRepo;
	
	@Autowired
	AutomovilRepository automovilRepo;
	
	@Autowired
	TarifaRepository tarifaRepo;
	
	@Autowired
	ValidacionesServicios validacionesServicios;
	
	@Autowired
	IngresoVehiculoServicio ingresoVehiculoServicio;
	

	@Override
	public BitacoraSalidaEntity registrarSalidaDeAutomovil(String placa) throws ParqueaderoException {
		
		AutomovilEntity automovilEntity = automovilRepo.findByPlaca(placa);
		
		if( !validacionesServicios.autorizaPlacaDiaActual(automovilEntity.getPlaca(), Calendar.getInstance())) {
			throw new ParqueaderoException(ParametrosParqueadero.VEHICULO_NO_AUTORIZADO);
		}
		
		if( ! validacionesServicios.validarTipoDeVehiculo(automovilEntity.getTipoVehiculo()) ) {
			throw new ParqueaderoException(ParametrosParqueadero.TIPO_DE_VEHICULO_NO_AUTORIADO);
		}
		
		if( !validacionesServicios.automovilEnParqueadero(automovilEntity.getPlaca()) )  {
			throw new ParqueaderoException(ParametrosParqueadero.EL_VEHICULO_NO_ESTA_EN_EL_PARQUEADERO);
		}	
		
		BitacoraIngresoEntity bitacoraIngresoEntity = ingresoVehiculoServicio.consultaIngresoActivo(automovilEntity.getPlaca());	
		
		bitacoraIngresoRepo.save(bitacoraIngresoEntity);
		
		Calendar fechaSalida = Calendar.getInstance();		
		TarifaParqueaderoEntity tarifaParqueaderoEntity = tarifaRepo.obtenerTarifaPorTipo(automovilEntity.getTipoVehiculo());
		
		double valorTotal = calcularValorAPagar( 
				bitacoraIngresoEntity, 
				fechaSalida, 
				tarifaParqueaderoEntity,
				NO_USA_CILINDRAJE
		);		
		
		BitacoraSalidaEntity bitacoraSalidaEntity = new BitacoraSalidaEntity(
				automovilEntity.getId(), 
				bitacoraIngresoEntity.getFechaIngreso(), 
				fechaSalida, 
				valorTotal);
		
		bitacoraSalidaRepo.save(bitacoraSalidaEntity);
		
		return bitacoraSalidaEntity;
	}

	@Override
	public BitacoraSalidaEntity registrarSalidaDeMotocicleta(String placa) throws ParqueaderoException {
		
		MotocicletaEntity motocicletaEntity = mototcicletaRepo.findByPlaca(placa);
		
		if( !validacionesServicios.autorizaPlacaDiaActual(motocicletaEntity.getPlaca(), Calendar.getInstance())) {
			throw new ParqueaderoException(ParametrosParqueadero.VEHICULO_NO_AUTORIZADO);
		}
		
		if( ! validacionesServicios.validarTipoDeVehiculo(motocicletaEntity.getTipoVehiculo()) ) {
			throw new ParqueaderoException(ParametrosParqueadero.TIPO_DE_VEHICULO_NO_AUTORIADO);
		}
		
		if( !validacionesServicios.motocicletaEnParqueadero(motocicletaEntity.getPlaca()) )  {
			throw new ParqueaderoException(ParametrosParqueadero.EL_VEHICULO_NO_ESTA_EN_EL_PARQUEADERO);
		}					
		
		BitacoraIngresoEntity bitacoraIngresoEntity = ingresoVehiculoServicio.consultaIngresoActivo(motocicletaEntity.getPlaca());	
		bitacoraIngresoEntity.setEnPaqueadero(NO_ESTA_EN_PARQUEADERO);
		
		bitacoraIngresoRepo.save(bitacoraIngresoEntity);
		
		Calendar fechaSalida = Calendar.getInstance();		
		TarifaParqueaderoEntity tarifaParqueaderoEntity = tarifaRepo.obtenerTarifaPorTipo(motocicletaEntity.getTipoVehiculo());
		
		double valorTotal = calcularValorAPagar( 
				bitacoraIngresoEntity, 
				fechaSalida, 
				tarifaParqueaderoEntity,
				motocicletaEntity.getCilindraje()
		);		
		
		BitacoraSalidaEntity bitacoraSalidaEntity = new BitacoraSalidaEntity(
				motocicletaEntity.getId(), 
				bitacoraIngresoEntity.getFechaIngreso(), 
				fechaSalida, 
				valorTotal);
		
		bitacoraSalidaRepo.save(bitacoraSalidaEntity);
		
		return bitacoraSalidaEntity;
	}	
	
	private double calcularValorAPagar(BitacoraIngresoEntity bitacoraIngresoEntity, Calendar fechaSalida, TarifaParqueaderoEntity tarifaParqueaderoEntity, double cilindraje){
		
		double valor;
		double totalHorasEnParqueadero;
		
		totalHorasEnParqueadero = horasEnParqueadero(bitacoraIngresoEntity.getFechaIngreso(), fechaSalida );		
		
		valor = valorXCobrar(totalHorasEnParqueadero, tarifaParqueaderoEntity.getValorHora(), tarifaParqueaderoEntity.getValorDia());
		
		if ( tarifaParqueaderoEntity.isUsaCilindraje() && cilindraje > tarifaParqueaderoEntity.getCilindrajeMaximo()) {
			valor = valor + tarifaParqueaderoEntity.getAdicionalCilindraje();
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
