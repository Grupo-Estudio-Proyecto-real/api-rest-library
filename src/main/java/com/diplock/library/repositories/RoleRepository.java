package com.diplock.library.repositories;

import com.diplock.library.entities.Role;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, String> {
  // Optional<Role> findByName(ERole name);
}
