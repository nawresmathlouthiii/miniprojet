package com.nawres.entreprises.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Entreprise {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEntreprise;
	@NotNull
	@Size (min = 4,max = 15)
	@Column(unique=true)
	private String nomEntreprise;
	@Min(value = 10)
	 @Max(value = 10000000)
	private Double capital;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;
	@ManyToOne
private Domaine domaine;
	public Domaine getDomaine() {
		return domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	public Entreprise() {
		super();
	}

	public Entreprise(String nomEntreprise, Double capital, Date dateCreation,Domaine dom) {
		super();
		this.nomEntreprise = nomEntreprise;
		this.capital= capital;
		this.dateCreation = dateCreation;
		domaine=dom;
	}

	public Long getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(Long idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public Double getCapital() {
		return capital;
	}

	public void setCapital(Double capital) {
		this.capital= capital;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Entreprise [idEntreprise=" + idEntreprise + ", nomEntreprise=" + nomEntreprise+ ", capital=" + capital
				+ ", dateCreation=" + dateCreation + ", domaine=" + domaine + "]";
	}

	
	
	
}