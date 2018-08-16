package mx.com.xisco.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.xisco.persistence.model.Zona;

@Repository
public interface ZonaRepository  extends CrudRepository<Zona, String>{

}
