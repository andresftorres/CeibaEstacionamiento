package parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import parqueadero.entidad.TarifaParqueaderoEntity;
@Repository
public interface TarifaRepository extends JpaRepository<TarifaParqueaderoEntity, Long> {

	@Query("SELECT a.*" +
			"FROM Tarifa a " +
			"WHERE a.TIPO_VEHICULO = :TIPO_VEHICULO")
	public TarifaParqueaderoEntity obtenerTarifaPorTipo (@Param("TIPO_VEHICULO") String tipoVehiculo);

}
