package org.lp.dasi.nosql.tp1.model;

import java.math.BigDecimal;
import java.util.Date;

import org.lp.dasi.nosql.tp1.model.enumeration.MotifSuppression;
import org.springframework.data.annotation.Id;

public class Employe {

	public static final String TABLE = "employe";
	/**
	 * id will be used for storing MongoDB _id
	 */
	@Id
	private String id;

	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String poste;
	private BigDecimal Salaire;
	private Date dateEntree;
	private Date dateSortie;
	private MotifSuppression motifSuppression;
	private String photo;
	private Long numeroEmploye;
	private String mail;

	public Employe() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public BigDecimal getSalaire() {
		return Salaire;
	}

	public void setSalaire(BigDecimal salaire) {
		Salaire = salaire;
	}

	public Date getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public MotifSuppression getMotifSuppression() {
		return motifSuppression;
	}

	public void setMotifSuppression(MotifSuppression motifSuppression) {
		this.motifSuppression = motifSuppression;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String pathAvatar) {
		this.photo = pathAvatar;
	}

	public Long getNumeroEmploye() {
		return numeroEmploye;
	}

	public void setNumeroEmploye(Long numeroEmploye) {
		this.numeroEmploye = numeroEmploye;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
