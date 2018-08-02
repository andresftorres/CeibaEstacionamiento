package parqueadero.testDataBuilder;


import parqueadero.dominio.Automovil;
import parqueadero.entidad.TipoVehiculo;

public class AutomovilTestDataBuilder {

	private static final String PLACA = "ABC123";
	private static final String TIPOVEHICULO = TipoVehiculo.AUTOMOVIL.getCodigo();

	private String placa;
	private String tipoVehiculo;
	
	public AutomovilTestDataBuilder() {
		super();
		this.placa = PLACA;
		this.tipoVehiculo = TIPOVEHICULO;
	}
	
	
	public AutomovilTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public AutomovilTestDataBuilder conTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
		return this;
	}
	
	public Automovil build() {
		return new Automovil(this.placa, this.tipoVehiculo);
	}
}
	