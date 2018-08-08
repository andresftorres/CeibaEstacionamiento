package parqueadero.builder;

import parqueadero.dominio.Vehiculo;
import parqueadero.entidad.VehiculoEntity;

public final class VehiculoBuilder {

	private VehiculoBuilder() {
	}

	public static Vehiculo convertirADominio(VehiculoEntity vehiculoEntity) {

		if (vehiculoEntity == null) {
			return null;
		}
		
		return  new Vehiculo(
				vehiculoEntity.getPlaca(), 
				vehiculoEntity.getTipoVehiculo(),
				vehiculoEntity.getCilindraje()
		);
	}

	public static VehiculoEntity convertirAEntity(Vehiculo vehiculo) {

		if (vehiculo == null) {
			return null;
		}

		return  new VehiculoEntity(
				vehiculo.getPlaca(), 
				vehiculo.getTipoVehiculo(), 
				vehiculo.getCilindraje()
			);		
	}

}
