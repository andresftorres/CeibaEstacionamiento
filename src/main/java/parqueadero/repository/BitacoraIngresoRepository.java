package parqueadero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import parqueadero.entidad.BitacoraIngresoEntity;

@Repository
public interface BitacoraIngresoRepository extends JpaRepository<BitacoraIngresoEntity, Long> {

	@Query(value="SELECT COUNT(1)" + 
			"FROM BITACORAINGRESO A INNER JOIN VEHICULO B ON A.ID_VEHICULO = B.ID_VEHICULO " +
			"WHERE A.EN_PARQUEADERO = TRUE " +
			"AND B.TIPOVEHICULO = :TIPOVEHICULO",
			nativeQuery = true)
	public Long cantidadVehiculosporTipo(@Param("TIPOVEHICULO") String tipoVehiculo);	
	
	@Query(value="SELECT A.* " + 
			"FROM BITACORAINGRESO A INNER JOIN VEHICULO B ON A.ID_VEHICULO = B.ID_VEHICULO " +
			"WHERE A.EN_PARQUEADERO = TRUE " + 
			"AND B.PLACA = :PLACA ",
			nativeQuery = true)
	public BitacoraIngresoEntity bitacoraIngresoByPlaca(@Param("PLACA") String placaVehiculo);	
	
	@Query(value="SELECT a.* FROM BITACORAINGRESO a WHERE a.EN_PARQUEADERO = TRUE",
			nativeQuery = true)
	List<BitacoraIngresoEntity> findAllBitacorasActivas();
	
}
