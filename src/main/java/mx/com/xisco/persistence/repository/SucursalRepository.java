package mx.com.xisco.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.xisco.persistence.model.Sucursal;

@Repository
public interface SucursalRepository extends CrudRepository<Sucursal, String> {

}
