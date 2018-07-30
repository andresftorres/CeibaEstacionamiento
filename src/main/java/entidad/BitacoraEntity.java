package entidad;

import java.util.Calendar;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import dominio.Vehiculo;

@Entity(name = "Bitacora")
@NamedQuery(name = "Bitacora.findById", query = "SELECT bitacora FROM Bitacora bitacora WHERE bitacora.id = :id")
public class BitacoraEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private Vehiculo vehiculo;

	@Column(nullable = false)
	private Calendar fechaIngreso;

	@Column(nullable = false)
	private Calendar fechaSalida;

	@Column(nullable = false)
	private double valorACobrar;

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

	public Calendar getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public double getValorACobrar() {
		return valorACobrar;
	}

	public void setValorACobrar(double valorACobrar) {
		this.valorACobrar = valorACobrar;
	}
	
	
}
