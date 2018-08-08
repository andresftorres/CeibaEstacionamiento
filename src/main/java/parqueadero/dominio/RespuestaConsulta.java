package parqueadero.dominio;

import java.util.Calendar;

public class RespuestaConsulta {

	private String placa;
	private String tipoVehiculo;
	private Calendar fechingreso;
	private String codigo;
	private String mensaje;

	public RespuestaConsulta() {

	}

	public RespuestaConsulta(String placa, String tipoVehiculo, Calendar fechingreso, String codigo, String mensaje) {
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.fechingreso = fechingreso;
		this.codigo = codigo;
		this.mensaje = mensaje;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	
}
