package parqueadero.testDataBuilder;

import parqueadero.dominio.ConfigTarifas;
import parqueadero.dominio.Vehiculo;

public class VehiculoTestDataBuilder {

	private static final String PLACA = "ABC123";
	private static final ConfigTarifas TarifaConfigurada = new ConfigTarifaTestDataBuilder().build();
	private static final double CILINDRAJE = 1000;	
		
	private String placa;
	private ConfigTarifas configTarifa;
	private double cilindraje;
		
	public VehiculoTestDataBuilder() {
		this.placa = PLACA;
		this.configTarifa = TarifaConfigurada;
		this.cilindraje = CILINDRAJE;
	}
	
	public VehiculoTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this; 
	}	
	public VehiculoTestDataBuilder conConfigTarifa(ConfigTarifas tipoVehiculo) {
		this.configTarifa = tipoVehiculo;
		return this;
	}	
	public VehiculoTestDataBuilder conCilindraje(double cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}	
	public Vehiculo build() {
		return new Vehiculo(this.placa, this.configTarifa, this.cilindraje);
	}
}
