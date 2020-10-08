package com.gamex.minhaLojaDeGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamex.minhaLojaDeGames.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

	//NOME
	public List<UsuarioModel> findByNomeUsuarioContainingIgnoreCase(String nome);
	
	//CPF
	public List<UsuarioModel> findByCpfUsuarioContainingIgnoreCase(String cpf);
	
	//EMAIL
	public List<UsuarioModel> findByEmailUsuarioContainingIgnoreCase(String email);
	
	
	
}
