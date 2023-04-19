package com.example.new_project_challenge_15.repository;

import com.example.new_project_challenge_15.models.User;
import com.example.new_project_challenge_15.models.user_roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@Repository
public interface user_RolesRepo extends JpaRepository<user_roles, Long> {

}
