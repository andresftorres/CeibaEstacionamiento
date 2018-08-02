package parqueadero.dominio;

import java.util.Calendar;

public class BitacoraIngreso extends Bitacora {

	private boolean enPaqueadero;	

	public BitacoraIngreso( Long idVehiculo, Calendar fechaIngreso, boolean enPaqueadero) {
		super(idVehiculo, fechaIngreso);
		this.enPaqueadero = enPaqueadero;
	}

	public boolean isEnPaqueadero() {
		return enPaqueadero;
	}

	public void setEnPaqueadero(boolean enPaqueadero) {
		this.enPaqueadero = enPaqueadero;
	}

	

}
