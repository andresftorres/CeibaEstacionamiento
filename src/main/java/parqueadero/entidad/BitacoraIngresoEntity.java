package parqueadero.entidad;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "BitacoraIngreso")
public class BitacoraIngresoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BITACORA_INGRESO", nullable = false)
	private Long id;

	@Column(name = "ID_VEHICULO", nullable = false)
	private Long idVehiculo;

	@Column(name = "FECHA_INGRESO", nullable = false)
	private Calendar fechaIngreso;

	@Column(name = "EN_PARQUEADERO", nullable = false)
	private boolean enPaqueadero;

	public BitacoraIngresoEntity(Long idVehiculo, Calendar fechaIngreso, boolean enPaqueadero) {
		super();
		this.idVehiculo = idVehiculo;
		this.fechaIngreso = fechaIngreso;
		this.enPaqueadero = enPaqueadero;
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

	public boolean isEnPaqueadero() {
		return enPaqueadero;
	}

	public void setEnPaqueadero(boolean enPaqueadero) {
		this.enPaqueadero = enPaqueadero;
	}

}
