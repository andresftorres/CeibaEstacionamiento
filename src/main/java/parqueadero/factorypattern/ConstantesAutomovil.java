package parqueadero.factorypattern;

import parqueadero.dominio.ParametrosParqueadero;

public class ConstantesAutomovil implements ConstantesTipoVehiculo {
	
	@Override
    public int capacidadMaxima() {
        return ParametrosParqueadero.CAPACIDAD_MAXIMA_CARROS;
    }
	
    @Override
    public double obtenerValorHora() {
        return ParametrosParqueadero.VALOR_HORA_CARRO;
    }
    
    @Override
    public double obtenerValorDia() {
        return ParametrosParqueadero.VALOR_DIA_CARRO;
    }

	@Override
	public double cilidrageMaximo() {		
		return 0;
	}

	@Override
	public double cobroPorCilindraje() {		
		return 0;
	}

}
