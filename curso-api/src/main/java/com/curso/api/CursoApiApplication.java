package com.curso.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.api.entities.Curso;
import com.curso.api.repositories.CursoRepository;

@SpringBootApplication
public class CursoApiApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(CursoApiApplication.class, args);
	}

}
