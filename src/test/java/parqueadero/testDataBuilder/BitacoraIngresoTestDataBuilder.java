package parqueadero.testDataBuilder;

import java.util.Calendar;

import parqueadero.dominio.BitacoraIngreso;

public class BitacoraIngresoTestDataBuilder {
	
	private static final Long ID = 1L;
	private static final Long IDVEHICULO = 1L;
	private static final Calendar FECHAINGRESO = Calendar.getInstance();
	private static final Boolean ENPARQUEADERO = true;
	
	private Long id;
	private Long idVehiculo;
	private Calendar fechaIngreso;
	private boolean enPaqueadero;
	
	public BitacoraIngresoTestDataBuilder() {
		super();
		this.id = ID;
		this.idVehiculo = IDVEHICULO;
		this.fechaIngreso = FECHAINGRESO;
		this.enPaqueadero = ENPARQUEADERO;
	}	
	
	public BitacoraIngresoTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}
	
	public BitacoraIngresoTestDataBuilder conIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
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
		return new BitacoraIngreso(this.id, this.idVehiculo, this.fechaIngreso, this.enPaqueadero);
	}
	
}
