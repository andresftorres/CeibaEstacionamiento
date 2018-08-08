package parqueadero.testDataBuilder;

import java.util.Calendar;
import parqueadero.dominio.BitacoraSalida;
import parqueadero.dominio.Vehiculo;

public class BitacoraSalidaTestDataBuilder {

	private static final Long ID = 1L;
	private static final Vehiculo VEHICULO_MOTOCICLETA = new VehiculoTestDataBuilder().build();
	private static final Calendar FECHAINGRESO = Calendar.getInstance();
	private static final Calendar FECHASALIDA = Calendar.getInstance();
	private static final double VALORTOTAL = 8000;
	
	private Long id;
	private Vehiculo vehiculo;
	private Calendar fechaIngreso;
	private Calendar fechaSalida;
	private double valorTotal;
	
	public BitacoraSalidaTestDataBuilder() {
		super();
		this.vehiculo = VEHICULO_MOTOCICLETA;
		this.fechaIngreso = FECHAINGRESO;
		this.fechaSalida = FECHASALIDA;
		this.valorTotal = VALORTOTAL;
	}	
	
	public BitacoraSalidaTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}
	
	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}
	
	public BitacoraSalidaTestDataBuilder conVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		return this;
	}
	
	public BitacoraSalidaTestDataBuilder conFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}	
	
	public BitacoraSalidaTestDataBuilder conFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
		return this;
	}
	
	public BitacoraSalidaTestDataBuilder conValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
		return this;
	}
	
	public BitacoraSalida build() {
		return new BitacoraSalida(this.vehiculo, this.fechaIngreso, this.fechaSalida, this.valorTotal);
	}
		
}
