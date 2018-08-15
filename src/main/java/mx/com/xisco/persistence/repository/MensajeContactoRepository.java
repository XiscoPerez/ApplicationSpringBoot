package mx.com.xisco.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.xisco.persistence.model.MensajeContacto;

@Repository
public interface MensajeContactoRepository extends CrudRepository<MensajeContacto, String> {

}
