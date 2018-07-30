package builder;

import dominio.Bitacora;
import entidad.BitacoraEntity;


public final class BitacoraBuilder {
	
	private BitacoraBuilder() {}
	
	public static Bitacora convertirADominio(BitacoraEntity bitacoraEntity) {
		Bitacora bitacora = null;
		if(bitacoraEntity != null) {
			bitacora = new Bitacora(bitacoraEntity.getVehiculo(), bitacoraEntity.getFechaIngreso(), 
					bitacoraEntity.getFechaSalida(), bitacoraEntity.getValorACobrar());
		}
		return bitacora;
	}
	
	public static BitacoraEntity convertirAEntity(Bitacora bitaccora) {
		BitacoraEntity bitacoraEntity = new BitacoraEntity();		
		bitacoraEntity.setVehiculo(bitaccora.getVehiculo());
		bitacoraEntity.setFechaIngreso(bitaccora.getFechaIngreso());
		bitacoraEntity.setFechaSalida(bitaccora.getFechaSalida());
		bitacoraEntity.setValorACobrar(bitaccora.getValorCobro());
		return bitacoraEntity;
	}
	
}
