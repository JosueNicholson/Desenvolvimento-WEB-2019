package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import application.component.Carrinho;
import application.model.Cliente;
import application.model.Item;
import application.model.Pedido;
import application.model.Prato;
import application.service.ClienteService;
import application.service.ItemService;
import application.service.PedidoService;
import application.service.PratoService;


@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private PratoService pratoService;
	@Autowired
	private Carrinho carrinho;
	@Autowired
	private ItemService itemService;
	@Autowired 
	private ClienteService clienteService;
	
	@RequestMapping("/adicionarItemForm/{id}")
	public ModelAndView adicionarItemForm(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("adicionarItemNoCarrinhoForm");
		Prato prato = pratoService.buscarPratoPorId(id);
		System.out.println(prato.getNome()+" "+ prato.getId()+" "+ prato.getValor());
		mv.addObject("prato", prato);
		return mv;
	}
	@PostMapping("/adicionarItem")
	public ModelAndView adicionarItem(@RequestParam Long id, @RequestParam int quantidade) {
		Prato prato = pratoService.buscarPratoPorId(id);
		Item item = new Item();
		item.setQuantidade(quantidade);
		item.setPrato(prato);
		carrinho.addItemNoCarrinho(item);
		
		ModelAndView mv = new ModelAndView("redirect:/carrinho/visualizarCarrinho");
		mv.addObject("listaDeItens",carrinho.getItensDoCarrinho());
		return mv;
		
	}
	@GetMapping("/removerItem/{id}")
	public ModelAndView removerItem(@PathVariable int id) {
		Item itemRemovido = new Item();
		for (Item item: carrinho.getItensDoCarrinho()) {
			if(item.getId()==id) {
				itemRemovido = item;
			}
		}
		carrinho.getItensDoCarrinho().remove(itemRemovido);
		ModelAndView mv = new ModelAndView("redirect:/carrinho/visualizarCarrinho");
		return mv;
	}
	@RequestMapping("/visualizarCarrinho")
	public ModelAndView visualizarCarrinho() {
		ModelAndView mv = new ModelAndView("visualizarCarrinho");
		mv.addObject("listaDeItens", carrinho.getItensDoCarrinho());
		return mv;
	}
	@RequestMapping("/finalizarPedido")
	public ModelAndView finalizarPedido(@RequestParam String enderecoPedido) {
		
		Pedido pedido = new Pedido();
		pedido.setEndereco(enderecoPedido);
		pedido.setItens(carrinho.getItensDoCarrinho());
		for (Item item : carrinho.getItensDoCarrinho()) {
			item.setPedido(pedido);
			System.out.println(item.toString()); 
		}
		itemService.salvarListaDeItens(carrinho.getItensDoCarrinho());
		
		ModelAndView mv = new ModelAndView("pedidos");
		Cliente cliente = this.obterClienteAtual();
		pedido.setCliente(cliente);
		pedidoService.salvarPedido(pedido);
		List<Pedido> pedidos = pedidoService.buscarPedidosPorCliente(cliente);
		mv.addObject("listaDePedidos", pedidos);

		carrinho.getItensDoCarrinho().clear();
		carrinho.setValorTotalCarrinho(0);
		return mv;
	}
	private Cliente obterClienteAtual() {
		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails user = (UserDetails) auth;		
		Cliente cliente = clienteService.buscarClientePorEmail(user.getUsername());
		return cliente;
	}
}
