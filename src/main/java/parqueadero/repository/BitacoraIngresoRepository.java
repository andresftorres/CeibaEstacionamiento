package parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import parqueadero.entidad.BitacoraIngresoEntity;

public interface BitacoraIngresoRepository extends JpaRepository<BitacoraIngresoEntity, Long>{
		
		@Query("SELECT COUNT(1) "
				+ "FROM BitacoraIngreso a INNER JOIN Vehiculo b ON a.ID_VEHICULO = b.ID_VEHICULO"
				+ "WHERE a.enParqueadero = true "
				+ "AND b.ID_CONFIG_TARIFA = :tarifaAplicada")
		public Long cantidadVehiculosXTarifa(@Param("tarifaAplicada") long tarifaAplicada);	
		
		@Query("SELECT VEHICULO_ID "
				+ "FROM BitacoraIngreso a INNER JOIN Vehiculo b ON a.ID_VEHICULO = b.ID_VEHICULO"
				+ "WHERE a.enParqueadero = true"
				+ "ANd b.placa = :placa ")
		public String vehiculoEnParqueadero(@Param("placa") String placaVehiculo);
		
}
