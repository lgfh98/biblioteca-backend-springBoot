package com.sumset.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumset.biblioteca.model.Categoria;
import com.sumset.biblioteca.service.CategoriaService;

@RestController
@RequestMapping(value = "/biblioteca/categorias")
@CrossOrigin("*")
public class CategoriaRestController {

	@Autowired
	private CategoriaService categoriaService;

	@PostMapping(value = "/registrarCategoria")
	public ResponseEntity<Categoria> registrarCategoria(@RequestBody Categoria categoria) {

		Categoria nuevaCategoria = categoriaService.save(categoria);

		return new ResponseEntity<Categoria>(nuevaCategoria, HttpStatus.CREATED);
	}
}
