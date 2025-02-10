package com.curso.database;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.database.entities.Aluno;
import com.curso.database.entities.Curso;
import com.curso.database.entities.GradeCurricular;
import com.curso.database.entities.Materia;
import com.curso.database.repositories.AlunoRepository;
import com.curso.database.repositories.CursoRepository;
import com.curso.database.repositories.GradeCurricularRepository;
import com.curso.database.repositories.MateriaRepository;

@SpringBootApplication
public class TesteDatabaseApplication implements CommandLineRunner{

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private GradeCurricularRepository gradeCurricularRepository;
	
	@Autowired
	private MateriaRepository materiaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TesteDatabaseApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Curso curso1 = new Curso("Graduacao em TI", "Exatas");
		Curso curso2 = new Curso("Graduacao em Economia", "Humanas");
		Curso curso3 = new Curso("Graduacao em Administracao", "Humanas");
		Curso curso4 = new Curso("Graduacao em Educacao Fisica", "Humanas");
		Curso curso5 = new Curso("Graduacao em EDUCACAO Continuada", "Humanas");
		Curso curso6 = new Curso("Graduacao em Fisica", "Exatas");

		cursoRepository.save(curso1);
		cursoRepository.save(curso2);
		cursoRepository.save(curso3);
		cursoRepository.save(curso4);
		cursoRepository.save(curso5);
		cursoRepository.save(curso6);
		
		Aluno aluno1 = new Aluno("Jose", curso1);
		Aluno aluno2 = new Aluno("Maria", curso1);
		Aluno aluno3 = new Aluno("Humberto", curso4);
		
		alunoRepository.save(aluno1);
		alunoRepository.save(aluno2);
		alunoRepository.save(aluno3);
		
		GradeCurricular grade1 = new GradeCurricular("Graduacao em games", aluno1);
		GradeCurricular grade2 = new GradeCurricular("Graduacao em academia de rua", aluno3);
		
		gradeCurricularRepository.save(grade1);
		gradeCurricularRepository.save(grade2);
		
		Set<GradeCurricular> gradesMateria1 = new HashSet<>();
		gradesMateria1.add(grade1);
		Materia materia1 = new Materia("Design", gradesMateria1);
		Materia materia2 = new Materia("Cultura e moda", gradesMateria1);
		materiaRepository.save(materia1);
		materiaRepository.save(materia2);
		
		
		// ----------------------------------- CURSOS -------------------------------------

		//Deletar
		//cursoRepository.delete(curso1);
		//cursoRepository.deleteById(2);
		
		//Trocar de nome
		//curso2.setNome("Graduacao em Administracao");
		//cursoRepository.save(curso2);

		//Listagem
		//List<Curso> listaDeCursos = cursoRepository.findAll();
		//listaDeCursos.forEach(curso -> System.out.println(curso));
		//System.out.println("Total de Cursos: (" + cursoRepository.count() + ")");

		//Listagem por ID
		//Optional<Curso> cursoProcurado = cursoRepository.findById(8);
		//Curso cursoFinal = cursoProcurado.orElse(null);
		//System.out.println("O Nome do curso Procurado é: "+ cursoFinal.getNome());
		
		//Listagem por nome completo
		//List<Curso> cursoPorNome = cursoRepository.findCursoByNome("Graduacao em TI");
		//cursoPorNome.forEach(curso -> System.out.println(curso));
	
		//Listagem por nome parcial
		//List<Curso> cursoPorNomeConteudo = cursoRepository.findCursoByNomeContaining("Graduacao");
		//cursoPorNomeConteudo.forEach(curso -> System.out.println(curso));
		//List<Curso> cursoPorNomeLike = cursoRepository.findCursoByNomeLike("%Econ%");
		//cursoPorNomeLike.forEach(curso -> System.out.println(curso));

		//Listagem Like com ignorar maiuscula/minuscula
//		List<Curso> cursoPorNomeLikeIgnoreCase = cursoRepository.findCursoByNomeLikeIgnoreCase("%Educ%");
//		cursoPorNomeLikeIgnoreCase.forEach(curso -> System.out.println(curso));
	
		//Listagem por query
//		List<Curso> cursoPorNomeQuery = cursoRepository.findByQueryNome();
//		cursoPorNomeQuery.forEach(curso -> System.out.println(curso));
		
		//Listagem por query de area
//		List<String> cursoPorNomeAreaQuery = cursoRepository.findByQueryNomePorArea();
//		cursoPorNomeAreaQuery.forEach(curso -> System.out.println(curso));

		//Listagem por query de área informada
//		List<String> cursoPorNomeAreaInformada = cursoRepository.findByQueryNomePorAreaInformada("Humanas");
//		cursoPorNomeAreaInformada.forEach(curso -> System.out.println(curso));
		
		//Listagem por query de área com diversos parametros
//		List<String> cursoPorNomeAreaInformada = cursoRepository.findByQueryNomePorAreaInformada("Humanas", "Graduacao em Administracao");
//		cursoPorNomeAreaInformada.forEach(curso -> System.out.println(curso));
//		List<String> cursoPorNomeAreaInformadaParametros = cursoRepository.findByQueryNomePorAreaParametros("Humanas", "Graduacao em Administracao");
//		cursoPorNomeAreaInformadaParametros.forEach(curso -> System.out.println(curso));
	}

}
