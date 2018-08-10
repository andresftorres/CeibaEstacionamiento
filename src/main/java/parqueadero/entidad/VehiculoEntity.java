package parqueadero.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "vehiculo")
public class VehiculoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VEHICULO", nullable = false)
	private long id;	
	
	private String placa;
	
	@Column(name = "TIPOVEHICULO", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoVehiculo tipoVehiculo;

	@Column(name = "CILINDRAJE", nullable = false)
	private double cilindraje;

	public VehiculoEntity() {
		
	}
	
	public VehiculoEntity(String placa,TipoVehiculo tipoVehiculo, double cilindraje) {
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
	}

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

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public double getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(double cilindraje) {
		this.cilindraje = cilindraje;
	}

	
}
