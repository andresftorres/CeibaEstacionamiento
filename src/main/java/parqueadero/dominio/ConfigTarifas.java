package parqueadero.dominio;

public class ConfigTarifas {

	private String descripcion;
	private boolean usaCilindraje;
	private double cilindrajeMaximo;
	private double valorHora;
	private double valorDia;
	private double adicionalCilindraje;
	private int capacidadMaxima;
		
	public ConfigTarifas(String descripcion, boolean usaCilindraje, double cilindrajeMaximo, double valorHora,
			double valorDia, double adicionalCilindraje, int capacidadMaxima) {
		this.descripcion = descripcion;
		this.usaCilindraje = usaCilindraje;
		this.cilindrajeMaximo = cilindrajeMaximo;
		this.valorHora = valorHora;
		this.valorDia = valorDia;
		this.adicionalCilindraje = adicionalCilindraje;
		this.capacidadMaxima = capacidadMaxima;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean getUsaCilindraje() {
		return usaCilindraje;
	}
	public void setUsaCilindraje(boolean usaCilindraje) {
		this.usaCilindraje = usaCilindraje;
	}
	public double getCilindrajeMaximo() {
		return cilindrajeMaximo;
	}
	public void setCilindrajeMaximo(double cilindrajeMaximo) {
		this.cilindrajeMaximo = cilindrajeMaximo;
	}
	public double getValorHora() {
		return valorHora;
	}
	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	public double getValorDia() {
		return valorDia;
	}
	public void setValorDia(double valorDia) {
		this.valorDia = valorDia;
	}
	public double getAdicionalCilindraje() {
		return adicionalCilindraje;
	}
	public void setAdicionalCilindraje(double adicionalCilindraje) {
		this.adicionalCilindraje = adicionalCilindraje;
	}
	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}
	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}
		
	
		
	
}
