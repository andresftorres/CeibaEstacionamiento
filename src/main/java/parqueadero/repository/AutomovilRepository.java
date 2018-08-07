package parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import parqueadero.entidad.AutomovilEntity;

@Repository("automovilrepositorio")
public interface AutomovilRepository extends JpaRepository<AutomovilEntity, Long> {
	
	public AutomovilEntity findByPlaca(String placa);
	
	

}
