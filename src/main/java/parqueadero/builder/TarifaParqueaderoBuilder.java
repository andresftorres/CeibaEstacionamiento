package parqueadero.builder;

import org.springframework.stereotype.Component;

import parqueadero.dominio.TarifaParqueadero;
import parqueadero.entidad.TarifaParqueaderoEntity;

@Component
public final class TarifaParqueaderoBuilder {
	
	private TarifaParqueaderoBuilder() {		
	}

	public static TarifaParqueadero convertirADominio(TarifaParqueaderoEntity bitacoraSalidaEntity) {

		if (bitacoraSalidaEntity == null) {
			return null;
		}

		TarifaParqueadero tarifaParquadero = new TarifaParqueadero(
				bitacoraSalidaEntity.getTipoVehiculo(), 
				bitacoraSalidaEntity.getValorHora(), 
				bitacoraSalidaEntity.getValorDia(),
				bitacoraSalidaEntity.getCapacidadMaxima(), 
				bitacoraSalidaEntity.isUsaCilindraje(), 
				bitacoraSalidaEntity.getCilindrajeMaximo(), 
				bitacoraSalidaEntity.getAdicionalCilindraje()
		);

		tarifaParquadero.setId(bitacoraSalidaEntity.getId());

		return tarifaParquadero;
	}

	public static TarifaParqueaderoEntity convertirAEntity(TarifaParqueadero tarifaParqueadero) {

		if (tarifaParqueadero == null) {
			return null;
		}

		return  new TarifaParqueaderoEntity(
				tarifaParqueadero.getTipoVehiculo(), 
				tarifaParqueadero.getValorHora(), 
				tarifaParqueadero.getValorDia(), 
				tarifaParqueadero.getCapacidadMaxima(), 
				tarifaParqueadero.getTieneCilindraje(), 
				tarifaParqueadero.getCilindrajeMaximo(), 
				tarifaParqueadero.getCobroExtraCilindraje()
		);		 
	}

}
