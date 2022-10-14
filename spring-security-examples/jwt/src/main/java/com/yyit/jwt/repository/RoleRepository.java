package com.yyit.jwt.repository;

import com.yyit.jwt.models.ERole;
import com.yyit.jwt.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}