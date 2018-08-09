package mx.com.xisco.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.xisco.persistence.model.Privilege;

@Repository
public interface PrivilegeRepository extends CrudRepository<Privilege, String> {
    Optional<Privilege> findByName(String name);
}
