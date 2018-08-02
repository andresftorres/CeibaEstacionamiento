package parqueadero.dominio;

public class Motocicleta extends Vehiculo {

	private double cilindraje;

	public Motocicleta(String placa, String tipoVehiculo, double cilindraje) {
		super(placa, tipoVehiculo);
		this.cilindraje = cilindraje;
	}

	public double getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(double cilindraje) {
		this.cilindraje = cilindraje;
	}

}
