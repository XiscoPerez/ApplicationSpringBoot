package mx.com.xisco.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.xisco.persistence.model.Direccion;

@Repository
public interface DireccionRepository extends CrudRepository<Direccion, String> {

}
