package parqueadero.entidad;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity(name = "bitacorasalida")
public class BitacoraSalidaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BITACORA_SALIDA", nullable = false)
	private Long id;

	
	@ManyToOne
	@JoinColumn(name = "ID_VEHICULO", nullable = false)
	@JsonProperty("idVehiculo")
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
	@JsonIdentityReference(alwaysAsId=true)	
	private VehiculoEntity vehiculo;

	@Column(name = "FECHA_INGRESO", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaIngreso;

	@Column(name = "FECHA_SALIDA", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaSalida;

	@Column(name = "VALOR_TOTAL", nullable = false)
	private double valorTotal;

	public BitacoraSalidaEntity(){
	}	

	public BitacoraSalidaEntity(VehiculoEntity vehiculo, Calendar fechaIngreso, Calendar fechaSalida,
			double valorTotal) {
		super();
		this.vehiculo = vehiculo;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.valorTotal = valorTotal;
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

	public Calendar getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	
}
