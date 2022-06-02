package com.nawres.entreprises.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nawres.entreprises.entities.Entreprise;
import com.nawres.entreprises.service.EntrepriseService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class EntrepriseRESTController {
@Autowired
EntrepriseService entrepriseService;
@RequestMapping(method = RequestMethod.GET)
public List<Entreprise> getAllEntreprises() {
return entrepriseService.getAllEntreprises();
}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Entreprise getEntrepriseById(@PathVariable("id") Long id) {
return entrepriseService.getEntreprise(id);
 }
@RequestMapping(method = RequestMethod.POST)
public Entreprise createEntreprise(@RequestBody Entreprise entreprise) {
return entrepriseService.saveEntreprise(entreprise);
}
@RequestMapping(method = RequestMethod.PUT)
public Entreprise updateEntreprise(@RequestBody Entreprise entreprise) {
return entrepriseService.updateEntreprise(entreprise);
}
@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deleteEntreprise(@PathVariable("id") Long id)
{
	entrepriseService.deleteEntrepriseById(id);
}
@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
public List<Entreprise> getEntreprisesByDomId(@PathVariable("idDom") Long idDom) {
return entrepriseService.findByDomaineIdDom(idDom);
}



}
