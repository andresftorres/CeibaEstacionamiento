package parqueadero.testDataBuilder;

import java.util.Calendar;

import parqueadero.dominio.BitacoraIngreso;
import parqueadero.dominio.Vehiculo;

public class BitacoraIngresoTestDataBuilder {
	
	private static final Long ID = 1L;
	private static final Vehiculo VEHICULO_MOTOCICLETA = new VehiculoTestDataBuilder().build();
	private static final Calendar FECHAINGRESO = Calendar.getInstance();
	private static final Boolean ENPARQUEADERO = true;
	
	private Long id;
	private Vehiculo vehiculo;
	private Calendar fechaIngreso;
	private boolean enPaqueadero;
	
	public BitacoraIngresoTestDataBuilder() {
		super();
		this.vehiculo = VEHICULO_MOTOCICLETA;
		this.fechaIngreso = FECHAINGRESO;
		this.enPaqueadero = ENPARQUEADERO;
	}	
	
	public BitacoraIngresoTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}
	
	public BitacoraIngresoTestDataBuilder conVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		return this;
	}
	
	public BitacoraIngresoTestDataBuilder conFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}
	
	public BitacoraIngresoTestDataBuilder conEnPaqueadero(boolean enPaqueadero) {
		this.enPaqueadero = enPaqueadero;
		return this;
	}
	
	public BitacoraIngreso build() {
		return new BitacoraIngreso( this.vehiculo, this.fechaIngreso, this.enPaqueadero);
	}
	
}
