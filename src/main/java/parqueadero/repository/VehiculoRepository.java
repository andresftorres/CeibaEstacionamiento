package parqueadero.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import parqueadero.entidad.VehiculoEntity;

@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoEntity, Long> {

	public VehiculoEntity findByPlaca(String placa);
}
