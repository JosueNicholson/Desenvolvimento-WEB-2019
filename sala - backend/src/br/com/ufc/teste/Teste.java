package br.com.ufc.teste;

import br.com.ufc.dao.PersonDao;
import br.com.ufc.dao.VehicleDAO;
import br.com.ufc.model.Person;
import br.com.ufc.model.Vehicle;

public class Teste {

	public static void main(String[] args) {
//		Person person = new Person();
//		person.setNome("josue");
//		person.setTelefone("88997092182");
//		
//		PersonDao pd = new PersonDao();
//		pd.addPerson(person);
		
//		pd.removePerson((long) 2);
		
		Vehicle vehicle = new Vehicle();
		vehicle.setMarca("Audi");
		vehicle.setModelo("TT");
		vehicle.setPlaca("WEB-2019");
		
		PersonDao personDAO = new PersonDao();
		Person person = personDAO.getById(3L);
		
		VehicleDAO vehicleDAO = new VehicleDAO();
		vehicleDAO.addVehicle(vehicle);
		
		vehicle.setDono(person);

		}

}
