package com.scolay.minhaEscola;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoRepository repository;
	
	//MÉTODOS FEITOS EM AULA
	/*@GetMapping
	public List<AlunoModel> findAllAluno(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<AlunoModel> findByIdAluno(@PathVariable Long id){
		return repository.findById(id);
	}
	
	@PostMapping
	public AlunoModel postAluno(@RequestBody AlunoModel model) {
		repository.save(model);
		return model;
	}

	@PutMapping
	public AlunoModel putAluno(@PathVariable Long id, @RequestBody AlunoModel model) {
		model.setId(id);
		repository.save(model);
		return model;
	}
	
	@DeleteMapping("/{id}")
	public String deleteAluno(@PathVariable Long id) {
		repository.deleteById(id);
		return "Deletado com sucesso!";
	}
	*/
	
	//MÉTODOS FEITOS NO VÍDEO
	@GetMapping
	public ResponseEntity<List<AlunoModel>> findAllAluno(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AlunoModel> findByIdAluno(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok (resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<AlunoModel> postAluno1(@RequestBody AlunoModel aluno){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(aluno));
	}
	
	@PutMapping
	public ResponseEntity<AlunoModel> postAluno(@RequestBody AlunoModel aluno){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(aluno)); 
	}
	
	@DeleteMapping("/{id}")
	public void deleteAluno(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
