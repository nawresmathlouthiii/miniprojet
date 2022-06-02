package com.nawres.entreprises.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nawres.entreprises.entities.Domaine;


@RepositoryRestResource(path = "rest")
public interface DomaineRepository extends JpaRepository<Domaine, Long> {
	
}
