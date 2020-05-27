package com.sumset.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sumset.biblioteca.commons.GenericServiceImpl;
import com.sumset.biblioteca.model.Categoria;
import com.sumset.biblioteca.repository.CategoriaRepository;

@Service
public class CategoriaService extends GenericServiceImpl<Categoria, Long> {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Override
	public JpaRepository<Categoria, Long> getDao() {
		return categoriaRepository;
	}

}
