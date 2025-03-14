package com.curso.api.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String nome;
	
	@ManyToMany
	@JoinTable(
		name = "grade_materia",
		joinColumns = {
				@JoinColumn(name = "materia_id", referencedColumnName = "id")
		},
		inverseJoinColumns = {
				@JoinColumn(name = "grade_id", referencedColumnName = "id")
		}
	)
	private Set<GradeCurricular> gradesCurriculares = new HashSet<>();
	
	public Materia() {
		// TODO Auto-generated constructor stub
	}

	public Materia(String nome, Set<GradeCurricular> gradesCurriculares) {
		super();
		this.nome = nome;
		this.gradesCurriculares = gradesCurriculares;
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

	public Set<GradeCurricular> getGradesCurriculars() {
		return gradesCurriculares;
	}

	public void setGradesCurriculars(Set<GradeCurricular> gradesCurriculares) {
		this.gradesCurriculares = gradesCurriculares;
	}
	
	
	
}
