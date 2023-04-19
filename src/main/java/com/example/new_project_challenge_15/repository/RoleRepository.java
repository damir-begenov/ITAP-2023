package com.example.new_project_challenge_15.repository;

import com.example.new_project_challenge_15.models.ERole;
import com.example.new_project_challenge_15.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);

  @Query(value = "select r.name from roles r join user_roles on r.id = role_id where user_id = ?1 order by role_id desc limit 1", nativeQuery = true)
  String FindRole(Integer id);

  @Query(value = "select * from roles r join user_roles on r.id = role_id where user_id = ?1 order by role_id desc limit 1", nativeQuery = true)
  Role findRoleById(Long id);
}
