package com.curso.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "curso")
public class Curso implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome_do_curso", nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String area;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@CreationTimestamp
	@Column(name = "data_de_criacao")
	private LocalDateTime dataDeCriacao;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@UpdateTimestamp
	@Column(name = "data_de_atualizacao")
	private LocalDateTime dataDeAtualizacao;
	
	@NotNull
	private String usuario;
	
	@Transient
	private BigDecimal valorDoCurso;
	
	@OneToMany(mappedBy = "curso")
	private List<Aluno> alunos = new ArrayList<>();

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
		this.valorDoCurso = new BigDecimal(0);
	}
	
	public Curso(String nome, String area) {
		super();
		this.nome = nome;
		this.area = area;
		this.valorDoCurso = new BigDecimal(0);
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
		return dataDeAtualizacao;
	}

	public void setDataDeCriacaoAtualizacao(LocalDateTime dataDeCriacaoAtualizacao) {
		this.dataDeAtualizacao = dataDeCriacaoAtualizacao;
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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", area=" + area + "]";
	}
}
