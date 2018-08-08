package parqueadero.dominio;

import java.util.Calendar;

public class Bitacora {
	
	private Vehiculo vehiculo;
	private Calendar fechaIngreso;
	
	public Bitacora(Vehiculo vehiculo, Calendar fechaIngreso) {
		super();
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
