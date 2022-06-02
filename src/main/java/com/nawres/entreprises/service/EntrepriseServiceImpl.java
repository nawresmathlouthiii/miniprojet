package com.nawres.entreprises.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nawres.entreprises.entities.Domaine;
import com.nawres.entreprises.entities.Entreprise;
import com.nawres.entreprises.repos.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {
	@Autowired
	EntrepriseRepository entrepriseRepository;

	@Override
	public Entreprise saveEntreprise(Entreprise e) {
		return entrepriseRepository.save(e);
	}

	@Override
	public Entreprise updateEntreprise(Entreprise e) {
		return entrepriseRepository.save(e);
	}

	@Override
	public void deleteEntreprise(Entreprise e) {
		entrepriseRepository.delete(e);
	}

	@Override
	public void deleteEntrepriseById(Long id) {
		entrepriseRepository.deleteById(id);
	}

	@Override
	public Entreprise getEntreprise(Long id) {
		return entrepriseRepository.findById(id).get();
	}

	@Override
	public List<Entreprise> getAllEntreprises() {
		return entrepriseRepository.findAll();
	}
	
	@Override
	public Page<Entreprise> getAllEntreprisesParPage(int page, int size) {
	return entrepriseRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Entreprise> findByNomEntreprise(String nom) {
		// TODO Auto-generated method stub
		return entrepriseRepository.findByNomEntreprise(nom);
	}

	@Override
	public List<Entreprise> findByNomEntrepriseContains(String nom) {
		// TODO Auto-generated method stub
		return  entrepriseRepository.findByNomEntrepriseContains(nom);
	}

	@Override
	public List<Entreprise> findByNomCapital(String nom, Double capital) {
		// TODO Auto-generated method stub
		return entrepriseRepository.findByNomCapital(nom, capital);

	}

	@Override
	public List<Entreprise> findByDomaine(Domaine domaine) {
		// TODO Auto-generated method stub
		return  entrepriseRepository.findByDomaine(domaine);
	}

	@Override
	public List<Entreprise> findByDomaineIdDom(Long id) {
		// TODO Auto-generated method stub
		return entrepriseRepository.findByDomaineIdDom(id);

	}

	@Override
	public List<Entreprise> findByOrderByNomEntrepriseAsc() {
		return entrepriseRepository.findByOrderByNomEntrepriseAsc();

	}

	
	@Override
	public List<Entreprise> findByNomDomaineContains(String domaine) {
		
		return entrepriseRepository.findByNomDomaineContains(domaine);
	}

	@Override
	public List<Entreprise> trierEntreprisesNomsCapital() {
		return entrepriseRepository.trierEntreprisesNomsCapital();
	}
}
