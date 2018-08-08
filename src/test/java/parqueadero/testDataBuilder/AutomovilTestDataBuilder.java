package parqueadero.testDataBuilder;


import parqueadero.dominio.Vehiculo;
import parqueadero.entidad.TipoVehiculo;

public class AutomovilTestDataBuilder {

	private static final String PLACA = "ABC123";
	private static final TipoVehiculo TIPOVEHICULO = TipoVehiculo.AUTOMOVIL;

	private String placa;
	private TipoVehiculo tipoVehiculo;
	
	public AutomovilTestDataBuilder() {
		super();
		this.placa = PLACA;
		this.tipoVehiculo = TIPOVEHICULO;
	}
	
	
	public AutomovilTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public AutomovilTestDataBuilder conTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
		return this;
	}
	
	public Vehiculo build() {
		return new Vehiculo(this.placa, this.tipoVehiculo, Double.NaN);
	}
}
	