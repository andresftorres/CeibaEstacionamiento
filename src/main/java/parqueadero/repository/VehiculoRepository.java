package parqueadero.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import parqueadero.dominio.Vehiculo;
import parqueadero.entidad.VehiculoEntity;

@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoEntity, Long> {

	public Vehiculo findByPlaca(String placa);
}
