package parqueadero.dominio;

import java.util.Calendar;

public class Bitacora {

	private Long id;
	private Long idVehiculo;
	private Calendar fechaIngreso;
	
	public Bitacora(Long idVehiculo, Calendar fechaIngreso) {
		super();
		this.idVehiculo = idVehiculo;
		this.fechaIngreso = fechaIngreso;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	 
}
