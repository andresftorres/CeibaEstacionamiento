package CeibaEstacionamiento.unitaria;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import dominio.TipoVehiculo;
import dominio.Vehiculo;



public class VehiculoTest {
	
	/*
	@Test
	public void IngresoVehiculoNoAutorizado() {
		
		//arrange		
		
		TipoVehiculo tipoAutomovil = new TipoVehiculo(descripcion, usaCilindraje, cilindrajeMaximo, valorHora, valorDia, adicionalCilindraje, capacidadMaxima);
		Vehiculo automovilPlcaRestringida = new  
		
		
		// arrange		
		
		Parqueadero parqueadero = new Parqueadero();
		
		// act		
		boolean ingresoAutorizado =  Parqueadero.ingresoVehiculo( automovilPlcaRestringida);
		
		//assert
		//assertTrue(esPrestado);
		
	}
	
	@Test
	public void prestarLibroNoDisponibleTest() {

		// arrange
		Libro libro = new LibroTestDataBuilder().conTitulo(CRONICA_DE_UNA_MUERTA_ANUNCIADA).build();
		
		repositorioLibros.agregar(libro);
		
		Bibliotecario blibliotecario = new Bibliotecario(repositorioLibros, repositorioPrestamo);

		// act
		blibliotecario.prestar(libro.getIsbn(), PRESTAMISTA, new Date() );
		try {
			
			blibliotecario.prestar(libro.getIsbn(), PRESTAMISTA, new Date());
			fail();
			
		} catch (PrestamoException e) {
			// assert
			System.out.println(e.getMessage());
			Assert.assertEquals(Bibliotecario.EL_LIBRO_NO_SE_ENCUENTRA_DISPONIBLE, e.getMessage());
		}
	}
	*/
	

}
