package parqueadero.dominio;

import java.util.Calendar;

public class RespuestaConsulta {

	private String placa;
	private String tipoVehiculo;
	private Calendar fechingreso;

	public RespuestaConsulta() {

	}

	public RespuestaConsulta(String placa, String tipoVehiculo, Calendar fechingreso) {
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.fechingreso = fechingreso;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public Calendar getFechingreso() {
		return fechingreso;
	}

	public void setFechingreso(Calendar fechingreso) {
		this.fechingreso = fechingreso;
	}
	
}
