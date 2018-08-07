package parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import parqueadero.entidad.MotocicletaEntity;

@Repository("motocicletarepositorio")
public interface MotocicletaRepository extends JpaRepository<MotocicletaEntity, Long> {

	@Query(value="SELECT a.*" + 
			"FROM Motocicleta a" + "WHERE a.ID_MOTOCLCIETA = :ID_VEHICULO",
			nativeQuery = true)
	public MotocicletaEntity obtenerMotocicletaEnParqueadero(@Param("ID_VEHICULO") long idVehiculo);

	public MotocicletaEntity findByPlaca(String placa);
}
