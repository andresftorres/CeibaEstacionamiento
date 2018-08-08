package parqueadero.builder;

import parqueadero.dominio.BitacoraIngreso;
import parqueadero.entidad.BitacoraIngresoEntity;

public final class BitacoraIngresoBuilder {
	
	private BitacoraIngresoBuilder() {
		
	}
	
	public static BitacoraIngreso convertirADominio(BitacoraIngresoEntity bitacoraIngresoEntity) {
		
		if (bitacoraIngresoEntity == null) {
			return null;
		}
				
		return new BitacoraIngreso(
				VehiculoBuilder.convertirADominio(bitacoraIngresoEntity.getVehiculo()), 
				bitacoraIngresoEntity.getFechaIngreso(), 
				bitacoraIngresoEntity.isEnPaqueadero()
		);		
	}
	
	public static BitacoraIngresoEntity convertirAEntity(BitacoraIngreso bitacoraIngreso) {
		
		if (bitacoraIngreso == null) {
			return null;
		}
		
		return new BitacoraIngresoEntity(
				VehiculoBuilder.convertirAEntity(bitacoraIngreso.getVehiculo()), 
				bitacoraIngreso.getFechaIngreso(), 
				bitacoraIngreso.isEnPaqueadero()
		);		
	}
}
