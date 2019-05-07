package dao;

import java.util.ArrayList;
import java.util.List;

import model.Person;

public class PersonDao {
	private static PersonDao personDao;
	private List<Person> people;
	
	public static PersonDao getInstance() {
		if(personDao == null) {
			personDao = new PersonDao();
		}
		return personDao;
	}
	
	private PersonDao() {
		this.people = new ArrayList<Person>();
		peopleDefault();
	}
	
	public void addPerson(Person person) {
		this.people.add(person);
	}
	
	public List<Person> getPersons() {
		return this.people;
	}
	
	public boolean containsPerson(Person person) {
		if(people.contains(person)) {
			return true;
		}
		return false;
	}
	
	private void peopleDefault() {
		this.people.add(new Person("josue", "123"));
		this.people.add(new Person("rafael", "321"));
	}
}
