package parqueadero.integracion;

import org.springframework.beans.factory.annotation.Autowired;

import parqueadero.repository.AutomovilRepository;
import parqueadero.repository.VehiculoRepository;

public class SalidaVehiculos {	
	
	@Autowired
	AutomovilRepository automovilRepo;
	
	@Autowired
	VehiculoRepository motocicletaRepo;
	
	
	
}
