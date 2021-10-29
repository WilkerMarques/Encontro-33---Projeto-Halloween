package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Pais;

public interface IPaisRepository extends JpaRepository<Pais, Integer> {

	List<Pais> findByPaisIDBetween(Integer inicio, Integer fim);

	List<Pais> findByPaisIDGreaterThanEqual(Integer id);

}
