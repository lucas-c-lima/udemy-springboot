package com.curso.api.curso;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.curso.api.entities.Curso;
import com.curso.api.services.CursoService;

class CursoTeste {
	
	@Test
	void test() {
		//fail("Not yet implemented");
	}
	
	@Test
	void testaCursosNaoVazio() {
		
		Curso c = new Curso();
		
		assertNotNull(c);
	}

	
	@Test
	void valorDoCursoNaoNulo() {
		Curso c = new Curso();
		assertNotNull(c.getValorDoCurso());
	}
	
	@Test
	void testaNovoCursoValorZero() {
		Curso curso = new Curso();
		assertEquals(new BigDecimal(0), curso.getValorDoCurso());
	}
	
	@Test
	void testaNovoCursoSemAlunos() {
		Curso curso = new Curso();		
		assertTrue(curso.getAlunos().isEmpty());
	}
}
