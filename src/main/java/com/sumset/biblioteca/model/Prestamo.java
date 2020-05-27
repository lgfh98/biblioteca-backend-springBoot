package com.sumset.biblioteca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Table(schema = "biblioteca")
@Data
public class Prestamo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String fecha_prestamo;

	@Column
	private String fecha_entrega;

	@ManyToOne
	@JsonIgnore
	private Libro libro;

	@ManyToOne
	@JsonIgnore
	private Cliente cliente;
}
