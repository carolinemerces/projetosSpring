package com.servico.global;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired //obrigatório - serve para injetar - pega o repository e une com banco de dados(servicomodel)
	private ServicoRepository repository;
	
	@GetMapping("/servicos") //GET - findAll (
	public List<ServicoModel> pegarTodos(){ //faz uma lista do servicoModel e essa lista vai se unir ao select * from servicoModel (está substituindo)
		return repository.findAll();
	}
	
	@PostMapping("/servicos") // POST - save (requer a resposta)
	public ServicoModel criar(@RequestBody ServicoModel model) {
		repository.save(model);
		return model;
	}
	
	
}
