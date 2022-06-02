package com.nawres.entreprises.service;

import java.util.List;

import com.nawres.entreprises.entities.Role;

public interface RoleService {
	List <Role> findAll();
	Role findByRole(String role);



}
