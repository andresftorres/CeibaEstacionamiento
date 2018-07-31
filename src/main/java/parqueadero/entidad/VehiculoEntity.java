package parqueadero.entidad;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import parqueadero.dominio.ConfigTarifas;

@Entity(name = "Vehiculo")
public class VehiculoEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VEHICULO", nullable = false)
	private long id;
	
	@Basic
	private String placa;
	

	@JoinColumn(name = "ID_TARIFA_APLICADA", nullable = false)
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
	@JsonIdentityReference(alwaysAsId=true)
	@JsonProperty("tarifaAplicada")
	private ConfigTarifas tarifaAplicada;
	
	@Basic
	private double cilindraje;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public ConfigTarifas getTarifaAplicada() {
		return tarifaAplicada;
	}
	public void setTarifaAplicada(ConfigTarifas tarifaAplicada) {
		this.tarifaAplicada = tarifaAplicada;
	}
	public double getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(double cilindraje) {
		this.cilindraje = cilindraje;
	}	
	
	

}
