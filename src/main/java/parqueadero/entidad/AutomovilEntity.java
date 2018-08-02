package parqueadero.entidad;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Automovil")
public class AutomovilEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VEHICULO", nullable = false)
	private long id;

	@Basic
	private String placa;

	@Column(name = "TIPOVEHICULO", nullable = false)
	private String tipoVehiculo;

	public AutomovilEntity(long id, String placa, String tipoVehiculo) {
		this.id = id;
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
	}

}
