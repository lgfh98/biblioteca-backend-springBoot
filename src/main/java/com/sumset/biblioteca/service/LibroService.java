package com.sumset.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sumset.biblioteca.commons.GenericServiceImpl;
import com.sumset.biblioteca.model.Libro;
import com.sumset.biblioteca.repository.LibroRepository;

@Service
public class LibroService extends GenericServiceImpl<Libro, Long> {

	@Autowired
	LibroRepository libroRepository;

	@Override
	public JpaRepository<Libro, Long> getDao() {

		return libroRepository;
	}
}
