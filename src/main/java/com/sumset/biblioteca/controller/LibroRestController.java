package com.sumset.biblioteca.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sumset.biblioteca.model.Categoria;
import com.sumset.biblioteca.model.Libro;
import com.sumset.biblioteca.service.CategoriaService;
import com.sumset.biblioteca.service.LibroService;

@RestController
@RequestMapping(value = "/biblioteca/libros")
@CrossOrigin("*")
public class LibroRestController {

	@Autowired
	private LibroService libroService;

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping(value = "/listarLibros")
	public List<Libro> listarLibros() {
		return libroService.getAll();
	}

	@GetMapping(value = "/listarLibrosDisponibles")
	public List<Libro> listarLibrosDisponibles() {

		List<Libro> libros = libroService.getAll();
		List<Libro> disponibles = new ArrayList<Libro>();

		for (Libro libro : libros) {
			if (!libro.getEstado()) {
				disponibles.add(libro);
			}
		}

		return disponibles;
	}

	@GetMapping(value = "/listarLibrosReservados")
	public List<Libro> listarLibrosReservados() {

		List<Libro> libros = libroService.getAll();
		List<Libro> reservados = new ArrayList<Libro>();

		for (Libro libro : libros) {
			if (libro.getEstado()) {
				reservados.add(libro);
			}
		}

		return reservados;
	}

	@PostMapping(value = "/registrarLibro")
	public ResponseEntity<Libro> registrarLibro(@RequestParam Long idCategoria, @RequestBody Libro libro) {

		Categoria categoria = categoriaService.get(idCategoria);
		libro.setCategoria(categoria);

		Libro nuevoLibro = libroService.save(libro);

		return new ResponseEntity<Libro>(nuevoLibro, HttpStatus.CREATED);
	}

	@GetMapping(value = "/buscarLibro/{id}")
	public Libro buscarLibro(@PathVariable Long id) {
		return libroService.get(id);
	}

	@GetMapping(value = "/eliminarLibro/{id}")
	public ResponseEntity<Libro> eliminarLibro(@PathVariable Long id) {

		Libro libro = libroService.get(id);

		if (libro != null) {
			libroService.delete(id);
		} else {

			return new ResponseEntity<Libro>(libro, HttpStatus.OK);
		}

		return new ResponseEntity<Libro>(libro, HttpStatus.OK);
	}

}