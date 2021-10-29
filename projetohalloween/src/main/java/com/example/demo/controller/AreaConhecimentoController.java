package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AreaConhecimento;
import com.example.demo.repository.IAreaConhecimentoRepository;

@RestController
@RequestMapping(path = "/api")
public class AreaConhecimentoController {

	@Autowired
	private IAreaConhecimentoRepository repo;

	@GetMapping(path = "/areaconhecimentos")
	public List<AreaConhecimento> getAll() {
		return this.repo.findAll();
	}

	@GetMapping(path = "/areaconhecimentos/paginado")
	public Page<AreaConhecimento> getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {
		PageRequest pr = PageRequest.of(page, size, Sort.by("Descricao"));
		Page<AreaConhecimento> lista = this.repo.findAll(pr);
		return lista;
	}

	@GetMapping(path = "/areaconhecimentos/{id}")
	public AreaConhecimento getById(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}

	@GetMapping(path = "/areaconhecimentos/{inicio}/{fim}")
	public List<AreaConhecimento> getByAreaConhecimentoIDBetween(@PathVariable Integer inicio,
			@PathVariable Integer fim) {
		return this.repo.findByAreaConhecimentoIDBetween(inicio, fim);
	}

	@GetMapping(path = "/departamentos/maiorigual/{id}")
	public List<AreaConhecimento> getByAreaConhecimentoIDGreaterThanEqual(@PathVariable Integer id) {
		return this.repo.findByAreaConhecimentoIDGreaterThanEqual(id);
	}

	@PostMapping(path = "/areaconhecimentos")
	public AreaConhecimento post(@RequestBody AreaConhecimento areaConhecimento) {
		return this.repo.save(areaConhecimento);
	}

	@DeleteMapping(path = "/areaconhecimentos/{id}")
	public void delete(@PathVariable int id) {
		if (this.repo.findById(id).orElse(null) != null)
			this.repo.deleteById(id);
	}

	@PutMapping(path = "/areaconhecimentos")
	public AreaConhecimento put(@RequestBody AreaConhecimento novaAreaConhecimento) {
		return this.repo.findById(novaAreaConhecimento.getAreaConhecimentoID()).map(area -> {
			area.setAreaConhecimentoID(novaAreaConhecimento.getAreaConhecimentoID());
			area.setDescricao(novaAreaConhecimento.getDescricao());
			return this.repo.save(area);
		}).orElse(null);

	}
}
