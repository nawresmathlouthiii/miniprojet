package com.nawres.entreprises;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.nawres.entreprises.entities.Domaine;
import com.nawres.entreprises.entities.Entreprise;
import com.nawres.entreprises.repos.EntrepriseRepository;
import com.nawres.entreprises.service.EntrepriseService;

@SpringBootTest
class EntreprisesApplicationTests {
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private EntrepriseService entrepriseService ;

	/*@Test
	public void testCreateEntreprise() {
		Entreprise prod = new Entreprise("PA", 2200.500, new Date());
		entrepriseRepository.save(prod);
	}*/
	
	@Test
	public void testFindEntreprise() {
		Entreprise e = entrepriseRepository.findById(1L).get();

		System.out.println(e);
	}

	@Test
	public void testUpdateEntreprise() {
		Entreprise e =entrepriseRepository.findById(1L).get();
		e.setCapital(1000.0);
		entrepriseRepository.save(e);
	}
	
	@Test
	public void testDeleteEntreprise() {
		entrepriseRepository.deleteById(1L);
		;
	}

	@Test
	public void testListerTousEntreprises() {
		List<Entreprise> prods = entrepriseRepository.findAll();
		for (Entreprise p : prods) {
			System.out.println(p);
		}

	}
	@Test
	public void testfindByDomaine()
	{
	Domaine dom = new Domaine();
	dom.setIdDom(1L);
	List<Entreprise> prods = entrepriseRepository.findByDomaine(dom);
	for (Entreprise p : prods)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testFindByNomEntrepriseContains1()
	{
	Page<Entreprise> prods = entrepriseService.getAllEntreprisesParPage(0,2);
	System.out.println(prods.getSize());
	System.out.println(prods.getTotalElements());
	System.out.println(prods.getTotalPages());
	prods.getContent().forEach(p -> {System.out.println(p.toString());
	});
	/*ou bien
	for (Entreprise p : prods)
	{
	System.out.println(p);
	} */
	}
	@Test
	public void testFindByNomEntreprise()
	{
	List<Entreprise> prods = entrepriseRepository.findByNomEntreprise("BOSS");

	for (Entreprise p : prods)
	{
	System.out.println(p);
	}

	}
	@Test
	public void testFindByNomEntrepriseContains ()
	{
	List<Entreprise> prods=entrepriseRepository.findByNomEntrepriseContains("BOSS");

	for (Entreprise p : prods)
	{
	System.out.println(p);
	} }
	@Test
	public void testfindByNomCapital()
	{
	List<Entreprise> prods = entrepriseRepository.findByNomCapital("BOSS", 220.5);
	for (Entreprise p : prods)
	{
	System.out.println(p);
	}

	}
	@Test
	public void findByDomaineIdDom()
	{
	List<Entreprise> prods =entrepriseRepository.findByDomaineIdDom(1L);
	for (Entreprise p : prods)
	{
	System.out.println(p);
	}
	 }
	@Test
	public void testfindByOrderByNomEntrepriseAsc()
	{
	List<Entreprise> prods = 
	entrepriseRepository.findByOrderByNomEntrepriseAsc();
	for (Entreprise p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testTrierEntreprisesNomsCapital()
	{
	List<Entreprise> prods = entrepriseRepository.trierEntreprisesNomsCapital();
	for (Entreprise p : prods)
	{
	System.out.println(p);
	}
	}
	
	
}