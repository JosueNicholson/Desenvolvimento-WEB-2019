package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import application.component.Carrinho;
import application.model.Item;
import application.model.Pedido;
import application.model.Prato;
import application.service.PratoService;


@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {
	@Autowired
	private PratoService pratoService;
	@Autowired
	private Carrinho carrinho;
	
	@RequestMapping("/adicionarItemForm/{id}")
	public ModelAndView adicionarItemForm(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("adicionarItemNoCarrinhoForm");
		Prato prato = pratoService.buscarPratoPorId(id);
		mv.addObject("prato", prato);
		return mv;
	}
	@PostMapping("/adicionarItem")
	public ModelAndView adicionarItem(@RequestParam Long id, Item item) {
		Prato prato = pratoService.buscarPratoPorId(id);
		item.setPrato(prato);
		carrinho.addItemNoCarrinho(item);
		ModelAndView mv = new ModelAndView("visualizarCarrinho");
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
	public ModelAndView finalizarPedido(@RequestParam String endereco) {
		
		Pedido pedido = new Pedido();
		pedido.setEndereco(endereco);
		pedido.setItens(carrinho.getItensDoCarrinho());

//		for (Item item : pedido.getItens()) {
//			System.out.println("item "+item.getPrato().getNome()+
//								"quantidade: "+item.getQuantidade()+
//								"valor total: "+item.getValorTotalItem());
//		}
		carrinho.getItensDoCarrinho().clear();
		carrinho.setValorTotalCarrinho(0);
		ModelAndView mv = new ModelAndView("redirect:/pedido/salvar");
		mv.addObject(pedido);
		return mv;
	}
	
}
