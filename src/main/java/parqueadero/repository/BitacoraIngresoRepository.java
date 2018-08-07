package parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import parqueadero.entidad.AutomovilEntity;
import parqueadero.entidad.BitacoraIngresoEntity;
import parqueadero.entidad.MotocicletaEntity;

@Repository
public interface BitacoraIngresoRepository extends JpaRepository<BitacoraIngresoEntity, Long> {

	@Query(value="SELECT COUNT(1)" + 
			"FROM BITACORAINGRESO A INNER JOIN AUTOMOVIL B ON A.ID_VEHICULO = B.ID_VEHICULO " +
			"WHERE A.ENPARQUEADERO = TRUE ",
			nativeQuery = true)
	public Long cantidadAutomovilesEnParqueadero();

	@Query(value="SELECT COUNT(1)" + 
			"FROM BITACORAINGRESO A INNER JOIN MOTOCICLETA B ON A.ID_VEHICULO = B.ID_VEHICULO " +
			"WHERE A.ENPARQUEADERO = TRUE ",
			nativeQuery = true)
	public Long cantidadMotocicletasEnParqueadero();

	@Query(value="SELECT B.* " + 
			"FROM BITACORAINGRESO A INNER JOIN AUTOMOVIL B ON A.ID_VEHICULO = B.ID_VEHICULO " +
			"WHERE A.ENPARQUEADERO = TRUE " + 
			"AND B.PLACA = :PLACA ",
			nativeQuery = true)
	public AutomovilEntity automovilEnParqueadero(@Param("PLACA") String placaVehiculo);

	@Query(value="SELECT B.* " + 
			"FROM BITACORAINGRESO A INNER JOIN MOTOCICLETA B ON A.ID_VEHICULO = B.ID_VEHICULO " +
			"WHERE A.ENPARQUEADERO = TRUE " + 
			"AND B.PLACA = :PLACA ",
			nativeQuery = true)
	public MotocicletaEntity motocicletaEnParqueadero(@Param("PLACA") String placaVehiculo);
	
	@Query(value="SELECT A.* " + 
			"FROM BITACORAINGRESO A INNER JOIN AUTOMOVIL B ON A.ID_VEHICULO = B.ID_VEHICULO " +
			"WHERE A.ENPARQUEADERO = TRUE " + 
			"AND B.PLACA = :PLACA ",
			nativeQuery = true)
	public BitacoraIngresoEntity bitacoraIngresoAutoByPlaca(@Param("PLACA") String placaVehiculo);

	@Query(value="SELECT A.* " + 
			"FROM BITACORAINGRESO A INNER JOIN MOTOCICLETA B ON A.ID_VEHICULO = B.ID_VEHICULO " +
			"WHERE A.ENPARQUEADERO = TRUE " + 
			"AND B.PLACA = :PLACA ",
			nativeQuery = true)
	public BitacoraIngresoEntity bitacoraIngresoMotoByPlaca(@Param("PLACA") String placaVehiculo);
	
	
}
