package parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import parqueadero.entidad.MotocicletaEntity;

public interface MotocicletaRepository extends JpaRepository<MotocicletaEntity, Long> {

	@Query("SELECT a.*" + 
			"FROM Motocicleta a" + "WHERE a.ID_MOTOCLCIETA = :ID_VEHICULO")
	public MotocicletaEntity obtenerMotocicletaEnParqueadero(@Param("ID_VEHICULO") long idVehiculo);

}
