package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import application.model.Item;
import application.model.Pedido;
import application.service.PedidoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	private PedidoService pedidoService;
	
	@RequestMapping("/salvar")
	public ModelAndView salvarPedido(Pedido pedido) {
		ModelAndView mv = new ModelAndView("pedidos");
		/*pedidoService.salvarPedido(pedido);*/
//		for (Item item : pedido.getItens()) {
//		System.out.println("item "+item.getPrato().getNome()+
//							"quantidade: "+item.getQuantidade()+
//							"valor total: "+item.getValorTotalItem());
//		}
		return mv;
	}
}
