package com.gamex.minhaLojaDeGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamex.minhaLojaDeGames.model.ProdutoModel;
import com.gamex.minhaLojaDeGames.repository.ProdutoRepository;

@RequestMapping("/produtos")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	//MÉTODOS CRUD
	//GET
	
	//ALL
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> findAllProduto(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	//ID
	@GetMapping("/{i}")
	public ResponseEntity<ProdutoModel> findByIdProduto(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok (resp)).orElse(ResponseEntity.notFound().build());
	}

	//NOME
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<ProdutoModel>> findByNomeProduto(@PathVariable String nome){
		return ResponseEntity.ok(repository.findByNomeProdutoContainingIgnoreCase(nome));
	}
	
	//DESCRICAO
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<ProdutoModel>> findByDescricaoProduto(@PathVariable String descricao){
		return ResponseEntity.ok(repository.findByDescricaoProdutoContainingIgnoreCase(descricao));
	}
	
	//MARCA
	@GetMapping("/marca/{marca}")
	public ResponseEntity<List<ProdutoModel>> findByMarcaProduto(@PathVariable String marca){
		return ResponseEntity.ok(repository.findByMarcaProdutoContainingIgnoreCase(marca));
	}

	//POST
	@PostMapping
	public ResponseEntity<ProdutoModel> postProduto(@RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}

	//PUT
	@PutMapping
	public ResponseEntity<ProdutoModel> putProduto(@RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}
	
	//DELETE
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
