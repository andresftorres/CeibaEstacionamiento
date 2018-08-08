package parqueadero.servicios.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import parqueadero.entidad.TipoVehiculo;
import parqueadero.servicios.SalidaVehiculoServicio;

public class ValidacionesSalidaTest {

	private static final String PLACANOAUTORIADA = "ABC-123";
	private static final String PLACAAUTORIZADA = "BCD-123";
	private static final String TIPOVEHICULO = TipoVehiculo.AUTOMOVIL.getCodigo();
	private static final String TIPOVEHICULOBICICLETA = "B";
	private static final int CANTIDAD_MAXIMA_MOTOS = 10;
	private static final double CILINDRAJE = 600;
	private static final String FECHA_SOLICITUD = "2017-05-26";

	@Autowired
	@Qualifier("salidavehiculosservicios")
	SalidaVehiculoServicio salidaVehiculoServicio;

	@Test
	public void registrarSalidaDeAutomovil_VehiculoNoEstaEnParqueadero() {
		/*				
		@Test
	    public void registrarSalidaSatisfactoriaTest() {
			
	        // Arrange
		        
			when(estacionamientoRepository.findByVehiculoPlacaAndFechaSalidaNull(any()))
	                .thenReturn(new RegistroEstacionamiento());
	        when(vehiculoService.consultarVehiculoPorPlaca(any())).thenReturn(new VehiculoBuilder().build());
	        when(fechaUtil.obtenerFechaActual()).thenCallRealMethod();
	        when(estacionamientoRepository.save(any())).thenReturn(new RegistroEstacionamiento());
	        try {
	            // Act
	            RespuestaDTO respuesta = salidaService.registrarSalidaVehiculo("ASDASD");
	            // Assert
	            assertEquals(CodigoMensajeEnum.SALIDA_EXITOSA.getCodigo(), respuesta.getCodigo());
	        } catch (EstacionamientoException e) {
	            fail();
	        }
	    }

	    @Test
	    public void registrarSalidaCarroDosDiasSatisfactoriaTest() {
	        // Arrange
	        VehiculoModel vehiculoModel = new VehiculoBuilder().conTipo(TipoVehiculoEnum.CARRO).build();
	        when(estacionamientoRepository.findByVehiculoPlacaAndFechaSalidaNull(any()))
	                .thenReturn(new RegistroEstacionamiento(1L, Calendar.getInstance().getTime(), null, new BigDecimal(0),
	                        new Vehiculo()));
	        when(vehiculoService.consultarVehiculoPorPlaca(any())).thenReturn(vehiculoModel);
	        when(fechaUtil.obtenerFechaActual()).thenCallRealMethod();
	        when(fechaUtil.calcularHorasEstacionado(any())).thenReturn(36L);
	        when(estacionamientoRepository.save(any())).thenReturn(new RegistroEstacionamiento());
	        try {
	            // Act
	            SalidaVehiculoDTO respuesta = (SalidaVehiculoDTO) salidaService.registrarSalidaVehiculo("ASDASD");
	            // Assert
	            assertEquals(CodigoMensajeEnum.SALIDA_EXITOSA.getCodigo(), respuesta.getCodigo());
	            assertEquals(new BigDecimal(16000), respuesta.getCostoTotal());
	        } catch (EstacionamientoException e) {
	            fail();
	        }
	    }

	    @Test
	    public void registrarSalidaMotoDosDiasSatisfactoriaTest() {
	        // Arrange
	        VehiculoModel vehiculoModel = new VehiculoBuilder().conTipo(TipoVehiculoEnum.MOTO).build();
	        when(estacionamientoRepository.findByVehiculoPlacaAndFechaSalidaNull(any()))
	                .thenReturn(new RegistroEstacionamiento(1L, Calendar.getInstance().getTime(), null, new BigDecimal(0),
	                        new Vehiculo()));
	        when(vehiculoService.consultarVehiculoPorPlaca(any())).thenReturn(vehiculoModel);
	        when(fechaUtil.obtenerFechaActual()).thenCallRealMethod();
	        when(fechaUtil.calcularHorasEstacionado(any())).thenReturn(36L);
	        when(estacionamientoRepository.save(any())).thenReturn(new RegistroEstacionamiento());
	        try {
	            // Act
	            SalidaVehiculoDTO respuesta = (SalidaVehiculoDTO) salidaService.registrarSalidaVehiculo("ASDASD");
	            // Assert
	            assertEquals(CodigoMensajeEnum.SALIDA_EXITOSA.getCodigo(), respuesta.getCodigo());
	            assertEquals(new BigDecimal(8000), respuesta.getCostoTotal());
	        } catch (EstacionamientoException e) {
	            fail();
	        }
	    }

	    @Test
	    public void registrarSalidaCarroConDiaYHoraSatisfactoriaTest() {
	        // Arrange
	        VehiculoModel vehiculoModel = new VehiculoBuilder().conTipo(TipoVehiculoEnum.CARRO).build();
	        when(estacionamientoRepository.findByVehiculoPlacaAndFechaSalidaNull(any()))
	                .thenReturn(new RegistroEstacionamiento(1L, Calendar.getInstance().getTime(), null, new BigDecimal(0),
	                        new Vehiculo()));
	        when(vehiculoService.consultarVehiculoPorPlaca(any())).thenReturn(vehiculoModel);
	        when(fechaUtil.obtenerFechaActual()).thenCallRealMethod();
	        when(fechaUtil.calcularHorasEstacionado(any())).thenReturn(28L);
	        when(estacionamientoRepository.save(any())).thenReturn(new RegistroEstacionamiento());
	        try {
	            // Act
	            SalidaVehiculoDTO respuesta = (SalidaVehiculoDTO) salidaService.registrarSalidaVehiculo("ASDASD");
	            // Assert
	            assertEquals(CodigoMensajeEnum.SALIDA_EXITOSA.getCodigo(), respuesta.getCodigo());
	            assertEquals(new BigDecimal(12000), respuesta.getCostoTotal());
	        } catch (EstacionamientoException e) {
	            fail();
	        }
	    }

	    @Test
	    public void registrarSalidaCarroConDiaSatisfactoriaTest() {
	        // Arrange
	        VehiculoModel vehiculoModel = new VehiculoBuilder().conTipo(TipoVehiculoEnum.CARRO).build();
	        when(estacionamientoRepository.findByVehiculoPlacaAndFechaSalidaNull(any()))
	                .thenReturn(new RegistroEstacionamiento(1L, Calendar.getInstance().getTime(), null, new BigDecimal(0),
	                        new Vehiculo()));
	        when(vehiculoService.consultarVehiculoPorPlaca(any())).thenReturn(vehiculoModel);
	        when(fechaUtil.obtenerFechaActual()).thenCallRealMethod();
	        when(fechaUtil.calcularHorasEstacionado(any())).thenReturn(11L);
	        when(estacionamientoRepository.save(any())).thenReturn(new RegistroEstacionamiento());
	        try {
	            // Act
	            SalidaVehiculoDTO respuesta = (SalidaVehiculoDTO) salidaService.registrarSalidaVehiculo("ASDASD");
	            // Assert
	            assertEquals(CodigoMensajeEnum.SALIDA_EXITOSA.getCodigo(), respuesta.getCodigo());
	            assertEquals(Constantes.VALOR_DIA_CARRO, respuesta.getCostoTotal());
	        } catch (EstacionamientoException e) {
	            fail();
	        }
	    }

	    @Test
	    public void registrarSalidaCarroConHorasSatisfactoriaTest() {
	        // Arrange
	        VehiculoModel vehiculoModel = new VehiculoBuilder().conTipo(TipoVehiculoEnum.CARRO).build();
	        when(estacionamientoRepository.findByVehiculoPlacaAndFechaSalidaNull(any()))
	                .thenReturn(new RegistroEstacionamiento(1L, Calendar.getInstance().getTime(), null, new BigDecimal(0),
	                        new Vehiculo()));
	        when(vehiculoService.consultarVehiculoPorPlaca(any())).thenReturn(vehiculoModel);
	        when(fechaUtil.obtenerFechaActual()).thenCallRealMethod();
	        when(fechaUtil.calcularHorasEstacionado(any())).thenReturn(1L);
	        when(estacionamientoRepository.save(any())).thenReturn(new RegistroEstacionamiento());
	        try {
	            // Act
	            SalidaVehiculoDTO respuesta = (SalidaVehiculoDTO) salidaService.registrarSalidaVehiculo("ASDASD");
	            // Assert
	            assertEquals(CodigoMensajeEnum.SALIDA_EXITOSA.getCodigo(), respuesta.getCodigo());
	            assertEquals(Constantes.VALOR_HORA_CARRO, respuesta.getCostoTotal());
	        } catch (EstacionamientoException e) {
	            fail();
	        }
	    }

	    @Test
	    public void registrarSalidaMotoConDiaYHoraSatisfactoriaTest() {
	        // Arrange
	        VehiculoModel vehiculoModel = new VehiculoBuilder().conTipo(TipoVehiculoEnum.MOTO).build();
	        when(estacionamientoRepository.findByVehiculoPlacaAndFechaSalidaNull(any()))
	                .thenReturn(new RegistroEstacionamiento(1L, Calendar.getInstance().getTime(), null, new BigDecimal(0),
	                        new Vehiculo()));
	        when(vehiculoService.consultarVehiculoPorPlaca(any())).thenReturn(vehiculoModel);
	        when(fechaUtil.obtenerFechaActual()).thenCallRealMethod();
	        when(fechaUtil.calcularHorasEstacionado(any())).thenReturn(28L);
	        when(estacionamientoRepository.save(any())).thenReturn(new RegistroEstacionamiento());
	        try {
	            // Act
	            SalidaVehiculoDTO respuesta = (SalidaVehiculoDTO) salidaService.registrarSalidaVehiculo("ASDASD");
	            // Assert
	            assertEquals(CodigoMensajeEnum.SALIDA_EXITOSA.getCodigo(), respuesta.getCodigo());
	            assertEquals(new BigDecimal(6000), respuesta.getCostoTotal());
	        } catch (EstacionamientoException e) {
	            fail();
	        }
	    }

	    @Test
	    public void registrarSalidaMotoConDiaSatisfactoriaTest() {
	        // Arrange
	        VehiculoModel vehiculoModel = new VehiculoBuilder().conTipo(TipoVehiculoEnum.MOTO).build();
	        when(estacionamientoRepository.findByVehiculoPlacaAndFechaSalidaNull(any()))
	                .thenReturn(new RegistroEstacionamiento(1L, Calendar.getInstance().getTime(), null, new BigDecimal(0),
	                        new Vehiculo()));
	        when(vehiculoService.consultarVehiculoPorPlaca(any())).thenReturn(vehiculoModel);
	        when(fechaUtil.obtenerFechaActual()).thenCallRealMethod();
	        when(fechaUtil.calcularHorasEstacionado(any())).thenReturn(11L);
	        when(estacionamientoRepository.save(any())).thenReturn(new RegistroEstacionamiento());
	        try {
	            // Act
	            SalidaVehiculoDTO respuesta = (SalidaVehiculoDTO) salidaService.registrarSalidaVehiculo("ASDASD");
	            // Assert
	            assertEquals(CodigoMensajeEnum.SALIDA_EXITOSA.getCodigo(), respuesta.getCodigo());
	            assertEquals(Constantes.VALOR_DIA_MOTO, respuesta.getCostoTotal());
	        } catch (EstacionamientoException e) {
	            fail();
	        }
	    }

	    @Test
	    public void registrarSalidaMotoConHorasSatisfactoriaTest() {
	        // Arrange
	        VehiculoModel vehiculoModel = new VehiculoBuilder().conTipo(TipoVehiculoEnum.MOTO).build();
	        when(estacionamientoRepository.findByVehiculoPlacaAndFechaSalidaNull(any()))
	                .thenReturn(new RegistroEstacionamiento(1L, Calendar.getInstance().getTime(), null, new BigDecimal(0),
	                        new Vehiculo()));
	        when(vehiculoService.consultarVehiculoPorPlaca(any())).thenReturn(vehiculoModel);
	        when(fechaUtil.obtenerFechaActual()).thenCallRealMethod();
	        when(fechaUtil.calcularHorasEstacionado(any())).thenReturn(1L);
	        when(estacionamientoRepository.save(any())).thenReturn(new RegistroEstacionamiento());
	        try {
	            // Act
	            SalidaVehiculoDTO respuesta = (SalidaVehiculoDTO) salidaService.registrarSalidaVehiculo("ASDASD");
	            // Assert
	            assertEquals(CodigoMensajeEnum.SALIDA_EXITOSA.getCodigo(), respuesta.getCodigo());
	            assertEquals(Constantes.VALOR_HORA_MOTO, respuesta.getCostoTotal());
	        } catch (EstacionamientoException e) {
	            fail();
	        }
	    }

	    @Test
	    public void registrarSalidaMotoSinCilindrajeTest() {
	        // Arrange
	        when(estacionamientoRepository.findByVehiculoPlacaAndFechaSalidaNull(any()))
	                .thenReturn(new RegistroEstacionamiento());
	        when(vehiculoService.consultarVehiculoPorPlaca(any()))
	                .thenReturn(new VehiculoBuilder().conTipo(TipoVehiculoEnum.MOTO).build());
	        when(fechaUtil.obtenerFechaActual()).thenCallRealMethod();
	        when(estacionamientoRepository.save(any())).thenReturn(new RegistroEstacionamiento());
	        try {
	            // Act
	            SalidaVehiculoDTO respuesta = (SalidaVehiculoDTO) salidaService.registrarSalidaVehiculo("ASDASD");
	            // Assert
	            assertEquals(CodigoMensajeEnum.SALIDA_EXITOSA.getCodigo(), respuesta.getCodigo());
	            assertEquals(new BigDecimal(0), respuesta.getCostoTotal());
	        } catch (EstacionamientoException e) {
	            fail();
	        }
	    }

	    @Test
	    public void registrarSalidaMotoConCilindrajeTest() {
	        // Arrange
	        when(estacionamientoRepository.findByVehiculoPlacaAndFechaSalidaNull(any()))
	                .thenReturn(new RegistroEstacionamiento());
	        when(vehiculoService.consultarVehiculoPorPlaca(any()))
	                .thenReturn(new VehiculoBuilder().conTipo(TipoVehiculoEnum.MOTO).conCilindraje(501).build());
	        when(fechaUtil.obtenerFechaActual()).thenCallRealMethod();
	        when(estacionamientoRepository.save(any())).thenReturn(new RegistroEstacionamiento());
	        try {
	            // Act
	            SalidaVehiculoDTO respuesta = (SalidaVehiculoDTO) salidaService.registrarSalidaVehiculo("ASDASD");
	            // Assert
	            assertEquals(CodigoMensajeEnum.SALIDA_EXITOSA.getCodigo(), respuesta.getCodigo());
	            assertEquals(Constantes.COSTO_CILINDRAJE_MOTO, respuesta.getCostoTotal());
	        } catch (EstacionamientoException e) {
	            fail();
	        }
	    }

	    @Test
	    public void falloActualizandoRegistroSalidaTest() {
	        // Arrange
	        when(estacionamientoRepository.findByVehiculoPlacaAndFechaSalidaNull(any()))
	                .thenReturn(new RegistroEstacionamiento());
	        when(vehiculoService.consultarVehiculoPorPlaca(any())).thenReturn(new VehiculoBuilder().build());
	        when(fechaUtil.obtenerFechaActual()).thenCallRealMethod();
	        try {
	            // Act
	            salidaService.registrarSalidaVehiculo("ASDASD");
	            fail();
	        } catch (EstacionamientoException e) {
	            // Assert
	            assertEquals(CodigoMensajeEnum.ERROR.getCodigo(), e.getCodigo());
	        }
	    }

	    @Test
	    public void falloVehiculoNoEncontrado() {
	        // Arrange
	        when(estacionamientoRepository.findByVehiculoPlacaAndFechaSalidaNull(any())).thenReturn(null);
	        try {
	            // Act
	            salidaService.registrarSalidaVehiculo("ASDASD");
	            fail();
	        } catch (EstacionamientoException e) {
	            // Assert
	            assertEquals(CodigoMensajeEnum.VEHICULO_NO_ESTACIONADO.getCodigo(), e.getCodigo());
	        }
	    }

		
	}
*/	
	}
}
