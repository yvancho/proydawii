package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Cliente extends Identificable {

	@Column(length = 8, unique=true)	
	@Required
	private String dni;
	
	@Column(length = 50)	
	@Required
	private String nombre;
	
	@Column(length = 50)	
	@Required
	private String apellido;	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList
	private Tipocliente tipo;
	
	@Embedded
	private Direccion direccion;

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

	public Tipocliente getTipo() {
		return tipo;
	}

	public void setTipo(Tipocliente tipo) {
		this.tipo = tipo;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	
}
