package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import application.model.Cliente;
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
//	@RequestMapping("/atualizar/{id}")
//	public ModelAndView atualizarCliente() {
//		return mv;
//	}
//	@GetMapping("/deletar/{id}")
//	public ModelAndView deletarCliente() {
//		return mv;
//	}
}
