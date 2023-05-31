package com.et.ecommerce.repository;

import com.et.ecommerce.entity.Role;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
  /*
  //NATIVO
  @Query(value = "SELECT * FROM roles WHERE name = ?1", nativeQuery = true)
  Role findRoleByName(String name);

  //JPQL
  @Query(value = "SELECT r FROM Role r WHERE r.name = ?1")
  Role getRoleByName(String name);
  */
  //QUERY METHOD
  //Optional <Role> findById(UUID uuid);
  Optional <Role> findByName(String name);
}
