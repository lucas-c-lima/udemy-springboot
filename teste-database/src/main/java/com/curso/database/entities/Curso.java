package com.curso.database.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "curso_faculdade")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome_do_curso", nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String area;
	
	@CreationTimestamp
	@Column(name = "data_de_criacao")
	private LocalDateTime dataDeCriacao;

	@UpdateTimestamp
	@Column(name = "data_de_atualizacao")
	private LocalDateTime dataDeCriacaoAtualizacao;
	
	@NotNull
	private String usuario;
	
	@Transient
	private BigDecimal valorDoCurso;

	@PostPersist
	private void aposPersistirDados() {
		this.nome = this.nome + " POST";
	}
	
	@PrePersist
	private void antesPersistirDados() {
		this.usuario = "Admin";
	}

	public Curso() {
		// TODO Auto-generated constructor stub
	}
	
	public Curso(String nome, String area) {
		super();
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

	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public LocalDateTime getDataDeCriacaoAtualizacao() {
		return dataDeCriacaoAtualizacao;
	}

	public void setDataDeCriacaoAtualizacao(LocalDateTime dataDeCriacaoAtualizacao) {
		this.dataDeCriacaoAtualizacao = dataDeCriacaoAtualizacao;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public BigDecimal getValorDoCurso() {
		return valorDoCurso;
	}

	public void setValorDoCurso(BigDecimal valorDoCurso) {
		this.valorDoCurso = valorDoCurso;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", area=" + area + "]";
	}
}
