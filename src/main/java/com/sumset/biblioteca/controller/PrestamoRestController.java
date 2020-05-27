package com.sumset.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sumset.biblioteca.model.Cliente;
import com.sumset.biblioteca.model.Libro;
import com.sumset.biblioteca.model.Prestamo;
import com.sumset.biblioteca.service.ClienteService;
import com.sumset.biblioteca.service.LibroService;
import com.sumset.biblioteca.service.PrestamoService;

@RestController
@RequestMapping(value = "/biblioteca/prestamos")
@CrossOrigin("*")
public class PrestamoRestController {

	@Autowired
	private PrestamoService prestamoService;

	@Autowired
	private ClienteService usuarioService;

	@Autowired
	private LibroService libroService;

	@GetMapping(value = "/prestarLibro")
	public ResponseEntity<Prestamo> prestarLibro(@RequestParam Long idLibro, @RequestParam Long idCliente) {
		Libro libro = libroService.get(idLibro);
		Cliente cliente = usuarioService.get(idCliente);
		Prestamo prestamo = new Prestamo();

		if (!libro.getEstado() && (cliente.getEdad() >= libro.getEdad_requerida())) {
			prestamo.setLibro(libro);
			prestamo.setCliente(cliente);
			libro.setEstado(true);
			prestamoService.save(prestamo);
			libroService.save(libro);

			return new ResponseEntity<Prestamo>(prestamo, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Prestamo>(prestamo, HttpStatus.NOT_MODIFIED);
		}
	}
}
