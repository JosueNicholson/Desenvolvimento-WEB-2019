package br.com.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	Person findByLogin(String login);
	
}
