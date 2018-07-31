package parqueadero.dominio;

import java.util.Calendar;

public class BitacoraSalida {

	private Vehiculo vehiculo;
	private Calendar fechaIngreso;	
		
	public BitacoraSalida(Vehiculo vehiculo, Calendar fechaIngreso ) {
		this.vehiculo = vehiculo;
		this.fechaIngreso = fechaIngreso;		
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}		
}
