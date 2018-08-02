package parqueadero.dominio;

public class TarifaParqueadero {

	private Long id;
	private String tipoVehiculo;
	private double valorHora;
	private double valorDia;
	private int capacidadMaxima;	
	private boolean tieneCilindraje;
	private double cilindrajeMaximo;
	private double cobroExtraCilindraje;
	
	public TarifaParqueadero(String tipoVehiculo, double valorHora, double valorDia, int capacidadMaxima,
			boolean tieneCilindraje, double cilindrajeMaximo, double cobroExtraCilindraje) {
		super();
		this.tipoVehiculo = tipoVehiculo;
		this.valorHora = valorHora;
		this.valorDia = valorDia;
		this.capacidadMaxima = capacidadMaxima;
		this.tieneCilindraje = tieneCilindraje;
		this.cilindrajeMaximo = cilindrajeMaximo;
		this.cobroExtraCilindraje = cobroExtraCilindraje;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
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
	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}
	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}
	public boolean getTieneCilindraje() {
		return tieneCilindraje;
	}
	public void setTieneCilindraje(boolean tieneCilindraje) {
		this.tieneCilindraje = tieneCilindraje;
	}
	public double getCilindrajeMaximo() {
		return cilindrajeMaximo;
	}
	public void setCilindrajeMaximo(double cilindrajeMaximo) {
		this.cilindrajeMaximo = cilindrajeMaximo;
	}
	public double getCobroExtraCilindraje() {
		return cobroExtraCilindraje;
	}
	public void setCobroExtraCilindraje(double cobroExtraCilindraje) {
		this.cobroExtraCilindraje = cobroExtraCilindraje;
	}
	
	
}
