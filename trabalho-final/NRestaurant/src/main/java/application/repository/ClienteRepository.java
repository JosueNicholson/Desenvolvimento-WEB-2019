package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long> {
	Cliente findByEmail(String email);
}
