package CeibaEstacionamiento.testDataBuilder;

import dominio.TipoVehiculo;

public class TipoVehiculoTestDataBuilder {
	
	private static final Double DOUBLENULL = (Double) null;
	
	private static final String DESCRIPCION = "AUTOMOVIL";
	private static final boolean USACILINDRAJE = false;	
	private static final double CILINDRAJEMAXIMO = DOUBLENULL;
	private static final double VALORHORA = 1000;
	private static final double VALORDIA = 8000;
	private static final double ADICIONALCILINDRAJE = DOUBLENULL;
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
