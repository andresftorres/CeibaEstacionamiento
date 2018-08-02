package parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import parqueadero.entidad.TarifaParqueaderoEntity;

public interface TarifaRepository extends JpaRepository<TarifaParqueaderoEntity, Long> {

	@Query("SELECT a.*" +
			"FROM TarifaMotocicleta a " +
			"WHERE a.TIPO_VEHICULO = :TIPO_VEHICULO")
	public TarifaParqueaderoEntity obtenerTarifa (@Param("TIPO_VEHICULO") String tipoVehiculo);

}
