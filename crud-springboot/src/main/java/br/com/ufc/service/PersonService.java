package br.com.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.ufc.model.Person;
import br.com.ufc.repository.PersonRepository;
import br.com.ufc.util.AulaFileUtils;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public void register(Person person, MultipartFile image) {
		person.setSenha(new BCryptPasswordEncoder().encode(person.getSenha()));
		
		String path = "images/"+ person.getNome() + ".png";
		AulaFileUtils.saveImage(path, image);
		personRepository.save(person);
	}
	public List<Person> returnAll(){
		return personRepository.findAll();
	}
	public void removePerson(Long codigo) {
		personRepository.deleteById(codigo);
	}
	public Person searchById(Long codigo) {
		return personRepository.getOne(codigo);
	}
}
