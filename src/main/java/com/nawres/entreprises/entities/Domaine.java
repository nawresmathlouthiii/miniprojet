package com.nawres.entreprises.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Domaine {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idDom;
@NotNull
@Size (min = 4,max = 50)
@Column(unique=true)
private String nomDom;
private String descriptionDom;
@JsonIgnore
@OneToMany(mappedBy = "domaine")
private List<Entreprise> entreprises;
public Domaine() {}
public Domaine(String nomDom, String descriptionDom, List<Entreprise> entreprises)
{

super();
this.nomDom = nomDom;
this.descriptionDom = descriptionDom;
this.entreprises = entreprises;
}
public Long getIdDom() {
return idDom;
}
public void setIdDom(Long idDom) {
this.idDom = idDom;
}
public String getNomDom() {
return nomDom;
}
public void setNomDom(String nomDom) {
this.nomDom = nomDom;
}
public String getDescriptionDom() {
return descriptionDom;
}
public void setDescriptionDom(String descriptionDom) {
this.descriptionDom = descriptionDom;
}
public List<Entreprise> getProduits() {
return entreprises;
}
public void setProduits(List<Entreprise> entreprises) {
this.entreprises = entreprises;
}
}
