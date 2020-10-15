package org.generation.blogPessoal.controller;

import org.generation.blogPessoal.model.Tema;
import org.generation.blogPessoal.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerGeral {
	
	//injeção no repository
	@Autowired 
	private TemaRepository repository;
	
	//redirecionamento da localhot:8080/ para localhost:8080/index
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	//redirecionamento para formTema / um get de outro jeito
	@RequestMapping(value="/cadastrarTema", method=RequestMethod.GET)
	public String form() {
		return "formTema";
	}
	
	//ao inserir um dado irá salvar e redirecionar para o formTema(/cadastrarTema) de volta
	@PostMapping(value="/cadastrarTema")
	public String form (Tema tema) {
		repository.save(tema);
		return "redirect:/cadastrarTema";
	}
	
	/*
	// abrir pagina login
	@GetMapping("/") //método de redirecionamento
	public String login() {
		return "tema";
	}*/

}
