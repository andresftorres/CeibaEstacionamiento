package parqueadero.entidad;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import parqueadero.dominio.Vehiculo;

@Entity(name = "ConfigTarifas")
public class ConfigTarifasEntity {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_CONFIG_TARIFA", nullable = false)
	private long id;
	
	@Basic
	private String descripcion;
	
	@Basic
	private boolean usaCilindraje;
	
	@Column(name = "cilindrajeMaximo", nullable = true)
	private double cilindrajeMaximo;
	
	@Basic
	private double valorHora;
	
	@Basic
	private double valorDia;
	
	@Column(name = "adicionalCilindraje", nullable = true)
	private double adicionalCilindraje;
	
	@Basic
	private int capacidadMaxima;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean getUsaCilindraje() {
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
	public double getAdicionalCilindraje() {
		return adicionalCilindraje;
	}
	public void setAdicionalCilindraje(double adicionalCilindraje) {
		this.adicionalCilindraje = adicionalCilindraje;
	}
	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}
	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}
	
	
	
	
}
