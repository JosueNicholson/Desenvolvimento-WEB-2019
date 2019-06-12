package br.com.ufc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ufc.model.Vehicle;

public class VehicleDAO {

	public void addVehicle(Vehicle vehicle) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(vehicle);
		manager.getTransaction().commit();
		
		factory.close();
		manager.close();
		
	}
	
	public void removeVehicle(Long id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crud-hibernate");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		Vehicle removedVehicle = manager.find(Vehicle.class, id);
		manager.remove(removedVehicle);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}
	
}
