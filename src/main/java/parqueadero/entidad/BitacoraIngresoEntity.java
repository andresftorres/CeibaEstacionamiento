package parqueadero.entidad;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import parqueadero.dominio.Vehiculo;

@Entity(name = "BitacoraIngreso")
public class BitacoraIngresoEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BITACORA_INGRESO", nullable = false)
	private Long id;

	@JoinColumn(name = "ID_VEHICULO", nullable = false)
	@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
	@JsonIdentityReference(alwaysAsId=true)
	@JsonProperty("vehiculo")
	private Vehiculo vehiculo;

	@Column(name = "FECHA_INGRESO", nullable = false)
	private Calendar fechaIngreso;
	
	@Column(name = "EN_PARQUEADERO", nullable = false)
	private boolean enPaqueadero;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
