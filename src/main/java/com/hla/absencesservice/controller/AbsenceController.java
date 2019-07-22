package com.hla.absencesservice.controller;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hla.absencesservice.model.Absence;
import com.hla.absencesservice.service.AbsenceService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AbsenceController {

	//	@Autowired
	AbsenceService absenceService;

	public AbsenceController(AbsenceService absenceService) {
		this.absenceService = absenceService;
	}

	@GetMapping("/absences")
	public List<Absence> getAllAbsences() {
		return absenceService.getAllAbsence();
	}


	@GetMapping(value = "/absences/{id}")
	public List<Absence> findAbsenceById(@PathVariable long id) {
		return absenceService.findAbsenceById(id);
	}



	@PostMapping(value = "/absence/create")	
	public Absence postAbsence(@RequestBody Absence absence,
			@RequestParam(name = "nom_enfant") String nomEnfant,
			@RequestParam(name = "prenom_enfant") String prenomEnfant) {

		return absenceService.postAbsence(absence,nomEnfant,prenomEnfant);
	} 

	@PutMapping("/enfants/{id}")
	public ResponseEntity<Absence> updateAbsence(@PathVariable("id") long id, @RequestBody Absence absence) {

		return absenceService.updateAbsence(id,absence);
	}
}