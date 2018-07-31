package parqueadero.dominio;

import java.util.Calendar;

public class BitacoraIngreso {

	private Vehiculo vehiculo;
	private Calendar fechaIngreso;
	private boolean enPaqueadero;	
	
	public BitacoraIngreso(Vehiculo vehiculo, Calendar fechaIngreso, boolean enPaqueadero) {
		super();
		this.vehiculo = vehiculo;
		this.fechaIngreso = fechaIngreso;
		this.enPaqueadero = enPaqueadero;
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
	public boolean isEnPaqueadero() {
		return enPaqueadero;
	}
	public void setEnPaqueadero(boolean enPaqueadero) {
		this.enPaqueadero = enPaqueadero;
	}
		
		
	
}
