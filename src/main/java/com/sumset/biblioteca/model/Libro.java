package com.sumset.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Table(schema = "biblioteca")
@Data
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String titulo;

	@Column
	private String descripcion;

	@Column
	private int edad_requerida;

	@Column
	private String portada;

	@Column
	private Boolean estado;

	@ManyToOne
	@JsonIgnore
	private Categoria categoria;

	@OneToMany(mappedBy = "libro", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Prestamo> prestamos = new ArrayList<Prestamo>();
}
