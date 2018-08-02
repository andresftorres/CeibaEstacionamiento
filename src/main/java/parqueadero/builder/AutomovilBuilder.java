package parqueadero.builder;

import parqueadero.dominio.Automovil;
import parqueadero.entidad.AutomovilEntity;

public final class AutomovilBuilder {

	private AutomovilBuilder() {
	}

	public static Automovil convertirADominio(AutomovilEntity automovilEntity) {

		if (automovilEntity == null) {
			return null;
		}
		
		return  new Automovil(
				automovilEntity.getPlaca(), 
				automovilEntity.getTipoVehiculo()
		);
	}

	public static AutomovilEntity convertirAEntity(Automovil automovil) {

		if (automovil == null) {
			return null;
		}

		return  new AutomovilEntity(
				automovil.getPlaca(), 
				automovil.getTipoVehiculo()
			);		
	}

}
