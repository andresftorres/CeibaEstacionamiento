package parqueadero.builder;

import parqueadero.dominio.BitacoraSalida;
import parqueadero.entidad.BitacoraSalidaEntity;

public final class BitacoraSalidaBuilder {
	
	private BitacoraSalidaBuilder() {
		
	}
	
	public static BitacoraSalida convertirADominio(BitacoraSalidaEntity bitacoraSalidaEntity) {
		
		if (bitacoraSalidaEntity == null) {
			return null;
		}
		
		return new BitacoraSalida(
				VehiculoBuilder.convertirADominio(bitacoraSalidaEntity.getVehiculo()), 
				bitacoraSalidaEntity.getFechaIngreso(), 
				bitacoraSalidaEntity.getFechaSalida(), 
				bitacoraSalidaEntity.getValorTotal()
		);		
	}
	
	public static BitacoraSalidaEntity convertirAEntity(BitacoraSalida bitacoraSalida) {
		
		if (bitacoraSalida == null) {
			return null;
		}
		
		return new BitacoraSalidaEntity(
				VehiculoBuilder.convertirAEntity(bitacoraSalida.getVehiculo()), 
				bitacoraSalida.getFechaIngreso(), 
				bitacoraSalida.getFechaSalida(), 
				bitacoraSalida.getValorTotal()
		);		
	}
}
