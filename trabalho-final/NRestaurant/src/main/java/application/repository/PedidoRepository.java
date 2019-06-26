package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
