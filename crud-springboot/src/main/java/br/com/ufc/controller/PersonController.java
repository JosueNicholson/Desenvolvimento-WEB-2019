package br.com.ufc.controller;

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

import br.com.ufc.model.Person;
import br.com.ufc.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonService pessoaService;
	
	@RequestMapping("/form")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("form");
		mv.addObject("pessoa", new Person());
		return mv;
	}
	
	@PostMapping("/save")
	public ModelAndView register(@Validated Person person, BindingResult result, @RequestParam("imagem") MultipartFile image) {
		ModelAndView mv = new ModelAndView("form");
		if(result.hasErrors()) {
			return mv;
		}
		pessoaService.register(person, image);
		mv.addObject("mensagem","Pessoa cadastrada com sucesso");
		return mv;
	}
	@RequestMapping("/list")
	public ModelAndView listPeople() {
		List<Person> people = pessoaService.returnAll();
		ModelAndView mv = new ModelAndView("pagina-listagem");
		mv.addObject("listaDePessoas", people);
		return mv;
	}
	@GetMapping("/remove/{codigo}")
	public ModelAndView removePerson(@PathVariable Long codigo) {
		pessoaService.removePerson(codigo);
		ModelAndView mv = new ModelAndView("redirect:/person/list");
		return mv;
	}
	@RequestMapping("/update/{codigo}")
	public ModelAndView updatePerson(@PathVariable Long codigo) {
		Person pessoa = pessoaService.searchById(codigo);
		ModelAndView mv = new ModelAndView("form");
		mv.addObject("pessoa", pessoa);
		return mv;
	}
	@RequestMapping("/logar")
	public ModelAndView formLogin() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	@RequestMapping("/")
	public String olamundo() {
		return "olamundo";
	}
}
