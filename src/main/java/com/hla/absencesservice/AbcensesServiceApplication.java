package com.hla.absencesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages="com.hla.absencesservice")
@SpringBootApplication
public class AbcensesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcensesServiceApplication.class, args);
	}
}
