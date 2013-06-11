package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Repartidor extends Identificable {

	@Column(length = 8, unique = true)
	@Required
	private String dni;

	@Column(length = 50, nullable = false)
	@Required
	private String nombre;

	@Column(length = 50, nullable = false)
	@Required
	private String apellido;

	@Stereotype("EMAIL")
	private String email;

	@Stereotype("TELEPHONE")
	private String telefono;

	@Required
	@ManyToOne(fetch = FetchType.LAZY)
	@DescriptionsList
	private Tienda tienda;

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
