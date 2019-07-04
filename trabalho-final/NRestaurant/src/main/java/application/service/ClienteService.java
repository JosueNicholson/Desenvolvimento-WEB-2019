package application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import application.model.Cliente;
import application.model.Role;
import application.repository.ClienteRepository;
import application.repository.RoleRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired 
	private RoleRepository roleRepository;
	
	public void cadastrar(Cliente cliente) {
		
		List<Role> roles = new ArrayList<>();
		roles.add(roleRepository.getOne("ROLE_USER"));
		cliente.setRoles(roles);
		cliente.setSenha(new BCryptPasswordEncoder().encode(cliente.getSenha()));
		clienteRepository.save(cliente);
	}
	public void deletarClientePorId(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
	public Cliente buscarClientePorId(Long clienteId) {
		return clienteRepository.getOne(clienteId);
	}
	public Cliente buscarClientePorEmail(String email) {
		return clienteRepository.findByEmail(email);
	}
}
