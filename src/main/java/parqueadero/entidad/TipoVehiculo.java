package parqueadero.entidad;

public enum TipoVehiculo {

	MOTOCICLETA("M", "Motocicleta"), AUTOMOVIL("A", "Automovil");

	private final String codigo;
	private final String descripcion;

	TipoVehiculo(String tipo, String descripcion) {
		this.codigo = tipo;
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
