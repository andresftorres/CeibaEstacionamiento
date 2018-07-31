package parqueadero.builder;

import parqueadero.dominio.ConfigTarifas;
import parqueadero.entidad.ConfigTarifasEntity;



public final class ConfigTarifasBuilder {
	
	private ConfigTarifasBuilder() {}
	
	public static ConfigTarifas convertirADominio(ConfigTarifasEntity configTarifasEntity) {
		ConfigTarifas configTarifas = null;
		if(configTarifasEntity != null) {
			configTarifas = new ConfigTarifas(configTarifasEntity.getDescripcion(), configTarifasEntity.getUsaCilindraje(), 
					configTarifasEntity.getCilindrajeMaximo(), configTarifasEntity.getValorHora(), 
					configTarifasEntity.getValorDia(), configTarifasEntity.getAdicionalCilindraje(), 
					configTarifasEntity.getCapacidadMaxima());
		}
		return configTarifas;
	}
	
	public static ConfigTarifasEntity convertirAEntity(ConfigTarifas configTarifas) {
		ConfigTarifasEntity configTarifasEntity = new ConfigTarifasEntity();		
		configTarifasEntity.setDescripcion(configTarifas.getDescripcion());
		configTarifasEntity.setUsaCilindraje(configTarifas.getUsaCilindraje());
		configTarifasEntity.setCilindrajeMaximo(configTarifas.getCilindrajeMaximo());
		configTarifasEntity.setValorHora(configTarifas.getValorHora());
		configTarifasEntity.setValorDia(configTarifas.getValorDia());
		configTarifasEntity.setAdicionalCilindraje(configTarifas.getAdicionalCilindraje());
		configTarifasEntity.setCapacidadMaxima(configTarifas.getCapacidadMaxima());
		
		return configTarifasEntity;
	}
	
}
