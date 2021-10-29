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

import com.example.demo.model.Pais;
import com.example.demo.repository.IPaisRepository;

@RestController
@RequestMapping(path = "/api")
public class PaisController {

	@Autowired
	private IPaisRepository repo;

	@GetMapping(path = "/pais")
	public List<Pais> getAll() {
		return this.repo.findAll();
	}

	@GetMapping(path = "/pais/paginado")
	public Page<Pais> getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {
		PageRequest pr = PageRequest.of(page, size, Sort.by("Descricao"));
		Page<Pais> lista = this.repo.findAll(pr);
		return lista;
	}

	@GetMapping(path = "/pais/{id}")
	public Pais getById(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}

	@GetMapping(path = "/pais/{inicio}/{fim}")
	public List<Pais> getByPaisIDBetween(@PathVariable Integer inicio, @PathVariable Integer fim) {
		return this.repo.findByPaisIDBetween(inicio, fim);
	}

	@GetMapping(path = "/pais/maiorigual/{id}")
	public List<Pais> getByPaisIDGreaterThanEqual(@PathVariable Integer id) {
		return this.repo.findByPaisIDGreaterThanEqual(id);
	}

	@PostMapping(path = "/pais")
	public Pais post(@RequestBody Pais pais) {
		return this.repo.save(pais);
	}

	@DeleteMapping(path = "/pais/{id}")
	public void delete(@PathVariable int id) {
		if (this.repo.findById(id).orElse(null) != null)
			this.repo.deleteById(id);
	}

	@PutMapping(path = "/pais")
	public Pais put(@RequestBody Pais novoPais) {
		return this.repo.findById(novoPais.getPaisID()).map(pais -> {
			pais.setPaisID(novoPais.getPaisID());
			pais.setSiglaPais(novoPais.getSiglaPais());
			pais.setSiglaIdioma(novoPais.getSiglaIdioma());
			pais.setDescricao(novoPais.getDescricao());
			return this.repo.save(pais);
		}).orElse(null);

	}
}
