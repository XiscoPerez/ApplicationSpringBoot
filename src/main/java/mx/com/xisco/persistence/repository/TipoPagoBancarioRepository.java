package mx.com.xisco.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.xisco.persistence.model.TipoPagoBancario;

@Repository
public interface TipoPagoBancarioRepository extends CrudRepository<TipoPagoBancario, String>  {

}
