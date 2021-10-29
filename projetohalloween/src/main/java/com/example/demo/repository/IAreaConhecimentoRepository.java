package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.AreaConhecimento;

public interface IAreaConhecimentoRepository extends JpaRepository<AreaConhecimento, Integer> {

	List<AreaConhecimento> findByAreaConhecimentoIDBetween(Integer inicio, Integer fim);

	List<AreaConhecimento> findByAreaConhecimentoIDGreaterThanEqual(Integer id);

}
