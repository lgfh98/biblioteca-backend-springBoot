package com.sumset.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sumset.biblioteca.commons.GenericServiceImpl;
import com.sumset.biblioteca.model.Cliente;
import com.sumset.biblioteca.repository.ClienteRepository;

@Service
public class ClienteService extends GenericServiceImpl<Cliente, Long> {

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public JpaRepository<Cliente, Long> getDao() {

		return clienteRepository;
	}
}
