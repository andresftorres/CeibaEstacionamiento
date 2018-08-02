package parqueadero.builder;

import parqueadero.dominio.Motocicleta;
import parqueadero.entidad.MotocicletaEntity;

public final class MotocicletaBuilder {

	private MotocicletaBuilder() {
	}

	public static Motocicleta convertirADominio(MotocicletaEntity motocicletaEntity) {

		if (motocicletaEntity == null) {
			return null;
		}
		
		return  new Motocicleta(
				motocicletaEntity.getPlaca(), 
				motocicletaEntity.getTipoVehiculo(),
				motocicletaEntity.getCilindraje()
		);
	}

	public static MotocicletaEntity convertirAEntity(Motocicleta motocicleta) {

		if (motocicleta == null) {
			return null;
		}

		return  new MotocicletaEntity(
				motocicleta.getPlaca(), 
				motocicleta.getTipoVehiculo(), 
				motocicleta.getCilindraje()
			);		
	}

}
