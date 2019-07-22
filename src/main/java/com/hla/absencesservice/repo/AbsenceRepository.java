package com.hla.absencesservice.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hla.absencesservice.model.Absence;



public interface AbsenceRepository extends CrudRepository<Absence, Long> {
	
	Optional<Absence> findById(long id);
	@SuppressWarnings("unchecked")
	Absence save(Absence absence);
	List<Absence> findAbsenceById(long id);
}
