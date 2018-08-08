package parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import parqueadero.entidad.BitacoraSalidaEntity;

@Repository("bitacorasalidarepositorio")
public interface BitacoraSalidaRepository extends JpaRepository<BitacoraSalidaEntity, Long> {

}
