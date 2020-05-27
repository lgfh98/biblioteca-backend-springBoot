package com.sumset.biblioteca.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.sumset.biblioteca.model.Cliente;
import com.sumset.biblioteca.service.ClienteService;

@RestController
@RequestMapping(value = "/biblioteca/clientes")
@CrossOrigin("*")
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "/listarClientes")
	public List<Cliente> listarClientes() {
		return clienteService.getAll();
	}

	@PostMapping(value = "/registrarCliente")
	public ResponseEntity<Cliente> registrarCliente(@RequestBody Cliente cliente) {

		Cliente nuevoCliente = clienteService.save(cliente);

		return new ResponseEntity<Cliente>(nuevoCliente, HttpStatus.CREATED);
	}

	@GetMapping(value = "/buscarCliente/{id}")
	public Cliente buscarCliente(@PathVariable Long id) {
		return clienteService.get(id);
	}

	@GetMapping(value = "/eliminarCliente/{id}")
	public ResponseEntity<Cliente> eliminarCliente(@PathVariable Long id) {

		Cliente cliente = clienteService.get(id);

		if (cliente != null) {
			clienteService.delete(id);
		} else {

			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		}

		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

}
