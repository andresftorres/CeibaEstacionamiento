package CeibaEstacionamiento.testDataBuilder;

import dominio.TipoVehiculo;

public class TipoVehiculoTestDataBuilder {
	

	private static final String DESCRIPCION = "MOTO";
	private static final boolean USACILINDRAJE = true;	
	private static final double CILINDRAJEMAXIMO = 500;
	private static final double VALORHORA = 500;
	private static final double VALORDIA = 4000;
	private static final double ADICIONALCILINDRAJE = 2000;
	private static final int CAPACIDADMXIMA = 10;
	
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
	
	public TipoVehiculoTestDataBuilder conDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}
	public TipoVehiculoTestDataBuilder conUsaCilindraje(boolean usaCilindraje) {
		this.usaCilindraje = usaCilindraje;
		return this;
	}
	public TipoVehiculoTestDataBuilder conCilindrajeMaximo( double cilindrajeMaximo) {		
		this.cilindrajeMaximo = cilindrajeMaximo;
		return this;
	}	
	public TipoVehiculoTestDataBuilder conValorHora(double valorHora) {
		this.valorHora = valorHora;
		return this;
	}	
	public TipoVehiculoTestDataBuilder conValorDia(double valorDia) {
		this.valorDia = valorDia;
		return this;
	}	
	public TipoVehiculoTestDataBuilder conAdicionalCilindraje(double adicionalCilindraje) {
		this.adicionalCilindraje = adicionalCilindraje;
		return this;
	}	
	public TipoVehiculoTestDataBuilder conCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
		return this;
	}	
	public TipoVehiculo build() {
		return new TipoVehiculo(this.descripcion, this.usaCilindraje, this.cilindrajeMaximo, this.valorHora, this.valorDia, this.adicionalCilindraje, this.capacidadMaxima);
	}
	
}
