package com.gamex.minhaLojaDeGames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class CategoriaModel {

	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	
	@NotNull
	private String tipoCategoria;
	
	@NotNull
	private String aparelhoCategoria;
	
	//RELACIONAMENTO
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL) //mappedBy = qual atributo nós estamos mapeando (atributo tema da tabela de postagem) e cascade = Todas as postagens pertencentes a tal tema sofrera alteração
	@JsonIgnoreProperties("categoria")
	private List<ProdutoModel> produto;

	//GETTERS E SETTERS
	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getTipoCategoria() {
		return tipoCategoria;
	}

	public void setTipoCategoria(String tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

	public String getAparelhoCategoria() {
		return aparelhoCategoria;
	}

	public void setAparelhoCategoria(String aparelhoCategoria) {
		this.aparelhoCategoria = aparelhoCategoria;
	}

	//GETTERS E SETTERS - RELACIONAMENTO
	public List<ProdutoModel> getProduto() {
		return produto;
	}

	public void setProduto(List<ProdutoModel> produto) {
		this.produto = produto;
	}	
	
}
