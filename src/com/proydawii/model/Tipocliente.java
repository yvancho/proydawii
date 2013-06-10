package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Tipocliente extends Identificable {

	@Required
	@Column(length = 50,nullable=false)	
	private String descripcion;
	
	/*
	@OneToMany(mappedBy="tipo")
	private Collection<Cliente> clientes;
*/
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
/*
	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}
	*/	
}
