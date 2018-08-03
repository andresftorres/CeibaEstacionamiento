package parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import parqueadero.entidad.AutomovilEntity;
import parqueadero.entidad.BitacoraIngresoEntity;
import parqueadero.entidad.BitacoraSalidaEntity;
import parqueadero.entidad.MotocicletaEntity;
@Repository
public interface BitacoraSalidaRepository extends JpaRepository<BitacoraSalidaEntity, Long> {

}
