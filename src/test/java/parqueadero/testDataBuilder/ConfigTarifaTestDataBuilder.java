package parqueadero.testDataBuilder;

import parqueadero.dominio.ConfigTarifas;

public class ConfigTarifaTestDataBuilder {
	

	private static final String DESCRIPCION = "Tarifa para moto";	
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
		
	public ConfigTarifaTestDataBuilder() {		
		this.descripcion = DESCRIPCION;
		this.usaCilindraje = USACILINDRAJE;
		this.cilindrajeMaximo = CILINDRAJEMAXIMO;
		this.valorHora = VALORHORA;
		this.valorDia = VALORDIA;
		this.adicionalCilindraje = ADICIONALCILINDRAJE;
		this.capacidadMaxima = CAPACIDADMXIMA;
	}
	
	public ConfigTarifaTestDataBuilder conDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}
	public ConfigTarifaTestDataBuilder conUsaCilindraje(boolean usaCilindraje) {
		this.usaCilindraje = usaCilindraje;
		return this;
	}
	public ConfigTarifaTestDataBuilder conCilindrajeMaximo( double cilindrajeMaximo) {		
		this.cilindrajeMaximo = cilindrajeMaximo;
		return this;
	}	
	public ConfigTarifaTestDataBuilder conValorHora(double valorHora) {
		this.valorHora = valorHora;
		return this;
	}	
	public ConfigTarifaTestDataBuilder conValorDia(double valorDia) {
		this.valorDia = valorDia;
		return this;
	}	
	public ConfigTarifaTestDataBuilder conAdicionalCilindraje(double adicionalCilindraje) {
		this.adicionalCilindraje = adicionalCilindraje;
		return this;
	}	
	public ConfigTarifaTestDataBuilder conCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
		return this;
	}	
	public ConfigTarifas build() {
		return new ConfigTarifas(this.descripcion, this.usaCilindraje, this.cilindrajeMaximo, this.valorHora, this.valorDia, this.adicionalCilindraje, this.capacidadMaxima);
	}
	
}
