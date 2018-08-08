package parqueadero.dominio;

import parqueadero.entidad.TipoVehiculo;

public class Vehiculo {

	private String placa;
	private TipoVehiculo tipoVehiculo;
	private double cilindraje;	
	
	public Vehiculo() {
		
	}

	public Vehiculo(String placa, TipoVehiculo tipoVehiculo, double cilindraje) {
		super();
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
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