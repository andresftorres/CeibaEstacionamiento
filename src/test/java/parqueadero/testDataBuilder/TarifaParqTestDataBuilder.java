package parqueadero.testDataBuilder;

import parqueadero.dominio.TarifaParqueadero;
import parqueadero.entidad.TipoVehiculo;

public class TarifaParqTestDataBuilder {

	private static final String TIPOVEHICULO = TipoVehiculo.MOTOCICLETA.getCodigo();
	private static final double VALORHORA = 500;
	private static final double VALORDIA = 4000;
	private static final int CAPACIDADMXIMA = 10;
	private static final boolean USACILINDRAJE = true;
	private static final double CILINDRAJEMAXIMO = 500;	
	private static final double ADICIONALCILINDRAJE = 2000;
	
	
	private String tipoVehiculo;
	private double valorHora;
	private double valorDia;
	private int capacidadMaxima;
	private boolean usaCilindraje;	
	private double cilindrajeMaximo;
	private double cobroExtraCilindraje;
	
	public TarifaParqTestDataBuilder() {
		super();
		this.tipoVehiculo = TIPOVEHICULO;
		this.valorHora = VALORHORA;
		this.valorDia = VALORDIA;
		this.capacidadMaxima = CAPACIDADMXIMA;
		this.usaCilindraje = USACILINDRAJE;
		this.cilindrajeMaximo = CILINDRAJEMAXIMO;
		this.cobroExtraCilindraje = ADICIONALCILINDRAJE;
	}
	
	public TarifaParqTestDataBuilder conTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
		return this;
	}	

	public TarifaParqTestDataBuilder conValorHora(double valorHora) {
		this.valorHora = valorHora;
		return this;
	}
	
	public TarifaParqTestDataBuilder conValorDia(double valorDia) {
		this.valorDia = valorDia;
		return this;
	}

	public TarifaParqTestDataBuilder conCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
		return this;
	}

	public TarifaParqTestDataBuilder conUsaCilindraje(boolean usaCilindraje) {
		this.usaCilindraje = usaCilindraje;
		return this;
	}

	public TarifaParqTestDataBuilder conCilindrajeMaximo(double cilindrajeMaximo) {
		this.cilindrajeMaximo = cilindrajeMaximo;
		return this;
	}

	public TarifaParqTestDataBuilder conCobroExtraCilindraje(double cobroExtraCilindraje) {
		this.cobroExtraCilindraje = cobroExtraCilindraje;
		return this;
	}

	public TarifaParqueadero build() {
		return new TarifaParqueadero(
				this.tipoVehiculo, this.valorHora, this.valorDia, this.capacidadMaxima, this.usaCilindraje, 
				this.cilindrajeMaximo, this.cobroExtraCilindraje);
	}

}
