package mx.com.xisco.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.xisco.persistence.model.Servicio;

@Repository
public interface ServicioRepository extends CrudRepository<Servicio, String> {

}
