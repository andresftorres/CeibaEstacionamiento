package parqueadero.testDataBuilder;

import parqueadero.dominio.Motocicleta;
import parqueadero.entidad.TipoVehiculo;

public class MotocicletaTestDataBuilder {

	private static final String PLACA = "ABC123";
	private static final String TIPOVEHICULO = TipoVehiculo.MOTOCICLETA.getCodigo();
	private static final double CILINDRAJE = 1000;
	

	private String placa;
	private String tipoVehiculo;
	private double cilindraje;
	
	public MotocicletaTestDataBuilder() {
		super();
		this.placa = PLACA;
		this.tipoVehiculo = TIPOVEHICULO;
		this.cilindraje = CILINDRAJE;
	}	
	
	public MotocicletaTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public MotocicletaTestDataBuilder conTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
		return this;
	}
	public MotocicletaTestDataBuilder conCilindraje(double cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public Motocicleta build() {
		return new Motocicleta(this.placa, this.tipoVehiculo, this.cilindraje);
	}
	
	
}

