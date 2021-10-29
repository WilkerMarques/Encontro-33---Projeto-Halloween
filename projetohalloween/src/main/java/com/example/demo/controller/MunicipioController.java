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

import com.example.demo.model.Municipio;
import com.example.demo.repository.IMunicipioRepository;

@RestController
@RequestMapping(path = "/api")
public class MunicipioController {

	@Autowired
	private IMunicipioRepository repo;

	@GetMapping(path = "/municipios")
	public List<Municipio> getAll() {
		return this.repo.findAll();
	}

	@GetMapping(path = "/municipios/paginado")
	public Page<Municipio> getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {
		PageRequest pr = PageRequest.of(page, size, Sort.by("Descricao"));
		Page<Municipio> lista = this.repo.findAll(pr);
		return lista;
	}

	@GetMapping(path = "/municipios/{id}")
	public Municipio getById(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}

	@GetMapping(path = "/municipios/{inicio}/{fim}")
	public List<Municipio> getByMunicipioIDBetween(@PathVariable Integer inicio, @PathVariable Integer fim) {
		return this.repo.findByMunicipioIDBetween(inicio, fim);
	}

	@GetMapping(path = "/municipios/maiorigual/{id}")
	public List<Municipio> getByMunicipioIDGreaterThanEqual(@PathVariable Integer id) {
		return this.repo.findByMunicipioIDGreaterThanEqual(id);
	}

	@PostMapping(path = "/municipios")
	public Municipio post(@RequestBody Municipio municipios) {
		return this.repo.save(municipios);
	}

	@DeleteMapping(path = "/municipios/{id}")
	public void delete(@PathVariable int id) {
		if (this.repo.findById(id).orElse(null) != null)
			this.repo.deleteById(id);
	}

	@PutMapping(path = "/municipios")
	public Municipio put(@RequestBody Municipio novoMunicipio) {
		return this.repo.findById(novoMunicipio.getMunicipioID()).map(muni -> {
			muni.setMunicipioID(novoMunicipio.getMunicipioID());
			muni.setDescricao(novoMunicipio.getDescricao());
			muni.setSiglaUF(novoMunicipio.getSiglaUF());
			return this.repo.save(muni);
		}).orElse(null);

	}
}
