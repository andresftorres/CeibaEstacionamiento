package parqueadero.entidad;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name = "bitacoraingreso")
public class BitacoraIngresoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BITACORA_INGRESO", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_VEHICULO", nullable = false)
	@JsonProperty("idVehiculo")
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
	@JsonIdentityReference(alwaysAsId=true)	
	private VehiculoEntity vehiculo;

	@Column(name = "FECHA_INGRESO", nullable = false)
	private Calendar fechaIngreso;

	@Column(name = "ENPARQUEADERO", nullable = false)
	private boolean enPaqueadero;

	public BitacoraIngresoEntity(){
		
	}

	public BitacoraIngresoEntity(VehiculoEntity vehiculo, Calendar fechaIngreso, boolean enPaqueadero) {
		super();
		this.vehiculo = vehiculo;
		this.fechaIngreso = fechaIngreso;
		this.enPaqueadero = enPaqueadero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VehiculoEntity getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(VehiculoEntity vehiculo) {
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
