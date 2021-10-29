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


import com.example.demo.model.Cursos;
import com.example.demo.repository.ICursosRepository;

@RestController
@RequestMapping(path = "/api")
public class CursosController {

	@Autowired
	private ICursosRepository repo;

	@GetMapping(path = "/cursos")
	public List<Cursos> getAll() {
		return this.repo.findAll();
	}

	@GetMapping(path = "/cursos/paginado")
	public Page<Cursos> getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {
		PageRequest pr = PageRequest.of(page, size, Sort.by("Descricao"));
		Page<Cursos> lista = this.repo.findAll(pr);
		return lista;
	}

	@GetMapping(path = "/cursos/{id}")
	public Cursos getById(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}

	@GetMapping(path = "/cursos/{inicio}/{fim}")
	public List<Cursos> getByCursosIDBetween(@PathVariable Integer inicio,
			@PathVariable Integer fim) {
		return this.repo.findByCursoIDBetween(inicio, fim);
	}

	@GetMapping(path = "/cursos/maiorigual/{id}")
	public List<Cursos> getByCursosIDGreaterThanEqual(@PathVariable Integer id) {
		return this.repo.findByCursoIDGreaterThanEqual(id);
	}

	@PostMapping(path = "/cursos")
	public Cursos post(@RequestBody Cursos cursos) {
		return this.repo.save(cursos);
	}

	@DeleteMapping(path = "/cursos/{id}")
	public void delete(@PathVariable int id) {
		if (this.repo.findById(id).orElse(null) != null)
			this.repo.deleteById(id);
	}

	@PutMapping(path = "/cursos")
	public Cursos put(@RequestBody Cursos novoCursos) {
		return this.repo.findById(novoCursos.getCursoID()).map(area -> {
			area.setCursoID(novoCursos.getCursoID());
			area.setDescricao(novoCursos.getDescricao());
			return this.repo.save(area);
		}).orElse(null);

	}
}
