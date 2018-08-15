package mx.com.xisco.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.xisco.persistence.model.AreaServicio;

@Repository
public interface AreaServicioRepository extends CrudRepository<AreaServicio, Long>{

}
