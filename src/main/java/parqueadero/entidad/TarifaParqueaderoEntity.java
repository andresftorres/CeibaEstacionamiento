package parqueadero.entidad;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Tarifa")
public class TarifaParqueaderoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_CONFIG_TARIFA", nullable = false)
	private long id;

	@Column(name = "TIPO_VEHICULO", nullable = false)
	private String tipoVehiculo;

	@Basic
	private double valorHora;

	@Basic
	private double valorDia;

	@Basic
	private int capacidadMaxima;

	@Basic
	private boolean usaCilindraje;

	@Column(name = "cilindrajeMaximo", nullable = true)
	private double cilindrajeMaximo;

	@Column(name = "adicionalCilindraje", nullable = true)
	private double adicionalCilindraje;

	public TarifaParqueaderoEntity(long id, String tipoVehiculo, double valorHora, double valorDia, int capacidadMaxima,
			boolean usaCilindraje, double cilindrajeMaximo, double adicionalCilindraje) {
		this.id = id;
		this.tipoVehiculo = tipoVehiculo;
		this.valorHora = valorHora;
		this.valorDia = valorDia;
		this.capacidadMaxima = capacidadMaxima;
		this.usaCilindraje = usaCilindraje;
		this.cilindrajeMaximo = cilindrajeMaximo;
		this.adicionalCilindraje = adicionalCilindraje;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public double getValorDia() {
		return valorDia;
	}

	public void setValorDia(double valorDia) {
		this.valorDia = valorDia;
	}

	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public boolean isUsaCilindraje() {
		return usaCilindraje;
	}

	public void setUsaCilindraje(boolean usaCilindraje) {
		this.usaCilindraje = usaCilindraje;
	}

	public double getCilindrajeMaximo() {
		return cilindrajeMaximo;
	}

	public void setCilindrajeMaximo(double cilindrajeMaximo) {
		this.cilindrajeMaximo = cilindrajeMaximo;
	}

	public double getAdicionalCilindraje() {
		return adicionalCilindraje;
	}

	public void setAdicionalCilindraje(double adicionalCilindraje) {
		this.adicionalCilindraje = adicionalCilindraje;
	}

}
