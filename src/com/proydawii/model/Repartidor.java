package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.proydawii.util.*;

/**
 * The persistent class for the repartidor database table.
 * 
 */
@Entity
public class Repartidor extends Identificable {

	@Column(length = 8, unique = true)
	private String dni;

	private String nombre;

	private String apellido;

	@Required
	@NoFrame @Embedded
	private Direccion direccion;
	
	@Stereotype("EMAIL")
	private String email;

	@Stereotype("TELEPHONE")
	private String telefono;

	// bi-directional many-to-one association to Tienda
	@ManyToOne(fetch = FetchType.LAZY)
	@DescriptionsList
	private Tienda tienda;

	@Stereotype("FOTO")
	private byte[] foto;

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}	
	
	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Tienda getTienda() {
		return this.tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

}