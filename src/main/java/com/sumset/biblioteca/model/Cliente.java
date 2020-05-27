package com.sumset.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(schema = "biblioteca")
@Data
public class Cliente {
	@Id
	private Long cedula;

	@Column
	private int edad;

	@Column
	private String nombre;

	@Column
	private Long telefono;

	@Column
	private String correo;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Prestamo> prestamos = new ArrayList<Prestamo>();
}
