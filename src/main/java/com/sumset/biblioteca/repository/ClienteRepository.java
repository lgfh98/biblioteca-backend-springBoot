package com.sumset.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumset.biblioteca.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
