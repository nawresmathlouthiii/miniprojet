package com.nawres.entreprises.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nawres.entreprises.entities.Domaine;
import com.nawres.entreprises.entities.Entreprise;
import com.nawres.entreprises.service.DomaineService;
import com.nawres.entreprises.service.EntrepriseService;


@Controller
public class EntrepriseController {
	@Autowired
	EntrepriseService entrepriseService;
	@Autowired
	DomaineService domaineService;
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("entreprise", new Entreprise());
	modelMap.addAttribute("mode", "new");
	List<Domaine> domaine = domaineService.getAllDomaines();

	modelMap.addAttribute("domaines", domaine);
	return "formEntreprise";
	}
	@RequestMapping("/saveEntreprise")
	public String saveEntreprise(@Valid Entreprise entreprise,BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formEntreprise";
	
	entrepriseService.saveEntreprise(entreprise);
	return "redirect:/ListeEntreprises";
	}
	@RequestMapping("/ListeEntreprises")
	public String listeEntreprises(ModelMap modelMap,

	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)

	{
	Page<Entreprise> prods = entrepriseService.getAllEntreprisesParPage(page, size);
	modelMap.addAttribute("entreprises", prods);

	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	List<Domaine> dmn = domaineService.getAllDomaines();
	modelMap.addAttribute("domaines", dmn);

	modelMap.addAttribute("currentPage", page);
	
	
	
	return "listeEntreprises";
	}
	
	@RequestMapping("/supprimerEntreprise")
	public String supprimerEntreprise(@RequestParam("id") Long id,

	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)

	{
	entrepriseService.deleteEntrepriseById(id);
	Page<Entreprise> prods = entrepriseService.getAllEntreprisesParPage(page,size);

	modelMap.addAttribute("entreprises", prods);
	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	List<Domaine> dmn = domaineService.getAllDomaines();
	modelMap.addAttribute("domaines", dmn);
	return "listeEntreprises";
	}
	
	@RequestMapping("/modifierEntreprise")
	public String editerEntreprise(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Entreprise e= entrepriseService.getEntreprise(id);
		modelMap.addAttribute("entreprise", e);
		modelMap.addAttribute("mode", "edit");
		
		List<Domaine> dmn = domaineService.getAllDomaines();

		modelMap.addAttribute("domaines", dmn);
		return "formEntreprise";
	}
	@RequestMapping("/updateEntreprise")
	public String updateEntreprise(@ModelAttribute("entreprise") Entreprise entreprise,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException

{
//conversion de la date

SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
Date dateCreation = dateformat.parse(String.valueOf(date));
entreprise.setDateCreation(dateCreation);
entrepriseService.updateEntreprise(entreprise);
List<Entreprise> prods = entrepriseService.getAllEntreprises();
modelMap.addAttribute("entreprises", prods);
List<Domaine> dmn = domaineService.getAllDomaines();
modelMap.addAttribute("domaines", dmn);
return "listeEntreprises";

}
	 @RequestMapping("/chercherNom")
	    public String chercherEntprise(@RequestParam("nomEntr") String nom,
	    		ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    
	    
	    {     
		 	
	    	  List <Entreprise> prods = entrepriseService.findByNomEntrepriseContains(nom);
	    	  
	    	  modelMap.addAttribute("Entreprises",prods);
	    	  List<Domaine> dmn = domaineService.getAllDomaines();
	    		modelMap.addAttribute("domaines", dmn);
	    	  /*Page<Entreprise> prod = entrepriseService.getAllEntreprisesParPage(page, size);
	    		modelMap.addAttribute("Entreprises", prod);

	    		modelMap.addAttribute("pages", new int[prod.getTotalPages()]);

	    		modelMap.addAttribute("currentPage", page);*/
	    	  return "resultat";
	    }  
	
	 @RequestMapping("/chercherDom")
	  public String chercherDom(@RequestParam("idDom") int idDom,
	    		ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {     
		 	
	    	  List <Entreprise> entreprises = entrepriseService.getAllEntreprises();
	    	  entreprises = entreprises.stream()
	                  .filter(x -> x.getDomaine().getIdDom() == idDom)
	                  .collect(Collectors.toList());
	    	  modelMap.addAttribute("entreprises",entreprises);
	    	  List<Domaine> dmn = domaineService.getAllDomaines();
	    		modelMap.addAttribute("domaines", dmn);
	    		modelMap.addAttribute("currentPage", page);
	    	  
	    	  return "listeEntreprises";
	    }  
	    
		  
}