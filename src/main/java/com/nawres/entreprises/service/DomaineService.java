package com.nawres.entreprises.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nawres.entreprises.entities.Domaine;


public interface DomaineService {
	List<Domaine> getAllDomaines();

	Domaine saveDomaine(Domaine domaine);
	Page<Domaine> getAllDomainesParPage(int page, int size);
	void deleteDomaineById(Long id);
	Domaine getDomaine(Long id);
	
	Domaine updateDomaine(Domaine d);
}
