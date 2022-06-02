package com.nawres.entreprises.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nawres.entreprises.entities.Domaine;
import com.nawres.entreprises.entities.Entreprise;

public interface EntrepriseService {

	Entreprise saveEntreprise(Entreprise e);
	Entreprise updateEntreprise(Entreprise e);
	void deleteEntreprise(Entreprise e);
	void deleteEntrepriseById(Long id);
	Entreprise getEntreprise(Long id);
	List<Entreprise> getAllEntreprises();
	List<Entreprise> findByNomEntreprise(String nom);
	List<Entreprise> findByNomEntrepriseContains(String nom);
	List<Entreprise> findByNomCapital (String nom, Double capital);
	List<Entreprise> findByDomaine (Domaine domaine);
	List<Entreprise> findByDomaineIdDom(Long id);
	List<Entreprise> findByOrderByNomEntrepriseAsc();
	List<Entreprise> trierEntreprisesNomsCapital();
	List<Entreprise> findByNomDomaineContains (String nom);

	
	
	Page<Entreprise> getAllEntreprisesParPage(int page, int size);
}
