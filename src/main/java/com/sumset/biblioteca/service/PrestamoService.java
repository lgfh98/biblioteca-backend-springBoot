package com.sumset.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sumset.biblioteca.commons.GenericServiceImpl;
import com.sumset.biblioteca.model.Prestamo;
import com.sumset.biblioteca.repository.PrestamoRepository;

@Service
public class PrestamoService extends GenericServiceImpl<Prestamo, Long> {

	@Autowired
	PrestamoRepository prestamoRepository;

	@Override
	public JpaRepository<Prestamo, Long> getDao() {

		return prestamoRepository;
	}
}