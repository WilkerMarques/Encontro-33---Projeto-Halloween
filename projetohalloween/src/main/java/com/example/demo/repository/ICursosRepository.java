package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Cursos;

public interface ICursosRepository extends JpaRepository<Cursos, Integer> {

	List<Cursos> findByCursoIDBetween(Integer inicio, Integer fim);

	List<Cursos> findByCursoIDGreaterThanEqual(Integer id);

}
