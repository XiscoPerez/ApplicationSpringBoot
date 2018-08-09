package mx.com.xisco.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.xisco.persistence.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, String> {
    Optional<Role> findByName(String name);
}
