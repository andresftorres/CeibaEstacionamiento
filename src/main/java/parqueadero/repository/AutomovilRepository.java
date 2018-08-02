package parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import parqueadero.entidad.AutomovilEntity;

public interface AutomovilRepository extends JpaRepository<AutomovilEntity, Long> {

	@Query("SELECT a.*" + 
			"FROM Automovil a" + 
			"WHERE a.ID_AUTOMOVIL = :ID_VEHICULO")
	public AutomovilEntity obtenerVehiculoEnParqueadero(@Param("ID_VEHICULO") long idVehiculo);

}
