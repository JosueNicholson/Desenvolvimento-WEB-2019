package br.com.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;

import br.com.ufc.model.Person;

public class PersonDao {
	
	public void addPerson(Person person) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(person);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}
	
	public void removePerson(Long id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = factory.createEntityManager();
		
		Person person = manager.find(Person.class, id);
		
		manager.getTransaction().begin();
		manager.remove(person);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
	}
	
	public void updatePerson(Person person) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(person);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();

	}
	
	public Person getById(Long id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = factory.createEntityManager();
		
		Person person = manager.find(Person.class, id);
		manager.close();
		factory.close();
		return person;
	}
	public List<Person> getListPerson() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = factory.createEntityManager();
		return null;
		
	}
}
