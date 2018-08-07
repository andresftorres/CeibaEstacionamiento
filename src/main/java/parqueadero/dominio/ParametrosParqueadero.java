package parqueadero.dominio;

public final class ParametrosParqueadero {

	public static final int HORAS_INICIO_DIA = 9;
	public static final int TOTAL_HORAS_DIA = 24;

	public static final String VEHICULO_NO_AUTORIZADO = "El vehiculo no esta autorizado para ingresar al parqueadero porque no es un dia habil.";
	public static final String TIPO_DE_VEHICULO_NO_AUTORIADO = "El vehculo no esta autorizado para ingresar a al parqueadero.";
	public static final String SIN_CUPO_PARA_AUTOMOVIL = "No hay cupo para Automovil.";
	public static final String SIN_CUPO_PARA_MOTOCICLETA = "No hay cupo para Motocicleta.";
	public static final String EL_VEHICULO_NO_ESTA_EN_EL_PARQUEADERO = "El vehiculo no se encuentra en el parqueadero.";
	public static final String EL_VEHICULO_YA_ESTA_EN_EL_PARQUEADERO = "El vehiculo se encuentra actualmente en el parqueadero.";
	
	public static final String TIPOS_DE_VEHICULOS_PERMITIDOS = "A,M";	
	public static final String LETRA_PARA_VALIDAR_PLACAS = "A";
	
	public static final String API = "api";
	public static final String RUTA_INGRESO_AUTOMOVIL = "/ingresoautomovil";
	public static final String RUTA_INGRESO_MOTOCICLETA = "/ingresomotocicleta";	
	public static final String RUTA_SALIDA_AUTOMOVIL = "/salidaautomovil";
	public static final String RUTA_SALIDA_MOOCICLETA = "/salidamotocicleta";

	private ParametrosParqueadero() {}
}
