package com.hla.absencesservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "employe")
public class Employe {

	@Id
	@Column(name = "id_employe")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "nom")
	@NotNull
	private String nom;

	@Column(name = "prenom")
	@NotNull
	private String prenom;

	@Column(name = "numero_telephone")
	@Length(min=8,max=8)
	private String numeroTelephone;
	
	@Column(name = "salaire")
	private int salaire;

	
	
	
	
	
	public Employe() {
		super();
	}

	public Employe(@NotNull String nom, @NotNull String prenom, @Length(min = 8, max = 8) String numeroTelephone,
			int salaire) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numeroTelephone = numeroTelephone;
		this.salaire = salaire;
	}

	public Employe(@NotNull String nom, @NotNull String prenom, @Length(min = 8, max = 8) String numeroTelephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numeroTelephone = numeroTelephone;
	}

	public Employe(@NotNull String nom, @NotNull String prenom, int salaire) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
	}

	public Employe(@NotNull String nom, @NotNull String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public long getId() {
		return id;
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

	public String getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public int getSalaire() {
		return salaire;
	}

	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}

	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", numeroTelephone=" + numeroTelephone
				+ ", salaire=" + salaire + "]";
	}


}