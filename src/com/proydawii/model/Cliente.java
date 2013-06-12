package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
public class Cliente extends Identificable {
	
	@Required
	@Column(length=8,nullable=false,unique=true)
	private String dni;

	@Required
	@Column(nullable=false)
	private String nombre;

	@Required
	@Column(nullable=false)
	private String apellido;

	@Required
	@Column(nullable=false,length=50,unique=true)
	@Stereotype("EMAIL")
	private String email;

	@Required
	@Stereotype("TELEPHONE")
	@Column(nullable=false)
	private String telefono;

	@Required
	//bi-directional many-to-one association to Tipocliente
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList
	private Tipocliente tipocliente;

	@Required
	@NoFrame @Embedded
	private Direccion direccion;	

	public String getApellido() {
		return this.apellido;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public Tipocliente getTipocliente() {
		return this.tipocliente;
	}

	public void setTipocliente(Tipocliente tipocliente) {
		this.tipocliente = tipocliente;
	}


	
	

}