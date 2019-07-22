package com.hla.absencesservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "parent")
public class Parent {

	@Id
	@Column(name = "id_parent")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "nom")
	@Length(max=30)
	@NotNull
	private String nom;

	@Column(name = "prenom")
	@Length(max=30)
	@NotNull
	private String prenom;	

	@Column(name = "profession")
	@Length(max=30)
	private String profession;

	@Column(name = "numero_telephone")
	@Length(min=8,max=8)
	private String numeroTelephone;
	
	@Column(name = "email")
	@Email
	private String email;
	
	@Column(name="methode_contact")
	@Pattern(regexp="^(email|telephone)$")
	private String methodeContact;

	
	
	public Parent() {
		super();
	}

	public Parent(@Length(max = 30) @NotNull String nom, @Length(max = 30) @NotNull String prenom,
			@Length(max = 30) String profession, @Length(min = 8, max = 8) String numeroTelephone, @Email String email,
			@Pattern(regexp = "^(email|telephone)$") String methodeContact) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.profession = profession;
		this.numeroTelephone = numeroTelephone;
		this.email = email;
		this.methodeContact = methodeContact;
	}

	public Parent(int id, @Length(max = 30) @NotNull String nom, @Length(max = 30) @NotNull String prenom,
			@Length(min = 8, max = 8) String numeroTelephone, @Email String email,
			@Pattern(regexp = "^(email|telephone)$") String methodeContact) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numeroTelephone = numeroTelephone;
		this.email = email;
		this.methodeContact = methodeContact;
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

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMethodeContact() {
		return methodeContact;
	}

	public void setMethodeContact(String methodeContact) {
		this.methodeContact = methodeContact;
	}

	@Override
	public String toString() {
		return "PARENT [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", profession=" + profession
				+ ", numeroTelephone=" + numeroTelephone + ", email=" + email + ", methodeContact=" + methodeContact
				+ "]";
	}
	
	
	
	


}