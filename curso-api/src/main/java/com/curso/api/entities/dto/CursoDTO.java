package com.curso.api.entities.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CursoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	
	@NotNull
	@NotEmpty(message = "O nome está vazio")
	@Size(min = 5, max = 20)
	private String nome;
	
	@NotBlank
	private String area;
	
	public CursoDTO() {
		// TODO Auto-generated constructor stub
	}

	public CursoDTO(Integer id, String nome, String area) {
		super();
		this.id = id;
		this.nome = nome;
		this.area = area;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	
}
