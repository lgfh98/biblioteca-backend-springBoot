package com.sumset.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumset.biblioteca.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
