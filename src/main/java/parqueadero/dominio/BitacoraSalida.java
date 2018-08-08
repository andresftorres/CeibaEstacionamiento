package parqueadero.dominio;

import java.util.Calendar;

public class BitacoraSalida extends Bitacora {

	private Calendar fechaSalida;
	private double valorTotal;	
	
	public BitacoraSalida(Vehiculo vehiculo, Calendar fechaIngreso, Calendar fechaSalida, double valorTotal) {
		super(vehiculo, fechaIngreso);
		this.fechaSalida = fechaSalida;
		this.valorTotal = valorTotal;
	}
	public Calendar getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
