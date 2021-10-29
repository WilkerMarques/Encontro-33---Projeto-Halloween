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

import com.example.demo.model.Nomes;
import com.example.demo.repository.INomesRepository;

@RestController
@RequestMapping(path = "/api")
public class NomesController {

	@Autowired
	private INomesRepository repo;

	@GetMapping(path = "/nomes")
	public List<Nomes> getAll() {
		return this.repo.findAll();
	}

	@GetMapping(path = "/nomes/paginado")
	public Page<Nomes> getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {
		PageRequest pr = PageRequest.of(page, size, Sort.by("Nome"));
		Page<Nomes> lista = this.repo.findAll(pr);
		return lista;
	}

	@GetMapping(path = "/nomes/{id}")
	public Nomes getById(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}

	@GetMapping(path = "/nomes/{inicio}/{fim}")
	public List<Nomes> getByNomeIDBetween(@PathVariable Integer inicio, @PathVariable Integer fim) {
		return this.repo.findByNomeIDBetween(inicio, fim);
	}

	@GetMapping(path = "/nomes/maiorigual/{id}")
	public List<Nomes> getByNomeIDGreaterThanEqual(@PathVariable Integer id) {
		return this.repo.findByNomeIDGreaterThanEqual(id);
	}

	@PostMapping(path = "/nomes")
	public Nomes post(@RequestBody Nomes nomes) {
		return this.repo.save(nomes);
	}

	@DeleteMapping(path = "/nomes/{id}")
	public void delete(@PathVariable int id) {
		if (this.repo.findById(id).orElse(null) != null)
			this.repo.deleteById(id);
	}

	@PutMapping(path = "/nomes")
	public Nomes put(@RequestBody Nomes novoNomes) {
		return this.repo.findById(novoNomes.getNomeID()).map(area -> {
			area.setNomeID(novoNomes.getNomeID());
			area.setDescricao(novoNomes.getDescricao());
			return this.repo.save(area);
		}).orElse(null);

	}
}
