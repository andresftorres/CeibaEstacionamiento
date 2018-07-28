package dominio;

public class Vehiculo {

	private String placa;
	private TipoVehiculo tipoVehiculo;
	private double cilindraje;		
	
	public Vehiculo(String placa, TipoVehiculo tipoVehiculo, double cilindraje) {
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
