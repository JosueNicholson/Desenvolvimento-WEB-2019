package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.model.Prato;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long>{

}
