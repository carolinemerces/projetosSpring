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

import com.gamex.minhaLojaDeGames.model.CategoriaModel;
import com.gamex.minhaLojaDeGames.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {

	
	@Autowired
	private CategoriaRepository repository;
	
	//MÉTODOS CRUD
	//GET
	
	//ALL
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> findAllCategoria(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	//ID
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> findByIdCategoria(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok (resp)).orElse(ResponseEntity.notFound().build());
	}
	
	//TIPO
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<CategoriaModel>> findByIdTipoCategoria(@PathVariable String tipo){
		return ResponseEntity.ok(repository.findByTipoCategoriaContainingIgnoreCase(tipo));
	}
	
	//APARELHO
	@GetMapping("/aparelho/{aparelho}")
	public ResponseEntity<List<CategoriaModel>> findByIdAparelhoCategoria(@PathVariable String aparelho){
		return ResponseEntity.ok(repository.findByAparelhoCategoriaContainingIgnoreCase(aparelho));
	}
	
	//POST
	@PostMapping
	public ResponseEntity<CategoriaModel> postCategoria (@RequestBody CategoriaModel categoria){  
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	//PUT
	@PutMapping
	public ResponseEntity<CategoriaModel> putCategoria(@RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	
	//DELETE
	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable Long id) {
		repository.deleteById(id);
	}
}


