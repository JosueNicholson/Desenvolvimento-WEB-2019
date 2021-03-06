package application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Cliente;
import application.model.Pedido;
import application.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public void salvarPedido(Pedido pedido) {
		float total = pedido.getValorTotalPedido();
		pedido.setValorTotalPedido(total);
		pedidoRepository.save(pedido);
	}
	public void deletarPedido(Long id) {
		pedidoRepository.deleteById(id);
	}
	public List<Pedido> listarPedidos(){
		return pedidoRepository.findAll();
	}
	public Pedido buscarPedidoPorId(Long id) {
		return pedidoRepository.getOne(id);
	}
	public List<Pedido> buscarPedidosPorCliente(Cliente cliente){
		return pedidoRepository.findByCliente(cliente);
	}
}
