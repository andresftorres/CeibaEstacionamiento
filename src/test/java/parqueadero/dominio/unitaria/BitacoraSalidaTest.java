package parqueadero.dominio.unitaria;

import static org.junit.Assert.assertEquals;
import java.util.Calendar;
import org.junit.Test;
import parqueadero.dominio.BitacoraSalida;
import parqueadero.testDataBuilder.BitacoraSalidaTestDataBuilder;

public class BitacoraSalidaTest {

	private static final double DIFERENCIA = 0.0;
	private static final Long ID = 1L;
	private static final Long IDVEHICULO = 2L;
	private static final Calendar FECHAINGRESO = Calendar.getInstance();
	private static final Calendar FECHASALIDA = Calendar.getInstance();
	private static final double VALORTOTAL = 8200;
		
	@Test
	public void CrearBitacoraSalidaTest() {

		// arrange

		BitacoraSalidaTestDataBuilder bitacoraSalidaTest = new BitacoraSalidaTestDataBuilder().conId(ID)
				.conIdVehiculo(IDVEHICULO).conFechaIngreso(FECHAINGRESO).conFechaSalida(FECHASALIDA)
				.conValorTotal(VALORTOTAL);
		// act
		BitacoraSalida bitacoraSalidaTestPrueba = bitacoraSalidaTest.build();

		// assert		
		assertEquals(IDVEHICULO, bitacoraSalidaTestPrueba.getIdVehiculo());
		assertEquals(FECHAINGRESO, bitacoraSalidaTestPrueba.getFechaIngreso());
		assertEquals(FECHASALIDA, bitacoraSalidaTestPrueba.getFechaSalida());
		assertEquals(VALORTOTAL, bitacoraSalidaTestPrueba.getValorTotal(), DIFERENCIA );

	}
}
