package parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import parqueadero.entidad.AutomovilEntity;
import parqueadero.entidad.BitacoraIngresoEntity;
import parqueadero.entidad.MotocicletaEntity;

public interface BitacoraIngresoRepository extends JpaRepository<BitacoraIngresoEntity, Long> {

	@Query("SELECT COUNT(1)" + 
			"FROM BitacoraIngreso a INNER JOIN Automovil b ON a.ID_VEHICULO = b.ID_VEHICULO" +
			"WHERE a.enParqueadero = true")
	public Long cantidadAutomovilesEnParqueadero();

	@Query("SELECT COUNT(1)" + 
			"FROM BitacoraIngreso a INNER JOIN Motocicleta b ON a.ID_VEHICULO = b.ID_VEHICULO" +
			"WHERE a.enParqueadero = true")
	public Long cantidadMotocicletasEnParqueadero();

	@Query("SELECT b.* " + 
			"FROM BitacoraIngreso a INNER JOIN Automovil b ON a.ID_VEHICULO = b.ID_VEHICULO" +
			"WHERE a.enParqueadero = true" + 
			"ANd b.placa = :placa ")
	public AutomovilEntity automovilEnParqueadero(@Param("placa") String placaVehiculo);

	@Query("SELECT b.* " + 
			"FROM BitacoraIngreso a INNER JOIN Motocicleta b ON a.ID_VEHICULO = b.ID_VEHICULO" +
			"WHERE a.enParqueadero = true" + 
			"ANd b.placa = :placa ")
	public MotocicletaEntity motocicletaEnParqueadero(@Param("placa") String placaVehiculo);

}
