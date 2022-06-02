package com.nawres.entreprises.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomEnt", types = { Entreprise.class })

public interface EntrepriseProjection {
	public String getNomEntreprise();

}
