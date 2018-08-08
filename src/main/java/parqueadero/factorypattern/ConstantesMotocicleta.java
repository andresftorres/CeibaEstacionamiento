package parqueadero.factorypattern;

import parqueadero.dominio.ParametrosParqueadero;

public class ConstantesMotocicleta implements ConstantesTipoVehiculo {

	public int capacidadMaxima() {
		return ParametrosParqueadero.CAPACIDAD_MAXIMA_MOTOS;
	}

	public double obtenerValorHora() {
		return ParametrosParqueadero.VALOR_HORA_MOTO;
	}

	public double obtenerValorDia() {
		return ParametrosParqueadero.VALOR_DIA_MOTO;
	}

	public double cilidrageMaximo() {
		return ParametrosParqueadero.LIMITE_CIILINDRAJE_MOTO;
	}

	public double cobroPorCilindraje() {
		return ParametrosParqueadero.COSTO_CILINDRAJE_MOTO;
	}

}
