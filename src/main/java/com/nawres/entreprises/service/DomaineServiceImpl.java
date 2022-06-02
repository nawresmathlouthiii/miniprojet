package com.nawres.entreprises.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nawres.entreprises.entities.Domaine;
import com.nawres.entreprises.repos.DomaineRepository;


@Service
public  class DomaineServiceImpl implements DomaineService {
	@Autowired
	DomaineRepository domaineRepository;
	
	@Override
	public List<Domaine> getAllDomaines() {
		return domaineRepository.findAll();
	}
	 @Override
	    public Domaine saveDomaine(Domaine domaine) {
	        return domaineRepository.save(domaine);
	    }
	 @Override
	    public Page<Domaine> getAllDomainesParPage(int page, int size) {
	    return domaineRepository.findAll(PageRequest.of(page, size));
	    }
	 
	 @Override
	    public void deleteDomaineById(Long id) {
	        domaineRepository.deleteById(id);
	    }
	 
	 @Override
	    public Domaine getDomaine(Long id) {
	        return domaineRepository.findById(id).get();
	    }
	 @Override
	    public Domaine updateDomaine(Domaine d) {
	        return domaineRepository.save(d);
	    }


}
