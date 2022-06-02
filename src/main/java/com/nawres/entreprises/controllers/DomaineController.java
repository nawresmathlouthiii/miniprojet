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
public class DomaineController {
	  @Autowired
	    DomaineService domaineService;
	  @Autowired
	    DomaineService DomaineService;
	 @RequestMapping("/CreateDomaine")
	  public String CreateDom(ModelMap modelMap)
	    {
	  
	    modelMap.addAttribute("domaine",new Domaine());
	    modelMap.addAttribute("mode","new");
	    
	    return "formDomaine";
	    }
	 
	 @RequestMapping("/saveDomaine")
	    public String saveDomaine(Domaine domaine)
	    {
	   domaineService.saveDomaine(domaine);
		return "redirect:/ListeDomaines";
	    }
	 
	 @RequestMapping("/ListeDomaines")
	    public String listeDomaines(ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {
	    	Page<Domaine> dmn = domaineService.getAllDomainesParPage(page, size);
	    	modelMap.addAttribute("domaines", dmn);
	    	modelMap.addAttribute("pages", new int[dmn.getTotalPages()]);
	    	modelMap.addAttribute("currentPage", page);
	    	return "listeDomaines";
	    }
	 
	 
	 @RequestMapping("/supprimerDomaine")
	    public String supprimerEntreprise(@RequestParam("id") Long id,
	    		ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {
	        domaineService.deleteDomaineById(id);
	        Page<Domaine> dmn = domaineService.getAllDomainesParPage(page,size);
	        		modelMap.addAttribute("domaines", dmn);
	        		modelMap.addAttribute("pages", new int[dmn.getTotalPages()]);
	        		modelMap.addAttribute("currentPage", page);
	        		modelMap.addAttribute("size", size);
	        		return "listedomaine";
	    }
	 @RequestMapping("/modifierDomaine")
	    public String editerDomaine(@RequestParam("id") Long id,ModelMap modelMap)
	    {
	    Domaine d= domaineService.getDomaine(id);
	    modelMap.addAttribute("domaine", d);
	    modelMap.addAttribute("mode", "edit");
	    return "formDomaine";
	    }
	 
	 
	 @RequestMapping("/updateDomaine")
	    public String updateDomaine(@ModelAttribute("domaine") Domaine domaine,ModelMap modelMap) throws ParseException
	    {

	        domaineService.updateDomaine(domaine);
	        List<Domaine> dmn = domaineService.getAllDomaines();
	        modelMap.addAttribute("domaines", dmn);
	        return "listedomaine";
	    }
 /*@RequestMapping("/chercherDomaine")
	
	    public String chercherDoamine(@RequestParam("nomDm") String nom,
	    		ModelMap modelMap)
	    
	    
	    {      
		 
		 		System.out.println(nom);
	    	  List <Entreprise> prods = entrepriseService.findByNomDoamineContains(nom);
	    	  System.out.println(prods);
	    	  modelMap.addAttribute("domaines",prods);
	    	  
	    	  return "chercherDm";
	    } 
	@RequestMapping("/chercherDomaine")
		
	    public String chercherDomaine(@RequestParam("nomDm") String nom,ModelMap modelMap)
	  
	    
	    {      
		 
		 		System.out.println(nom);
	    	  List <Entreprise> prods = entrepriseService.findByNomDomaineContains(nom);
	    	  System.out.println(prods);
	    	  modelMap.addAttribute("domaines",prods);
	    	  
	    	  return "chercherDm";
	    } 

*/

}
