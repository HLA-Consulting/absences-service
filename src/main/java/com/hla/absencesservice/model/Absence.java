package com.hla.absencesservice.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;



@Entity
@Table(name="absence")
public class Absence {
	
		@Id
		@Column(name="id_absence")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		
		@ManyToOne
		@JoinColumn(name="enfant_id")
		//@NotNull
		private Enfant enfant;		
	
		
		@ManyToOne
		@JoinColumn(name="employe_id")
		//@NotNull
		private Employe editeur;		
	
		@Column(name="date_absence")
		//@NotNull
		private Date dateAbsence; 
		
		@Column(name="date_reprise")
		private Date dateReprise; 
		
		@Column(name="raison")
		@Length(max=299)
		private String raison; 
		
		@Column(name="commentaire")
		@Length(max=1999)
		private String commentaire;
		
		
		

		public Absence() {
			super();
		}

		

		public Absence(Enfant enfant, Employe editeur, @NotNull Date dateAbsence, @NotNull Date dateReprise,
				@Length(max = 299) String raison, @Length(max = 1999) String commentaire) {
			super();
			this.enfant = enfant;
			this.editeur = editeur;
			this.dateAbsence = dateAbsence;
			this.dateReprise = dateReprise;
			this.raison = raison;
			this.commentaire = commentaire;
		}



		public long getId() {
			return id;
		}

		public Enfant getEnfant() {
			return enfant;
		}

		public void setEnfant(Enfant enfant) {
			this.enfant = enfant;
		}

		public Employe getEditeur() {
			return editeur;
		}

		public void setEditeur(Employe editeur) {
			this.editeur = editeur;
		}

		public Date getDateAbsence() {
			return dateAbsence;
		}

		public void setDateAbsence(Date dateAbsence) {
			this.dateAbsence = dateAbsence;
		}

		
		
		public Date getDateReprise() {
			return dateReprise;
		}



		public void setDateReprise(Date dateReprise) {
			this.dateReprise = dateReprise;
		}



		public String getRaison() {
			return raison;
		}

		public void setRaison(String raison) {
			this.raison = raison;
		}

		public String getCommentaire() {
			return commentaire;
		}

		public void setCommentaire(String commentaire) {
			this.commentaire = commentaire;
		}

		@Override
		public String toString() {
			return "Absence [id=" + id + ", enfant=" + enfant + ", editeur=" + editeur + ", dateAbsence=" + dateAbsence
					+ ", dateReprise=" + dateReprise + ", raison=" + raison + ", commentaire=" + commentaire + "]";
		}

		
	
		
		
}

		
		