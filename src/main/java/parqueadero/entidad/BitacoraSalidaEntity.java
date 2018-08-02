package parqueadero.entidad;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "BitacoraSalida")
public class BitacoraSalidaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BITACORA_SALIDA", nullable = false)
	private Long id;

	@Column(name = "ID_VEHICULO", nullable = false)
	private Long idVehiculo;

	@Column(name = "FECHA_INGRESO", nullable = false)
	private Calendar fechaIngreso;

	@Column(name = "FECHA_SALIDA", nullable = false)
	private Calendar fechaSalida;

	@Column(name = "VALOR_TOTAL", nullable = false)
	private double valorTotal;

	public BitacoraSalidaEntity(Long id, Long idVehiculo, Calendar fechaIngreso, Calendar fechaSalida,
			double valorTotal) {
		super();
		this.id = id;
		this.idVehiculo = idVehiculo;
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
