package com.hla.absencesservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hla.absencesservice.model.Absence;
import com.hla.absencesservice.model.Employe;
import com.hla.absencesservice.model.Enfant;
import com.hla.absencesservice.repo.AbsenceRepository;
import com.hla.absencesservice.repo.EmployeRepository;
import com.hla.absencesservice.repo.EnfantRepository;

@Service
public class AbsenceService {
	
	@Autowired
	private AbsenceRepository absenceRepository;
	
	@Autowired
	private EnfantRepository enfantRepository;
	
	@Autowired
	private EmployeRepository employeRepository;
	
	
	public List<Absence> findAbsenceById(long id)
	{
		List<Absence> enfants = absenceRepository.findAbsenceById(id);
		return enfants;
	}
	
	public List<Absence> getAllAbsence() {
		List<Absence> absences = new ArrayList<>();
		absenceRepository.findAll().forEach(absences::add);
		
		return absences;
	}

	public Absence postAbsence(Absence absence, String nomEnfant, String prenomEnfant) {
		Absence _absence= new Absence();
		Enfant enfant = enfantRepository.findByNomAndPrenom(nomEnfant,prenomEnfant).get(0);
		Long editeurId=0L;
		Optional<Employe> editeur = employeRepository.findById(editeurId); 		// The id value is hardcoded at the moment 
																	// the id value should be got from the connected user table once the secuity is deployed
		if(!editeur.isPresent())
			System.out.println("Pas d'employe sous l'id :"+editeurId);
		else
			_absence = absenceRepository.save(new Absence(enfant,editeur.get(),absence.getDateAbsence(),
					absence.getDateReprise(),absence.getRaison(),absence.getCommentaire()));;
		return _absence;
	}

	public ResponseEntity<Absence> updateAbsence(long id, Absence absence) {

		Optional<Absence> absenceData 	 = absenceRepository.findById(id);

		if (absenceData.isPresent()) {
			Absence _absence = absenceData.get();
			_absence.setEnfant(absence.getEnfant());
			_absence.setEditeur(absence.getEditeur());
			_absence.setDateAbsence(absence.getDateAbsence());
			_absence.setDateAbsence(absence.getDateReprise());
			_absence.setRaison(absence.getRaison());
			_absence.setCommentaire(absence.getCommentaire());
			return new ResponseEntity<>(absenceRepository.save(_absence), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}

