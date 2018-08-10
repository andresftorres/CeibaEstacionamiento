package parqueadero.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import parqueadero.entidad.VehiculoEntity;

@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoEntity, Long> {

	@Query(value="SELECT B.* " + 
			"FROM VEHICULO B " +
			"WHERE B.PLACA = :PLACA"
			,nativeQuery=true)
	public VehiculoEntity buscarPorPlaca(@Param("PLACA") String placa);
	
	@Query(value="SELECT B.* " + 
			"FROM BITACORAINGRESO A INNER JOIN VEHICULO B ON A.ID_VEHICULO = B.ID_VEHICULO " +
			"WHERE A.EN_PARQUEADERO = TRUE " + 
			"AND B.PLACA = :PLACA ",
			nativeQuery = true)
	public VehiculoEntity vehiculoEnParqueadero(@Param("PLACA") String placaVehiculo);	
	
}
