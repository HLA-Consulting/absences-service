package com.hla.absencesservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "enfant")
public class Enfant {

	@Id
	@Column(name = "id_enfant")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_enfant;

	@Column(name = "nom")
	@NotNull
	private String nom;

	@Column(name = "prenom")
	@NotNull
	private String prenom;

	@Column(name = "active")
	private boolean active;

	@ManyToOne
	@JoinColumn(name="parent_id")
	Parent parent;

	public Enfant(String nom, String prenom, boolean active, Parent parent) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.active = active;
		this.parent = parent;
	}
	

	public Enfant() {
		super();
	}


	public long getId() {
		return id_enfant;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Enfant [id=" + id_enfant + ", nom=" + nom + ", prenom=" + prenom + ", active=" + active + ", parent=" + parent
				+ "]";
	}

	public Enfant(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	
	
}