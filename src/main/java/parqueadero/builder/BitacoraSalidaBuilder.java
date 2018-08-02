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
		
		BitacoraSalida bitacoraSalida = new BitacoraSalida(
				bitacoraSalidaEntity.getIdVehiculo(), 
				bitacoraSalidaEntity.getFechaIngreso(), 
				bitacoraSalidaEntity.getFechaSalida(), 
				bitacoraSalidaEntity.getValorTotal()
		);
		
		bitacoraSalida.setId(bitacoraSalidaEntity.getId());
		
		return bitacoraSalida;		
	}
	
	public static BitacoraSalidaEntity convertirAEntity(BitacoraSalida bitacoraSalida) {
		
		if (bitacoraSalida == null) {
			return null;
		}
		
		BitacoraSalidaEntity bitacoraSalidaEntity = new BitacoraSalidaEntity(
				bitacoraSalida.getIdVehiculo(), 
				bitacoraSalida.getFechaIngreso(), 
				bitacoraSalida.getFechaSalida(), 
				bitacoraSalida.getValorTotal()
		);
		
		bitacoraSalidaEntity.setId(bitacoraSalida.getId());
		
		return bitacoraSalidaEntity;		
	}
}
