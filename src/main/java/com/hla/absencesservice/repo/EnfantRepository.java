package com.hla.absencesservice.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hla.absencesservice.model.Enfant;

public interface EnfantRepository extends CrudRepository<Enfant, Long> {
	List<Enfant> findByPrenom(String prenom);
	List<Enfant> findByNomAndPrenom(String nom, String prenom);
}
