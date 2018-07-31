package parqueadero.dominio;

public class Vehiculo {

	private String placa;
	private ConfigTarifas tarifaAplicada;
	private double cilindraje;		
	
	public Vehiculo(String placa, ConfigTarifas tarifaAplicada, double cilindraje) {
		this.placa = placa;
		this.tarifaAplicada = tarifaAplicada;
		this.cilindraje = cilindraje;
	}
	
	public String getPlaca() {
	 	return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public ConfigTarifas getConfigTarifa() {
		return tarifaAplicada;
	}
	public void setConfigTarifa(ConfigTarifas tarifaAplicada) {
		this.tarifaAplicada = tarifaAplicada;
	}
	public double getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(double cilindraje) {
		this.cilindraje = cilindraje;
	}
	
	
	
}
