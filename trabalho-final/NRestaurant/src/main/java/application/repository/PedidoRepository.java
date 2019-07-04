package application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.model.Cliente;
import application.model.Pedido;
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	List<Pedido> findByCliente(Cliente cliente);
}
