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
		
		BitacoraIngreso bitacoraIngreso = new BitacoraIngreso( 
				bitacoraIngresoEntity.getIdVehiculo(), 
				bitacoraIngresoEntity.getFechaIngreso(), 
				bitacoraIngresoEntity.isEnPaqueadero()
		);
		
		bitacoraIngreso.setId(bitacoraIngresoEntity.getId());
		
		return bitacoraIngreso;		
	}
	
	public static BitacoraIngresoEntity convertirAEntity(BitacoraIngreso bitacoraIngreso) {
		
		if (bitacoraIngreso == null) {
			return null;
		}
		
		BitacoraIngresoEntity bitacoraIngresoEntity = new BitacoraIngresoEntity(
				bitacoraIngreso.getIdVehiculo(), 
				bitacoraIngreso.getFechaIngreso(), 
				bitacoraIngreso.isEnPaqueadero()
		);
		
		bitacoraIngresoEntity.setId(bitacoraIngreso.getId());
		
		return bitacoraIngresoEntity;		
	}
}
