package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import application.model.Cliente;
import application.model.Pedido;
import application.service.ClienteService;
import application.service.PedidoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	private PedidoService pedidoService;
	@Autowired 
	private ClienteService clienteService;
	
	
	@RequestMapping("/visualizarPedidos")
	public ModelAndView visualizarPedidos(){
		ModelAndView mv = new ModelAndView("pedidos");
		Cliente cliente = this.obterClienteAtual();
		List<Pedido> pedidos = pedidoService.buscarPedidosPorCliente(cliente);
		mv.addObject("listaDePedidos", pedidos);
		return mv;
	}
	
	private Cliente obterClienteAtual() {
		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails user = (UserDetails) auth;		
		Cliente cliente = clienteService.buscarClientePorEmail(user.getUsername());
		return cliente;
	}
}
