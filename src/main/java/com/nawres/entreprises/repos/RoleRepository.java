package com.nawres.entreprises.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nawres.entreprises.entities.Role;

public interface RoleRepository  extends JpaRepository<Role, Long> {
	
	Role findByRole(String role);
	Optional<Role> findById(Long id);
	
}
