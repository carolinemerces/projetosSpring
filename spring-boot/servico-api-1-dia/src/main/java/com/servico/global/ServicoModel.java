package com.servico.global;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
public class ServicoModel {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE)//auto_increment
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date data;

	//getters e setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
		
}
