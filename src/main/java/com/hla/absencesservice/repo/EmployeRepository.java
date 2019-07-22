package com.hla.absencesservice.repo;

import org.springframework.data.repository.CrudRepository;

import com.hla.absencesservice.model.Employe;



public interface EmployeRepository extends CrudRepository<Employe, Long> {
	
}
