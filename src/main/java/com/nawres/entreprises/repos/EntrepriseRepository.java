package com.nawres.entreprises.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nawres.entreprises.entities.Domaine;
import com.nawres.entreprises.entities.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
	List<Entreprise> findByNomEntreprise(String nom);
	List<Entreprise> findByNomEntrepriseContains(String nom);
	
	@Query("select e from Entreprise e where e.nomEntreprise like %?1 and e.capital > ?2")
	List<Entreprise> findByNomCapital (String nom, Double capital);
	/*@Query("select e from Entreprise e where e.nomEntreprise like %:nom and e.capitalEntreprise > :capital")
	List<Entreprise> findByNomCapital (@Param("nom") String nom,@Param("ca^pital") Double capital);
*/
	@Query("select e from Entreprise e where e.domaine = ?1")
	List<Entreprise> findByDomaine (Domaine domaine);
	List<Entreprise> findByDomaineIdDom(Long id);
	List<Entreprise> findByOrderByNomEntrepriseAsc();
	@Query("select e from Entreprise e order by e.nomEntreprise ASC, e.capital DESC")
	List<Entreprise> trierEntreprisesNomsCapital ();
	 @Query("select e from Entreprise e where e.domaine.nomDom like ?1")
	 List<Entreprise> findByNomDomaineContains(String nom);

}