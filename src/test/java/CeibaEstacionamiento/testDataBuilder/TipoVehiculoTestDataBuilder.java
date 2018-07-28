package CeibaEstacionamiento.testDataBuilder;

public class TipoVehiculoTestDataBuilder {
	
	private static final String DESCRIPCION = "AUTOMOVIL";
	private static final boolean USACILINDRAJE = false;
	private static final double CILINDRAJEMAXIMO = (Double) null;
	private static final double VALORHORA = 1000;
	private static final double VALORDIA = 8000;
	private static final double ADICIONALCILINDRAJE = (Double) null;
	private static final int CAPACIDADMXIMA = 20;
	
	private String descripcion;
	private boolean usaCilindraje;
	private double cilindrajeMaximo;
	private double valorHora;
	private double valorDia;
	private double adicionalCilindraje;
	private int capacidadMaxima;
	
	
	public TipoVehiculoTestDataBuilder() {
		
		this.descripcion = DESCRIPCION;
		this.usaCilindraje = USACILINDRAJE;
		this.cilindrajeMaximo = CILINDRAJEMAXIMO;
		this.valorHora = VALORHORA;
		this.valorDia = VALORDIA;
		this.adicionalCilindraje = ADICIONALCILINDRAJE;
		this.capacidadMaxima = CAPACIDADMXIMA;
	}
	
	public TipoVehiculoTestDataBuilder conDescripcion() {
		this.descripcion = DESCRIPCION;
		return this;
	}


	public TipoVehiculoTestDataBuilder conUsaCilindraje() {
		this.usaCilindraje = USACILINDRAJE;
		return this;
	}
	public TipoVehiculoTestDataBuilder conCilindrajeMaximo() {		
		this.cilindrajeMaximo = CILINDRAJEMAXIMO;
		return this;
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
