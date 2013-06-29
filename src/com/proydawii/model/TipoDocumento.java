package com.proydawii.model;

import javax.persistence.*;

import com.proydawii.util.*;

@Entity
public class TipoDocumento extends Identificable {

	@Column(length=20,nullable=false,unique=true)
	private String descripcion;
	
	//@OneToMany(mappedBy="tipodocumento",cascade=CascadeType.ALL)
	//private Collection<Cliente> clientes = new ArrayList<Cliente>();

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
