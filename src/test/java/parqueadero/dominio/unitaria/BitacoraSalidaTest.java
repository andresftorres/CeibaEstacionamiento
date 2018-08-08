package parqueadero.dominio.unitaria;

import static org.junit.Assert.assertEquals;
import java.util.Calendar;
import org.junit.Test;
import parqueadero.dominio.BitacoraSalida;
import parqueadero.dominio.Vehiculo;
import parqueadero.testDataBuilder.BitacoraSalidaTestDataBuilder;
import parqueadero.testDataBuilder.VehiculoTestDataBuilder;

public class BitacoraSalidaTest {

	private static final double DIFERENCIA = 0.0;
	private static final Long ID = 1L;
	private static final Vehiculo VEHICULO = new VehiculoTestDataBuilder().build();
	private static final Calendar FECHAINGRESO = Calendar.getInstance();
	private static final Calendar FECHASALIDA = Calendar.getInstance();
	private static final double VALORTOTAL = 8200;
		
	@Test
	public void CrearBitacoraSalidaTest() {

		// arrange

		BitacoraSalidaTestDataBuilder bitacoraSalidaTest = new BitacoraSalidaTestDataBuilder().conId(ID)
				.conVehiculo(VEHICULO).conFechaIngreso(FECHAINGRESO).conFechaSalida(FECHASALIDA)
				.conValorTotal(VALORTOTAL);
		// act
		BitacoraSalida bitacoraSalidaTestPrueba = bitacoraSalidaTest.build();

		// assert		
		assertEquals(VEHICULO, bitacoraSalidaTestPrueba.getVehiculo());
		assertEquals(FECHAINGRESO, bitacoraSalidaTestPrueba.getFechaIngreso());
		assertEquals(FECHASALIDA, bitacoraSalidaTestPrueba.getFechaSalida());
		assertEquals(VALORTOTAL, bitacoraSalidaTestPrueba.getValorTotal(), DIFERENCIA );

	}
}
