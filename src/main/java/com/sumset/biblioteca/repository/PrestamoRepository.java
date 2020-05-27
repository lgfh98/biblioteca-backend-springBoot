package com.sumset.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumset.biblioteca.model.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long>{

}