package com.gamex.minhaLojaDeGames.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamex.minhaLojaDeGames.model.CategoriaModel;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{

	//TIPO
	public List<CategoriaModel> findByTipoCategoriaContainingIgnoreCase (String tipo);
	
	//APARELHO
	public List<CategoriaModel> findByAparelhoCategoriaContainingIgnoreCase (String aparelho);
	

	
}
