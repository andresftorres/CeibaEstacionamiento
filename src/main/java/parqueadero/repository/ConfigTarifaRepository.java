package parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import parqueadero.entidad.ConfigTarifasEntity;

public interface ConfigTarifaRepository extends JpaRepository<ConfigTarifasEntity, Long>{

}
