package parqueadero.dominio;

import parqueadero.entidad.TipoVehiculo;

public final class ParametrosParqueadero {

	public static final int HORAS_INICIO_DIA = 9;
	public static final int TOTAL_HORAS_DIA = 24;

	//Mensajes
	public static final String VEHICULO_NO_AUTORIZADO = "El vehiculo no esta autorizado para ingresar al parqueadero porque no es un dia habil.";
	public static final String TIPO_DE_VEHICULO_NO_AUTORIZADO = "El vehculo no esta autorizado para ingresar a al parqueadero.";
	public static final String SIN_CUPO_PARA_VEHICULO = "No hay cupo para el vehiculo.";
	public static final String EL_VEHICULO_NO_ESTA_EN_EL_PARQUEADERO = "El vehiculo no se encuentra en el parqueadero.";
	public static final String EL_VEHICULO_YA_ESTA_EN_EL_PARQUEADERO = "El vehiculo se encuentra actualmente en el parqueadero.";
	public static final String NO_VEHICULOS_ESTACIONADOS = "El parqueadero esta vacío.";
	public static final String EL_VEHICULO_NO_ESTA_EN_PARQUEADERO = "El parqueadero esta vacío.";
	public static final String REGISTRO_EXITOSO = "Bitacora de ingreso registrado exitosamente.";
	public static final String SALIDA_REGISTRADA_EXITOSAMENTE = "Bitacora de salida registrado exitosamente.";
	
	public static final String TIPOS_DE_VEHICULOS_PERMITIDOS = TipoVehiculo.MOTOCICLETA.getCodigo()+","+TipoVehiculo.AUTOMOVIL.getCodigo();
	public static final String LETRA_PARA_VALIDAR_PLACAS = "A";
	
	//Rutas de acceso
	public static final String API = "api";
	public static final String RUTA_INGRESO = "/ingresovehiculo";	
	public static final String RUTA_SALIDA = "/salidavehiculo";
	public static final String RUTA_CONSULTA = "/parqueadero/{placa}";
	public static final String RUTA_TODOS_LOS_VEHICULOS = "/parqueadero";
	
	//Sistema de cobro carro
	 public static final int CAPACIDAD_MAXIMA_CARROS = 20;
    public static final double VALOR_HORA_CARRO = 1000;
    public static final double VALOR_DIA_CARRO = 8000;    
    //Sistema cobro moto
    public static final int CAPACIDAD_MAXIMA_MOTOS = 10;
    public static final double VALOR_HORA_MOTO = 500;
    public static final double VALOR_DIA_MOTO = 4000;
    //Parametros adicionales  moto
    public static final Integer LIMITE_CIILINDRAJE_MOTO = 500;
    public static final double COSTO_CILINDRAJE_MOTO = 2000;
	

	private ParametrosParqueadero() {}
}
