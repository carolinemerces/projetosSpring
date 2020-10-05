package com.servico.global;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired //obrigatório - serve para injetar - pega o repository e une com banco de dados(servicomodel)
	private ServicoRepository repository;
	
	@GetMapping("/servicos") //GET - findAll (retorna uma informação)
	public List<ServicoModel> pegarTodos(){ //faz uma lista do servicoModel e essa lista vai se unir ao select * from servicoModel (está substituindo)
		return repository.findAll();
	}
	
	@PostMapping("/servicos") // POST - INSERIR/save (requer a resposta) //@requestbody = deve colocar numa variável)
	public ServicoModel criar(@RequestBody ServicoModel model) {
		repository.save(model);
		return model;
	}
	
	@GetMapping("/servicos/nome/{nome}") //@pathvariable = procurar numa variável especifica no caso o nome //select nome from...
	public List<ServicoModel> buscarPorNome(@PathVariable String nome){
		return repository.findByNome(nome);
	}
	
	@PutMapping("/servicos/{id}")// UPDATE - UPDATE nome_tabela SET nome_coluna = valor WHERE id = 2;
	public ServicoModel atualizar(@PathVariable Long id, @RequestBody ServicoModel model) {
		model.setId(id); //NO MESMO ID VAI FAZER A ALTERAÇÃO
		repository.save(model);
		return model;
	}
	
	//método DELETE com retorn
	@DeleteMapping("/servicos/{id}")//DELETE - deleta uma linha na tabela
	public String remover(@PathVariable Long id) {
		repository.deleteById(id);
		return "sucesso";
	}
	
	/*método DELETE void
	//@DeleteMapping("/servicos/{id}")//DELETE - deleta uma linha na tabela
	//public void remover(@PathVariable Long id) {
		//repository.deleteById(id);
	}*/
	
}
