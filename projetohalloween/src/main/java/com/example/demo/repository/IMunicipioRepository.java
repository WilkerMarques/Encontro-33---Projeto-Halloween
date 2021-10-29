package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Municipio;

public interface IMunicipioRepository extends JpaRepository<Municipio, Integer> {

	List<Municipio> findByMunicipioIDBetween(Integer inicio, Integer fim);

	List<Municipio> findByMunicipioIDGreaterThanEqual(Integer id);

}
