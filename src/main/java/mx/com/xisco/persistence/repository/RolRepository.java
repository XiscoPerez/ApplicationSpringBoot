package mx.com.xisco.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.xisco.persistence.model.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, String> {
    Optional<Rol> findByNombre(String nombre);
}
