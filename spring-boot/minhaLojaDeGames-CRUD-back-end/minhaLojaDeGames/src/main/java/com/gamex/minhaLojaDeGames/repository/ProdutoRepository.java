package com.gamex.minhaLojaDeGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamex.minhaLojaDeGames.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{

	//NOME
	public List<ProdutoModel> findByNomeProdutoContainingIgnoreCase(String nome);
	
	//MARCA
	public List<ProdutoModel> findByMarcaProdutoContainingIgnoreCase(String marca);
	
	//DESCRIÇÃO
	public List<ProdutoModel> findByDescricaoProdutoContainingIgnoreCase(String descricao);

	
	
	
	
	
	
	
	
	
	
}
