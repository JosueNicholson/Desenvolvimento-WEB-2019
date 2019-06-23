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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import application.model.Prato;
import application.service.PratoService;

@Controller
@RequestMapping("/prato")
public class PratoController {

	@Autowired
	private PratoService pratoService;
	
	@RequestMapping("/cadastrar")
	public ModelAndView cadastrarPrato() {
		ModelAndView mv = new ModelAndView("cadastroPrato");
		mv.addObject("prato", new Prato());
		return mv;
	}
	@PostMapping("/salvar")
	public ModelAndView salvarPrato(@Validated Prato prato, BindingResult result, @RequestParam("imagem") MultipartFile imagem) {
		ModelAndView mv = new ModelAndView("cadastrarPrato");
		if(result.hasErrors()) {
			return mv;
		}
		pratoService.salvarPrato(prato, imagem);
		mv.addObject("mensagem", "Prato cadastrado com sucesso");
		return mv;
	}
	@RequestMapping("/atualizar/{id}")
	public ModelAndView atualizarPrato(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("algo");
		Prato prato = pratoService.buscarPratoPorId(id);
		return mv;
	}
	@GetMapping("/deletar/{id}")
	public ModelAndView deletarPrato(@PathVariable Long id) {
		pratoService.deletarPratoPorId(id);
		ModelAndView mv = new ModelAndView("redirect:/praAlgumLugar");
		return mv;
	}
	@RequestMapping("/galeria")
	public ModelAndView listarPratos() {
		ModelAndView mv = new ModelAndView("galeria");
		List<Prato> pratos = pratoService.listarPratos();
		mv.addObject("ListaDePratos", pratos);
		return mv;
	}
	
	
}
