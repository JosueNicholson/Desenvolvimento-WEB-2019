package application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Cliente;
import application.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void cadastrar(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	public void deletarClientePorId(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
	public Cliente buscarClientePorId(Long clienteId) {
		return clienteRepository.getOne(clienteId);
	}
}
