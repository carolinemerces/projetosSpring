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

import com.gamex.minhaLojaDeGames.model.UsuarioModel;
import com.gamex.minhaLojaDeGames.repository.UsuarioRepository;

@RequestMapping("/usuarios")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	public UsuarioRepository repository;
	
	//MÉTODOS CRUD
	//GET
	//ALL
	@GetMapping
	public ResponseEntity<List<UsuarioModel>> findAllUsuario(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	//ID
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> findByIdUsuario(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok (resp)).orElse(ResponseEntity.notFound().build());
	}
	
	//NOME
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<UsuarioModel>> findByNomeUsuario(@PathVariable String nome){
		return ResponseEntity.ok(repository.findByNomeUsuarioContainingIgnoreCase(nome));
	}
	
	//CPF
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<List<UsuarioModel>> findByCpfUsuario(@PathVariable String cpf){
		return ResponseEntity.ok(repository.findByCpfUsuarioContainingIgnoreCase(cpf));
	}
	
	//EMAIL
	@GetMapping("/email/{email}")
	public ResponseEntity<List<UsuarioModel>> findByEmailUsuario(@PathVariable String email){
		return ResponseEntity.ok(repository.findByEmailUsuarioContainingIgnoreCase(email));
	}
	
	//POST
	@PostMapping
	public ResponseEntity<UsuarioModel> postUsuario(@RequestBody UsuarioModel usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}
	
	//PUT
	@PutMapping
	public ResponseEntity<UsuarioModel> putUsuario(@RequestBody UsuarioModel usuario){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
	}
	
	//DELETE
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable Long id) {
		repository.deleteById(id);
	}
	   
}
