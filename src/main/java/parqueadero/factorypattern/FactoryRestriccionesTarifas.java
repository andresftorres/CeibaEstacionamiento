package parqueadero.factorypattern;

import parqueadero.dominio.ParametrosParqueadero;
import parqueadero.entidad.TipoVehiculo;
import parqueadero.exception.ParqueaderoException;


public final class FactoryRestriccionesTarifas {	
	
	 private FactoryRestriccionesTarifas() {
		    throw new IllegalStateException("Utility class");
	}

	 
    public static ConstantesTipoVehiculo obtenerDatosConfiguracion(TipoVehiculo tipo) throws ParqueaderoException { 
    	
        if( tipo == TipoVehiculo.MOTOCICLETA ){
        	return new ConstantesMotocicleta();
        	
        } else if(tipo == TipoVehiculo.AUTOMOVIL){
        	return new ConstantesAutomovil();
        	
        } else {
        	throw new ParqueaderoException(ParametrosParqueadero.TIPO_DE_VEHICULO_NO_AUTORIZADO);
        }
    }

}
