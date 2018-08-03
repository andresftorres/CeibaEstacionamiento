package parqueadero.integracion;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import parqueadero.repository.AutomovilRepository;
import parqueadero.repository.MotocicletaRepository;

public class SalidaVehiculos {	
	
	@Autowired
	AutomovilRepository automovilRepo;
	
	@Autowired
	MotocicletaRepository motocicletaRepo;
	
	@Before
	public void limpiar() {
		automovilRepo.deleteAll();
		motocicletaRepo.deleteAll();
	}
	
}
