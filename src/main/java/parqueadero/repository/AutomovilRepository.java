package parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import parqueadero.entidad.AutomovilEntity;

@Repository("automovilrepositorio")
public interface AutomovilRepository extends JpaRepository<AutomovilEntity, Long> {

	@Query("SELECT a.*" + 
			"FROM Automovil a" + 
			"WHERE a.ID_AUTOMOVIL = :ID_VEHICULO")
	public AutomovilEntity obtenerVehiculoRegistrado(@Param("ID_VEHICULO") Long idVehiculo);
	
	
	public AutomovilEntity findByPlaca(String placa);
	
	

}
