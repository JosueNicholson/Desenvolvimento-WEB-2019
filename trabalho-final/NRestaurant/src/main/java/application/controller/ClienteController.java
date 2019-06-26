package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import application.model.Cliente;
import application.model.Pedido;
import application.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping("/form")
	public ModelAndView cadastrarCliente() {
		ModelAndView mv = new ModelAndView("cadastroCliente");
		mv.addObject("cliente", new Cliente());
		return mv;
	}
	@PostMapping("/salvar")
	public ModelAndView salvarCliente(@Validated Cliente cliente, BindingResult result) {
		
		ModelAndView mv = new ModelAndView("cadastroCliente");
		if(result.hasErrors()) {
			return mv;
		}
		clienteService.cadastrar(cliente);
		mv.addObject("mensagem", "Cliente cadastrado com sucesso!");
		return mv;
	}
	@RequestMapping("/listarPedidos/{id}")
	public ModelAndView listarPedidosDoCliente(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("listaDePedidos");
		Cliente cliente = clienteService.buscarClientePorId(id);
		List<Pedido> pedidosDoCliente = cliente.getPedidos();
		mv.addObject("pedidosDoCliente", pedidosDoCliente);
		return mv;
	}
	@RequestMapping("/loginForm")
	public ModelAndView loginFormulario() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	@RequestMapping("/logar")
	public ModelAndView logar() {
		ModelAndView mv = new ModelAndView("login");
//		if(result.hasErrors()) {
//			return mv;
//		}
		return mv;
	}
	@RequestMapping("/logout")
	public ModelAndView deslogar() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
}
