package parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import parqueadero.entidad.VehiculoEntity;

public interface VehiculoRepository extends JpaRepository<VehiculoEntity, Long>{
		
		@Query("SELECT COUNT(1) "
				+ "FROM BitacoraIngreso a"  
				+ "WHERE a.ID_VEHICULO = :ID_VEHICULO")
	public Long vehiculoEnParqueadero (@Param("ID_VEHICULO") long tarifaAplicada);

	

}
