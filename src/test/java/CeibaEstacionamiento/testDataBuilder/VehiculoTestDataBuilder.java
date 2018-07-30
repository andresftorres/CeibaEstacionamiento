package CeibaEstacionamiento.testDataBuilder;

import dominio.TipoVehiculo;
import dominio.Vehiculo;

public class VehiculoTestDataBuilder {

	private static final String PLACA = "ABC123";
	private static final TipoVehiculo TIPOVEHICULO = new TipoVehiculoTestDataBuilder().build();
	private static final double CILINDRAJE = 1000;	
		
	private String placa;
	private TipoVehiculo tipoVehiculo;
	private double cilindraje;
		
	public VehiculoTestDataBuilder() {
		this.placa = PLACA;
		this.tipoVehiculo = TIPOVEHICULO;
		this.cilindraje = CILINDRAJE;
	}
	
	public VehiculoTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this; 
	}	
	public VehiculoTestDataBuilder conTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
		return this;
	}	
	public VehiculoTestDataBuilder conCilindraje(double cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}	
	public Vehiculo build() {
		return new Vehiculo(this.placa, this.tipoVehiculo, this.cilindraje);
	}
}
